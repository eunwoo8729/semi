package fboard;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class fboardDetailAction extends ActionSupport implements SessionAware {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper
											// ��ü.

	private fboardVO paramClass = new fboardVO(); // �Ķ���͸� ������ ��ü
	private fboardVO resultClass = new fboardVO(); // ���� ��� ���� ������ ��ü

	private int currentPage; // ���� ������

	private int fb_no; // �۹�ȣ

	private Map session;
	private boolean isTrue;
	private boolean boo = false;

	public fboardDetailAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String execute() throws Exception {

		paramClass = new fboardVO();
		resultClass = new fboardVO();

		paramClass.setFb_no(getFb_no());
		sqlMapper.update("fboard.updateRedhit", paramClass);

		resultClass = (fboardVO) sqlMapper.queryForObject("fboard.selectOne", getFb_no());
		
		if(session.get("session_id") == null)
			boo = false;
		else if(session.get("session_id").equals(resultClass.getFb_id())) {
			boo = true;
		}
	
	System.out.println("boo = " + boo);
		return SUCCESS;
	}

	public fboardVO getParamClass() {
		return paramClass;
	}

	public fboardVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getFb_no() {
		return fb_no;
	}

	public void setParamClass(fboardVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(fboardVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	public boolean isBoo() {
		return boo;
	}

	public void setBoo(boolean boo) {
		this.boo = boo;
	}

	
}
