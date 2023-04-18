package com.board.model.vo;

public class Photo {

	private int photoNo;
	private int boardNo;
	private String originName;
	private String reName;
	
	
	public Photo() {
		super();

	}
	public Photo(int photoNo, int boardNo, String originName, String reName) {
		super();
		this.photoNo = photoNo;
		this.boardNo = boardNo;
		this.originName = originName;
		this.reName = reName;
	}
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getReName() {
		return reName;
	}
	public void setReName(String reName) {
		this.reName = reName;
	}
	@Override
	public String toString() {
		return "Photo [photoNo=" + photoNo + ", boardNo=" + boardNo + ", originName=" + originName + ", reName="
				+ reName + "]";
	}
	
	
	
}
