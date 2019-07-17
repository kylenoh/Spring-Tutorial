package tutorial.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
//	Board
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	Object selectPagingList(String queryId, Object params) throws Exception;
	void insertBoard(Map<String, Object> map) throws Exception;
	void insertFile(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception;

	void updateHitCnt(Map<String, Object> map) throws Exception;
	void updateBoard(Map<String, Object> map) throws Exception;
	void deleteBoard(Map<String, Object> map) throws Exception;
	
//	File
	Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	void updateFile(Map<String, Object> map) throws Exception;
	void deleteFileList(Map<String, Object> map) throws Exception;

}
