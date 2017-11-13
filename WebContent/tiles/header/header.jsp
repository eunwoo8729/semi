<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>Delphic | Creative Portfolio Template</title>
<link rel="stylesheet" type="text/css" href="style.css" media="all" />
<link rel="stylesheet" media="all" href="style/type/folks.css" />
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="style/css/ie7.css" media="all" />
<![endif]-->
<script type="text/javascript" src="style/js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript" src="style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="style/js/scripts.js"></script>
<script type="text/javascript">
   $(function() {
      if ($('#sliderholder-cycle').length) {
         // timeouts per slide (in seconds) 
         var timeouts = [ 150, 390, 25 ];
         function calculateTimeout(currElement, nextElement, opts, isForward) {
            var index = opts.currSlide;
            return timeouts[index] * 1000;
         }
         jQuery('#sliderholder-cycle').cycle({
            fx : 'fade',
            pager : '.slidernav',
            prev : '.sliderprev',
            next : '.slidernext',
            speed : 1000,
            timeoutFn : calculateTimeout,
            pagerEvent : 'click',
            pauseOnPagerHover : true,
            cleartype : 1
         });
         jQuery('#sliderholder-cycle').css("display", "block");
         jQuery('.slidernav').css("display", "block");

      }
   });

   function idCheck() {
      
       var a = document.getElementsByName("memberID").value;
       
       if (a == null) {
         alert("�α����� ���ּ���.");
         return false;
      }
    }
</script>
</head>
<body>

   <div id="container">
      <!-- Begin Header Wrapper -->
      <div id="page-top">
         <div id="header-wrapper">
            <!-- Begin Header -->
            <div id="header">
               <div id="logo">
                  <a href="mainAction.action"><img src="./style/image/lgoo.jpg"
                     alt="logo img" width="100" height="100" /></a>
               </div>
               <!-- Logo -->
               <!-- Begin Menu -->
               <div id="menu-wrapper">
                  <div id="smoothmenu1" class="ddsmoothmenu">

                     <table width="100%" height="100%" cellpadding="0" cellspacing="0"
                        border="0">
                        <tr>
                           <td align="left">
                              <!--  <div id="logo"><a href="mainAction.action"><img src="./style/image/logo.jpg" alt="logo img"  /></a></div> -->
                           </td>
                           <td align="right"><a href="mainAction.action">home /</a>
                       						 <a href="siteMap.action">�Ѵ��� ���� /</a>
                       						  <s:if test="${ session_id == null }">
                                 
                                 <a href="joinAgree.action">ȸ������ /</a>
                                 <a href="loginForm.action">�α���</a>
                              </s:if> <s:else>
                                 <s:if test="${ session_admin_tp == 1 }">
                                    <a href="admin.action">������������ /</a>
                                 </s:if>
                                 <s:else>
                                  	  <a href="myPage.action">�� ȯ��! /</a>
                                 </s:else>
                                 <a href="logout.action">�α׾ƿ� (${ session_id })</a>
                              </s:else></td>
                        </tr>
                     </table>
                     <ul>
                
                        <li><a href="info.jsp">������ �ȳ�</a>
                           <ul>
                              <li><a href="notice.action">��������</a></li>
                              <li><a href="info.jsp">�̿� �ȳ�</a></li>
                              <li><a href="map.jsp">���ô� ��</a></li>
                              
                           </ul></li>
                        <li><a href="booksearch.jsp">�ڷ�˻�</a>
                           <ul>
                              <li><a href="booksearch.jsp">���հ˻�</a></li>
                              <li><a href="book">��õ ����</a></li>
                              <li><a href="book">�Ű� ����</a></li>
                           </ul></li>
                        <li><a href="introduce.action">���հԽ���</a>
                           <ul>
                              <li><a href="freeboardlist.jsp">�����Խ���</a></li>
                              <li><a href="faq.jsp">���ֹ��� ����</a></li>
                              <li><a href="needbooklist.jsp">���� ��û</a>
                           </ul></li>
                           <s:hidden name="member_id" value="${session_id}" />
                           <li><a href="mypage.action" onclick="return idCheck();">���Ǽ���</a>
                              <ul>
                                 <li><a href="mypage.myPageAction.action">������������</a></li>
                                 <li><a href="/mypage/myLoanList.jsp">���� ��Ȳ</a></li>
                              </ul></li>
                     </ul>
                  </div>
               </div>
               <!-- End Menu -->
            </div>
            <!-- End Header -->
         </div>
      </div>
   </div>
   <div class="line"></div>
</body>
</html>