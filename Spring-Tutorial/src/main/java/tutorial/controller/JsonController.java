package tutorial.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JsonController {
	
	@RequestMapping(value = "/jsonList")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("json/jsonList");
		return modelandview;
	}
}
