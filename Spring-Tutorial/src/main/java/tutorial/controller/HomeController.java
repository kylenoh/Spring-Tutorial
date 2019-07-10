package tutorial.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tutorial.common.CommandMap;
import tutorial.service.BoardService;

@Controller
public class HomeController {

	@Inject
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String index() {
		logger.debug("로그가 고장이 났나봐요");
		return "portal/portalMain";
	}

	@RequestMapping(value = "/boardList")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		logger.debug("보더로 이동");
		ModelAndView modelandview = new ModelAndView("board/boardList");
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap);
		modelandview.addObject("list", list);
		return modelandview;
	}

	@RequestMapping(value = "/boardWrite")
	public ModelAndView BoardWrite(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("/board/boardWrite");
		return modelandview;
	}

}
