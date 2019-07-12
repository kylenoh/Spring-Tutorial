package tutorial.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tutorial.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDAO;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		boardDAO.insertBoard(map);
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		boardDAO.updateHitCnt(map);
		return boardDAO.selectBoardDetail(map);
	}

	@Override
	public void updateBoard(Map<String, Object> map) throws Exception {
		boardDAO.updateBoard(map);
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

	private void printQueryId(String queryId) {
		// TODO Auto-generated method stub
		
	}
}
