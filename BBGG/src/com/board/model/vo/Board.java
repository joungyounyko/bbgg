package com.board.model.vo;

import java.sql.Date;

public class Board {
   private int boardNo;
   private int memberNo;
   private String title;
   private String content;
   private Date writeDate;
   private int hits;
   private String category;
   private String head;
   private String noticeYN;
   private String statusYN;
   private String nickName;
   
   public String getNickName() {
	return nickName;
}

public void setNickName(String nickName) {
	this.nickName = nickName;
}

public Board() {
      super();
   }

   public Board(int boardNo, int memberNo, String title, String content, Date writeDate, int hits, String category,
         String head, String noticeYN, String statusYN) {
      super();
      this.boardNo = boardNo;
      this.memberNo = memberNo;
      this.title = title;
      this.content = content;
      this.writeDate = writeDate;
      this.hits = hits;
      this.category = category;
      this.head = head;
      this.noticeYN = noticeYN;
      this.statusYN = statusYN;
   }

   public int getBoardNo() {
      return boardNo;
   }

   public void setBoardNo(int boardNo) {
      this.boardNo = boardNo;
   }

   public int getMemberNo() {
      return memberNo;
   }

   public void setMemberNo(int memberNo) {
      this.memberNo = memberNo;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Date getWriteDate() {
      return writeDate;
   }

   public void setWriteDate(Date writeDate) {
      this.writeDate = writeDate;
   }

   public int getHits() {
      return hits;
   }

   public void setHits(int hits) {
      this.hits = hits;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public String getHead() {
      return head;
   }

   public void setHead(String head) {
      this.head = head;
   }

   public String getNoticeYN() {
      return noticeYN;
   }

   public void setNoticeYN(String noticeYN) {
      this.noticeYN = noticeYN;
   }

   public String getStatusYN() {
      return statusYN;
   }

   public void setStatusYN(String statusYN) {
      this.statusYN = statusYN;
   }

   @Override
public String toString() {
	return "Board [boardNo=" + boardNo + ", memberNo=" + memberNo + ", title=" + title + ", content=" + content
			+ ", writeDate=" + writeDate + ", hits=" + hits + ", category=" + category + ", head=" + head
			+ ", noticeYN=" + noticeYN + ", statusYN=" + statusYN + ", nickName=" + nickName + "]";
}

}