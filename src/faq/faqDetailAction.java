package faq;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class faqDetailAction extends ActionSupport implements SessionAware {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper
											// ��ü.

	private faqVO paramClass = new faqVO(); // �Ķ���͸� ������ ��ü
	private faqVO resultClass = new faqVO(); // ���� ��� ���� ������ ��ü

	private int currentPage; // ���� ������

	private int f_no; // �۹�ȣ

	private Map session;
	private boolean isTrue;
	private boolean boo = false;

	public faqDetailAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String execute() throws Exception {

		paramClass = new faqVO();
		resultClass = new faqVO();

		paramClass.setF_no(getF_no());
		sqlMapper.update("faq.updateRedhit", paramClass);

		resultClass = (faqVO) sqlMapper.queryForObject("faq.selectOne", getF_no());
		
/*		if(session.get("session_id") == null)
			boo = false;
		else if(session.get("session_id").equals(resultClass.getF_id())) {
			boo = true;
		}*/
	
	System.out.println("boo = " + boo);
		return SUCCESS;
	}

	public faqVO getParamClass() {
		return paramClass;
	}

	public faqVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getF_no() {
		return f_no;
	}

	public void setParamClass(faqVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(faqVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
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
