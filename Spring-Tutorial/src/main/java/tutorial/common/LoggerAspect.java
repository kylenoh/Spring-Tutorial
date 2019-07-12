package tutorial.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {
	protected Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	static String name = "";
	static String type = "";
	
//	Around선언 = 조인포인트의 모든 과정에 수행되는 advice(조인 포인트에 삽입되어 동작하는 코드) -> 조인포인트(삽입될 위치)
//	execution = 포인트컷(조인포인트 선택기준이나 기능)
	
	@Around("execution(* tutorial..controller.*Controller.*(..)) or execution(* tutorial..service.*Impl.*(..)) or execution(* tutorial..dao.*DAO.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		type = joinPoint.getSignature().getDeclaringTypeName();
		if (type.indexOf("Controller") > -1) {
			name = "Controller \t: ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl \t: ";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAO \t\t: ";
		}
		logger.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
		return joinPoint.proceed();
	}

}
