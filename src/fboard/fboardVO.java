package fboard;

import java.util.Date;

public class fboardVO {
   private int fb_no; // 글번호
   private String fb_subject; // 글제목
   private String fb_content; // 글내용
   private int fb_like; //추천수
   private Date fb_regdate; // 작성일
   private int fb_readhit; // 조회수
   private String fb_id;// 작성자
   private int listNo;
   
public int getFb_no() {
	return fb_no;
}
public void setFb_no(int fb_no) {
	this.fb_no = fb_no;
}
public String getFb_subject() {
	return fb_subject;
}
public void setFb_subject(String fb_subject) {
	this.fb_subject = fb_subject;
}
public String getFb_content() {
	return fb_content;
}
public void setFb_content(String fb_content) {
	this.fb_content = fb_content;
}
public int getFb_like() {
	return fb_like;
}
public void setFb_like(int fb_like) {
	this.fb_like = fb_like;
}
public Date getFb_regdate() {
	return fb_regdate;
}
public void setFb_regdate(Date fb_regdate) {
	this.fb_regdate = fb_regdate;
}
public int getFb_readhit() {
	return fb_readhit;
}
public void setFb_readhit(int fb_readhit) {
	this.fb_readhit = fb_readhit;
}
public String getFb_id() {
	return fb_id;
}
public void setFb_id(String fb_id) {
	this.fb_id = fb_id;
}
public int getListNo() {
	return listNo;
}
public void setListNo(int listNo) {
	this.listNo = listNo;
}
   
   
   
}



  