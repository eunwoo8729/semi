<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<SCRIPT type="text/javascript">
	function idCheck() {
		var form = document.comWrite;
		if (!form.member_id.value) {
			alert("�α��� ��.");
			return false;
		}
	}

	function reserveCheck() {
		if (document.bookReserve.reserve_id.value != "") {
			alert("����Ұ�.");
			return false;
		}
			alert("123");
			return true;
	}
	function myBookPage() {
		if (document.getElementById("ID").value == "") {
			alert("���̵� �Է��ϼ���");
			loginForm.member_id.focus();
			return true;
		}
	}
	function btnClick() {
		alert("����");
	}
</script>

<link rel="stylesheet" type="text/css" href="style.css" media="all" />

<%-- <style type="text/css">
   .list_table thead th {  text-align: center; border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; padding: 8px 0; }
   .list_table tbody td {  text-align: center; border-left: 1px solid #e5e5e5; border-right: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; padding: 5px 0; }
</style> --%>

</head>



<body>


	<table border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="left"><h2>���� �󼼺���</h2></td>
			<td align="right" />
			<td align="right"></td>
			<td align="right"><s:if test="${ session_admin_tp == 1 }">
					<input name="list" type="button" value="����" class="inputb"
						onClick="javascript:location.href='adminBookModifyForm.action?b_no='+
         '<s:property value="resultClass.b_no" />'" />

					<input name="list" type="button" value="����" class="inputb"
						onClick="javascript:location.href='adminBookDelete.action?b_no='+
         '<s:property value="resultClass.b_no" />'" />
				</s:if> 
				<input name="list" type="button" value="�������" class="inputb"
				onClick="javascript:location.href='bookSearch.action?currentPage='+
         '<s:property value="currentPage" />'" />
			</td>
		</tr>
	</table>

	<table border="0" cellspacing="1">
		<tr>
			<td rowspan="5" align="center"><img
				src="./style/image/book/${ resultClass.file_savname }" width="297"
				height="420" alt="�̹����� �����ϴ�" /></td>
		</tr>
		<tr>
			<td>�� �������� : <s:property value="resultClass.b_name" /></td>
		</tr>
		<tr>
			<td>�� ���� : <s:property value="resultClass.b_writer" /></td>
		</tr>
		<tr>
			<td>�� ���ǻ� : <s:property value="resultClass.b_pub" /></td>
		</tr>
		<tr>
			<td>�� ����� : <s:property value="resultClass.b_pubdate" /></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="left"><h3>����/��������</h3></td>
		</tr>
	</table>



	<table border="0" cellspacing="1">
		<tr>
			<td align="center">�ڷ����</td>
			<td align="center">�ݳ�������</td>
			<td align="center">����</td>
			<tr>
				<form action="bookRentAction.action">
					<s:hidden name="b_no" value="${b_no}" />
					<s:if test="${resultClass.rent_id == null}">
						<td align="center"><input type="submit" value="���� ����"></input></td>
					</s:if>
					<s:else>
						<td align="center"><input type="submit" value="���� �Ұ�"
							disabled></input></td>
					</s:else>
				</form>
				<td align="center"><s:date name="resultClass.enddate"
						format="yyyy-MM-dd" /></td>

				<form id="bookReserve" name="bookReserve"
					action="bookReserveAction.action" onsubmit="return reserveCheck();">
					<s:hidden name="b_no" value="${b_no}" />
					<s:if
						test="${ resultClass.rent_id == null || resultClass.reserve_id != null}">

						<td align="center"><input type="submit" value="���� �Ұ�"
							disabled></input></td>
					</s:if>

					<s:else>
						<td align="center"><input type="submit" value="���� ����"></input></td>
					</s:else>
				</form>
			</tr>
	</table>

	<div class="content">
		<pre>
���� �Ⱓ�� ��������� ���� 14�� �Դϴ�. ���� ��û�� �����ڰ� ���� �ÿ��� �����ϸ� 
�����ڰ� ������ 1�� ������ ����Ⱓ ���� �����մϴ�.
</pre>
	</div>

	<table border="0" cellspacing="0">
		<tr>
			<td align="center">
				<form action="myPageBookInclude.action" onsubmit="javascript:alert('Ȯ��');">
					<s:hidden name="b_no" value="${b_no}" />
					<s:hidden name="b_name" value="${resultClass.b_name}" />
					<input type="submit" value="������ ���"></input>
				</form>
			</td>
			<td align="center"><form action="myPageBookList.action"><input type="submit" value="������ ���"></input></form></td>
		</tr>
	</table>

	<div class="content">
		<table border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td align="left"><h3>��������</h3></td>
			</tr>
		</table>

		<table border="0" cellspacing="1">
			<tr>
				<td width="100" height="50">�� ���� �Ұ� :</td>
				<td><s:property value="resultClass.b_intro" /></td>
			</tr>
			<tr>
				<td width="100" height="50">�� ���� ���� :</td>
				<td><s:property value="resultClass.b_list" /></td>
			</tr>
		</table>
	</div>

	<table border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="left"><h3>�ı�</h3></td>
		</tr>
	</table>
	
	
<%-- 
���
	<div class="boardcss_list_table">
		<table class="list_table" style="table-layout: fixed;">
			<thead>
				<tr>
					<th>�ۼ��� �ۼ���</th>
					<th colspan="2">����</th>
				</tr>
			</thead>
			<s:iterator value="commentlist" status="stat">
				<tbody>
					<tr>
						<td width="150" height="5" align="center"><b>${member_id}</b>&nbsp&nbsp&nbsp&nbsp
							<s:property value="regdate" /></td>
						<td width="630" rowspan="2" style="word-break: break-all;"><s:property
								value="content" /></td>
						<td width="20" rowspan="2"><input name="list" type="button"
							value="����" class="inputb"
							onClick="javascript:location.href='commentDelete.action?comment_no='+
         '<s:property value="comment_no" />&book_no=<s:property value="book_no" />'"></td>
					</tr>

					<tr>
						<td><s:if test=" ${star == '5' }">
               �ڡڡڡڡ�
            </s:if> <s:if test=" ${star == '4' }">
               �ڡڡڡڡ�
            </s:if> <s:if test=" ${star == '3' }">
               �ڡڡڡ١�
            </s:if> <s:if test=" ${star == '2' }">
               �ڡڡ١١�
            </s:if> <s:if test=" ${star == '1' }">
               �ڡ١١١�
            </s:if></td>
					</tr>


				</tbody>
			</s:iterator>
		</table>

		<form name="comWrite" action="commentWrite.action" method="post">
			<table class="list_table">
				<tr>
					<td rowspan="2"><s:hidden name="member_id"
							value="${session_id}" /> ${session_id}<br> <select
							name="star">
								<option id="star5" value="5">�ڡڡڡڡ�</option>
								<option id="star4" value="4">�ڡڡڡڡ�</option>
								<option id="star3" value="3">�ڡڡڡ١�</option>
								<option id="star2" value="2">�ڡڡ١١�</option>
								<option id="star1" value="1">�ڡ١١١�</option>
						</select></td>
					<td><s:hidden name="comment_no" value="%{resultClass.book_no}" />
						<s:hidden name="book_no" value="%{resultClass.book_no}" /> <s:textarea
							name="content" cols="80" rows="3" /></td>
				</tr>
				<tr>
					<td colspan="3" align="right"><input name="submit"
						type="submit" value="�ۼ��Ϸ�" onclick="return idCheck(); " /></td>
				</tr>
			</table>
	</div>
	</form> --%>
</body>
</html>