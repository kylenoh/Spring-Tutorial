package tutorial.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import tutorial.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject BoardDAO boardDAO;
	
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
}
