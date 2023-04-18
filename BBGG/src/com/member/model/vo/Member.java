package com.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int memNo; //MEM_NO	NUMBER	NOT NULL PRIMARY KEY,
	private String id; //ID	VARCHAR2(20)	NOT NULL,
    private String pwd; //PWD	VARCHAR2(20)	NOT NULL,
    private String nickname; //NICKNAME	VARCHAR2(20)	NOT NULL,
    private String name; //NAME	VARCHAR2(20)	NOT NULL,
    private String email; //EMAIL	VARCHAR2(20)	NOT NULL,
    private String phone; //PHONE	VARCHAR2(13)	NOT NULL,
    private String location; //LOCATION	VARCHAR2(30)	NULL,
    private Date birth; //BIRTH	DATE	NULL,
    private Date enrollDate; //ENROLL_DATE	DATE	DEFAULT SYSDATE NOT NULL,
    private char statusYn; //STATUS_YN	CHAR(1)	DEFAULT 'N'	NOT NULL,
    private char grade; //GRADE	CHAR(1)	DEFAULT 'V' NOT NULL,
    private String bBti; //B_BTI	VARCHAR2(15) DEFAULT 0 NULL,
    private char bMateYn; //B_MATE_YN	CHAR(1)	DEFAULT 'N'	NULL
	
    public Member() {
		super();
	}

	public Member(int memNo, String id, String pwd, String nickname, String name, String email, String phone,
			String location, Date birth, Date enrollDate, char statusYn, char grade, String bBti, char bMateYn) {
		super();
		this.memNo = memNo;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.birth = birth;
		this.enrollDate = enrollDate;
		this.statusYn = statusYn;
		this.grade = grade;
		this.bBti = bBti;
		this.bMateYn = bMateYn;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getStatusYn() {
		return statusYn;
	}

	public void setStatusYn(char statusYn) {
		this.statusYn = statusYn;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getbBti() {
		return bBti;
	}

	public void setbBti(String bBti) {
		this.bBti = bBti;
	}

	public char getbMateYn() {
		return bMateYn;
	}

	public void setbMateYn(char bMateYn) {
		this.bMateYn = bMateYn;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", location=" + location + ", birth=" + birth
				+ ", enrollDate=" + enrollDate + ", statusYn=" + statusYn + ", grade=" + grade + ", bBti=" + bBti
				+ ", bMateYn=" + bMateYn + "]";
	}
    
}
