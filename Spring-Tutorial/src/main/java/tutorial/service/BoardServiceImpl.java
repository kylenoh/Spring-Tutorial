package tutorial.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tutorial.controller.BoardController;
import tutorial.dao.BoardDAO;
import tutorial.util.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {
	Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	BoardDAO boardDAO;
	@Inject
	FileUtils fileUtils;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		String strPageIndex = (String) map.get("PAGE_INDEX");
		String strPageRow = (String) map.get("PAGE_ROW");
		int nPageIndex = 0;
		int nPageRow = 20;
		if (StringUtils.isEmpty(strPageIndex) == false) {
			nPageIndex = Integer.parseInt(strPageIndex) - 1;
		}
		if (StringUtils.isEmpty(strPageRow) == false) {
			nPageRow = Integer.parseInt(strPageRow);
		}
		map.put("START", (nPageIndex * nPageRow) + 1);
		map.put("END", (nPageIndex * nPageRow) + nPageRow);
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		boardDAO.insertBoard(map);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(map, request);
		for (int i = 0, size = list.size(); i < size; i++) {
			boardDAO.insertFile(list.get(i));
		}

	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		boardDAO.updateHitCnt(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = boardDAO.selectBoardDetail(map);
		resultMap.put("map", tempMap);
		List<Map<String, Object>> list = boardDAO.selectFileList(map);
		resultMap.put("list", list);
		return resultMap;
	}

	@Override
	public void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		boardDAO.updateBoard(map);

		boardDAO.deleteFileList(map);
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(map, request);
		Map<String, Object> tempMap = null;
		for (int i = 0, size = list.size(); i < size; i++) {
			tempMap = list.get(i);
			if (tempMap.get("IS_NEW").equals("Y")) {
				boardDAO.insertFile(tempMap);
			} else {
				boardDAO.updateFile(tempMap);
			}
		}

	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		boardDAO.deleteBoard(map);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object selectPagingList(String queryId, Object params) throws Exception {
		printQueryId(queryId);
		Map<String, Object> map = (Map<String, Object>) params;
		String strPageIndex = (String) map.get("PAGE_INDEX");
		String strPageRow = (String) map.get("PAGE_ROW");
		int nPageIndex = 0;
		int nPageRow = 20;
		if (StringUtils.isEmpty(strPageIndex) == false) {
			nPageIndex = Integer.parseInt(strPageIndex) - 1;
		}
		if (StringUtils.isEmpty(strPageRow) == false) {
			nPageRow = Integer.parseInt(strPageRow);
		}
		map.put("START", (nPageIndex * nPageRow) + 1);
		map.put("END", (nPageIndex * nPageRow) + nPageRow);
		return boardDAO.selectPagingList(queryId, map);

	}

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return boardDAO.selectFileInfo(map);
	}

	private void printQueryId(String queryId) {
		if(logger.isDebugEnabled()){
			logger.debug("\t QueryId  \t:  " + queryId);
		}
	}
}
