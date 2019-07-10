package tutorial.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

}
