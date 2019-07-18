package tutorial.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.xml.rpc.holders.StringHolder;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tutorial.webProvider.Results;
import tutorial.webProvider.WebProvider_PortType;
import tutorial.webProvider.holders.ResultsArrayHolder;


@Controller
@EnableScheduling
public class MonitorController {
	@Inject WebProvider_PortType portType;
	
	@RequestMapping(value = "/openMonitorList")
	public ModelAndView MonitorList(Map<String, Object> commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("monitor/monitorList");
		
		StringHolder msg = new StringHolder();
		ResultsArrayHolder results = new ResultsArrayHolder();
		portType.requestMonitor(results, msg);
		List<Results> list = new ArrayList<Results>();
		Results[] rls = results.value;
		System.out.println("message: " + msg.value);
		for (int i = 0; i < rls.length; i++) {
				list.add(rls[i]);
		}
		modelandview.addObject("list", list);
	
		return modelandview;
	}
}
