package fboard;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class fboardWriteAction extends ActionSupport implements SessionAware {

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private fboardVO paramClass = new fboardVO(); //파라미터를 저장할 객체
	private fboardVO resultClass = new fboardVO(); 
	
	private int fb_no;			//글번호
	private String fb_id;		//작성자
	private String fb_subject;			//글제목
	private int fb_readhit;			//조회수
	private String fb_content;			//글내용
	private Date fb_regdate;			//작성일
	
	private Map session;
	
	//페이징 액션	
	private int currentPage;	//현재 페이지
	
	public fboardWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		paramClass = new fboardVO();
		resultClass = new fboardVO();
		
		paramClass.setFb_subject(getFb_subject());
		paramClass.setFb_id(getFb_id());
		paramClass.setFb_content(getFb_content());
		
		sqlMapper.insert("fboard.insertBoard", paramClass);
		
		return SUCCESS;
	}

	public fboardVO getParamClass() {
		return paramClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getFb_no() {
		return fb_no;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}

	public String getFb_id() {
		return fb_id;
	}

	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}

	public String getFb_subject() {
		return fb_subject;
	}

	public void setFb_subject(String fb_subject) {
		this.fb_subject = fb_subject;
	}

	public int getFb_readhit() {
		return fb_readhit;
	}

	public void setFb_readhit(int fb_readhit) {
		this.fb_readhit = fb_readhit;
	}

	public String getFb_content() {
		return fb_content;
	}

	public void setFb_content(String fb_content) {
		this.fb_content = fb_content;
	}

	public Date getFb_regdate() {
		return fb_regdate;
	}

	public void setFb_regdate(Date fb_regdate) {
		this.fb_regdate = fb_regdate;
	}


	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
