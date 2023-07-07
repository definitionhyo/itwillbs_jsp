package vo;

import java.sql.Date;

/*
 member 테이블 정의
 ----------------------------------
 번호(idx) - 정수, PK, AUTO_INCREMENT
 이름(name) - 문자(10자), NN
 아이디(id) - 문자(16자), UN, NN
 비밀번호(passwd) - 문자(16자), NN
 주민번호(jumin) - 문자(14자), UN, NN
 이메일(email) - 문자(50자), UN, NN
 직업(job) - 문자(10자), NN
 성별(gender) - 문자(1자), NN
 취미(hobby) - 문자(50자), NN
 가입동기(motivation) - 문자(500자), NN
 ---------------------------------------
 CREATE TABLE member (
 	idx INT PRIMARY KEY AUTO_INCREMENT,
 	name VARCHAR(10) NOT NULL,
 	id VARCHAR(16) NOT NULL UNIQUE,
 	passwd VARCHAR(16) NOT NULL,
 	jumin VARCHAR(14) NOT NULL UNIQUE,
 	email VARCHAR(50) NOT NULL UNIQUE,
 	job VARCHAR(10) NOT NULL,
 	gender VARCHAR(1) NOT NULL,
 	hobby VARCHAR(50) NOT NULL,
 	motivation VARCHAR(500) NOT NULL
 );
 */

// member 테이블에 대응하는 MemberVO 클래스 정의(= DTO 클래스 역할)
public class MemberBean {
	private int idx;
	private String name;
	private String id;
	private String passwd;
	private String jumin;
	private String email;
	private String job;
	private String gender;
	private String hobby;
	private String motivation;
	private Date hire_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getMotivation() {
		return motivation;
	}
	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
	@Override
	public String toString() {
		return "MemberBean [idx=" + idx + ", name=" + name + ", id=" + id + ", passwd=" + passwd + ", jumin=" + jumin
				+ ", email=" + email + ", job=" + job + ", gender=" + gender + ", hobby=" + hobby + ", motivation="
				+ motivation + ", hire_date=" + hire_date + "]";
	}
	
}









