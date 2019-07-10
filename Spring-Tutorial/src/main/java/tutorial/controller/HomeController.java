package tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/portal/main", method = RequestMethod.GET)
	public String home() {
		logger.info("Welcome home! The client locale is .");
		return "portal/portalMain";
	}
	
	@RequestMapping(value = "/portal/boardList", method = RequestMethod.GET)
	public String boardList() {
		logger.debug("보드 리스트");
		System.out.println("여기 왜안오지?");
		return "board/boardList";
	}
	
}
