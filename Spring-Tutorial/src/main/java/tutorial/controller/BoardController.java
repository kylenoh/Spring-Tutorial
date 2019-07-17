package tutorial.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tutorial.common.CommandMap;
import tutorial.service.BoardService;

@Controller
public class BoardController {

	@Inject
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String index() {
		return "portal/portalMain";
	}

//	페이지 이동
	@RequestMapping(value = "/openBoardList")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("board/boardList");
		return modelandview;
	}
	@RequestMapping(value="/selectBoardList")
    public ModelAndView selectBoardList(CommandMap commandMap) throws Exception{
    	ModelAndView modelandview = new ModelAndView("jsonView");
    	System.out.println("시작페이지"+commandMap.get("PAGE_INDEX"));
    	System.out.println("종료페이지"+commandMap.get("PAGE_ROW"));
    	List<Map<String,Object>> list = boardService.selectBoardList(commandMap.getMap());
    	modelandview.addObject("list", list);
    	if(list.size() > 0){
    		modelandview.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
    	}
    	else{
    		modelandview.addObject("TOTAL", 0);
    	}
    	
    	return modelandview;
    }
	@RequestMapping(value = "/openBoardWrite")
	public ModelAndView BoardWrite(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("/board/boardWrite");
		return modelandview;
	}
	@RequestMapping(value = "/openBoardUpdate")
	public ModelAndView boardUpdate(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("board/boardUpdate");
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		modelandview.addObject("map", map.get("map"));
		modelandview.addObject("list", map.get("list"));
		return modelandview;
	}
	@RequestMapping(value = "/openBoardDetail")
	public ModelAndView BoardDetail(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("/board/boardDetail");
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		logger.debug("확인" + map.get("IDX"));
		modelandview.addObject("map", map.get("map"));
		modelandview.addObject("list", map.get("list"));

		return modelandview;
	}

//	쿼리 실행
	@RequestMapping(value = "/insertBoard")
	public ModelAndView InsertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView modelandview = new ModelAndView("redirect:/openBoardList");
		boardService.insertBoard(commandMap.getMap(), request);
		return modelandview;
	}
	@RequestMapping(value = "/updateBoard")
	public ModelAndView UpdateBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView modelandview = new ModelAndView("redirect:/openBoardDetail");
		boardService.updateBoard(commandMap.getMap(), request);
		modelandview.addObject("IDX", commandMap.get("IDX"));
		return modelandview;
	}
	@RequestMapping(value = "/deleteBoard")
	public ModelAndView DeleteBoard(CommandMap commandMap) throws Exception {
		ModelAndView modelandview = new ModelAndView("redirect:/openBoardList");
		boardService.deleteBoard(commandMap.getMap());
		return modelandview;
	}
	@RequestMapping(value = "/downloadFile")
	public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception {
		Map<String, Object> map = boardService.selectFileInfo(commandMap.getMap());
		String storedFileName = (String) map.get("STORED_FILE_NAME");
		String originalFileName = (String) map.get("ORIGINAL_FILE_NAME");
		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\file\\" + storedFileName));
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

}
