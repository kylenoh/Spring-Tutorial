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
		return "portal/portalMain";
	}

	@RequestMapping(value = "/boardList")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("board/boardList");
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap);
		modelandview.addObject("list", list);
		return modelandview;
	}
	@RequestMapping(value = "/boardWrite")
	public ModelAndView BoardWrite(CommandMap commandMap) throws Exception {
		logger.debug("이거안함?");
		ModelAndView modelandview = new ModelAndView("/board/boardWrite");
		return modelandview;
	}
	@RequestMapping(value = "/boardUpdate")
	public ModelAndView boardUpdate(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("/board/boardUpdate");
		Map<String, Object>map = boardService.selectBoardDetail(commandMap.getMap());
		modelandview.addObject("map",map);
		return modelandview;
	}
	
	
	@RequestMapping(value = "/insertBoard")
	public ModelAndView InsertBoard(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("redirect:/boardList");
		boardService.insertBoard(commandMap.getMap());
		return modelandview;
	}
	@RequestMapping(value = "/boardDetail")
	public ModelAndView BoardDetail(CommandMap commandMap) throws Exception {
		logger.debug("이거안함?");
		ModelAndView modelandview = new ModelAndView("/board/boardDetail");
		Map<String, Object>map = boardService.selectBoardDetail(commandMap.getMap());
		modelandview.addObject("map",map);
		return modelandview;
	}
	@RequestMapping(value = "/updateBoard")
	public ModelAndView UpdateBoard(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("redirect:/boardDetail");
		boardService.updateBoard(commandMap.getMap());
		modelandview.addObject("IDX",commandMap.get("IDX"));
		return modelandview;
	}
	@RequestMapping(value = "/deleteBoard")
	public ModelAndView DeleteBoard(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("redirect:/boardList");
		boardService.deleteBoard(commandMap.getMap());
		return modelandview;
	}

}
