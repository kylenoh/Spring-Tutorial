package tutorial.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.xml.rpc.holders.StringHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tutorial.webProvider.Results;
import tutorial.webProvider.WebProvider_PortType;
import tutorial.webProvider.holders.ResultsArrayHolder;


@Controller
public class JsonController {
	@Inject WebProvider_PortType portType;
	
	@RequestMapping(value = "/jsonList")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("json/jsonList");
		String aa ="11";
		String bb ="22";
		String cc ="33";
		StringHolder message = new StringHolder();
		ResultsArrayHolder results = new ResultsArrayHolder();
		portType.responseService(aa, bb, cc, message, results);
		Results[] rls = results.value;
		System.out.println("message: " + message.value);
		for (int i = 0; i < rls.length; i++) {
			System.out.println("[" + i + "] CATE_SECTION_NAME: " + rls[i].getCATE_SECTION_NAME());
		}
		
		return modelandview;
	}
}
