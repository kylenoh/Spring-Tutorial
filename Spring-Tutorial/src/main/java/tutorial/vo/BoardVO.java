package tutorial.vo;

public class BoardVO {
	private String TITLE;
	private String CONTENTS;
	private String FILE;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(String tITLE, String cONTENTS, String fILE) {
		super();
		TITLE = tITLE;
		CONTENTS = cONTENTS;
		FILE = fILE;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCONTENTS() {
		return CONTENTS;
	}

	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}

	public String getFILE() {
		return FILE;
	}

	public void setFILE(String fILE) {
		FILE = fILE;
	}

}
