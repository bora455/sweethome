package com.sweethome.sweet.memberB.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberVOB")
public class MemberVOB {
	private String bp_id;
	private String bp_pw;
	private String name;
	private String dp_name;
	private String email;
	private String addr1;
	private String addr2;
	private String tel1;
	private String tel2;
	private String hp1;
	private String hp2;
	public String getBp_id() {
		return bp_id;
	}
	public void setBp_id(String bp_id) {
		this.bp_id = bp_id;
	}
	public String getBp_pw() {
		return bp_pw;
	}
	public void setBp_pw(String bp_pw) {
		this.bp_pw = bp_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDp_name() {
		return dp_name;
	}
	public void setDp_name(String dp_name) {
		this.dp_name = dp_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	
}