package main;

/*import java.io.IOException;   
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;*/
import com.opensymphony.xwork2.ActionSupport;

/*import board.BoardVO;
import board.PagingAction;
import book.BookVO;*/

public class MainAction extends ActionSupport {

	/*public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private List<BoardVO> list = new ArrayList<BoardVO>();
	private List<BookVO> list2 = new ArrayList<BookVO>();
	
	//����¡ �׼�	
	private int currentPage = 1;	//���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 5;	// �� ��������  �Խù��� ��
	private int blockCount2 = 3;
	private int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 	//����¡�� ������ HTML
	private PagingAction page; 	// ����¡ Ŭ����
	private int searchNum;	
	private String searchKeyword;
	private int num = 0; //???
	
	
	private Map session;
	public MainAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	*/
	//���հԽ���
	public String execute() throws Exception {

		/*list = sqlMapper.queryForList("board.selectboardTypeNotice"); //��� ���� ������ ����Ʈ�� �ִ´�.
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num); 
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
		//lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);
		
		list2 = sqlMapper.queryForList("book.bookRank"); //��� ���� ������ ����Ʈ�� �ִ´�.
		totalCount = list2.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new PagingAction(currentPage, totalCount, blockCount2, blockPage, searchNum, searchKeyword, num); 
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount2 = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
		//lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount2 = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list2 = list2.subList(page.getStartCount(), lastCount2);*/
		return SUCCESS;
	}

	/*public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
		this.list = list;
	}

	public List<BookVO> getList2() {
		return list2;
	}

	public void setList2(List<BookVO> list2) {
		this.list2 = list2;
	}*/
	
}
