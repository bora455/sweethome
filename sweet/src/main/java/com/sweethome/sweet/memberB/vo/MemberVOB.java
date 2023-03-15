package com.sweethome.sweet.memberB.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberVOB")
public class MemberVOB {
	private int bp_join;
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
	private String bin;
	private String photo;
	private String type;
	private String car;
	private int wallet;
	private Double charge;
	private Date join_date;
	private Date last_date;
	private Date stop_date;
	private String status;
	private Double location_x;
	private Double location_y;
	
	public MemberVOB() {
	      
	   }

	public int getBp_join() {
		return bp_join;
	}

	public void setBp_join(int bp_join) {
		this.bp_join = bp_join;
	}

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

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public Date getStop_date() {
		return stop_date;
	}

	public void setStop_date(Date stop_date) {
		this.stop_date = stop_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getLocation_x() {
		return location_x;
	}

	public void setLocation_x(Double location_x) {
		this.location_x = location_x;
	}

	public Double getLocation_y() {
		return location_y;
	}

	public void setLocation_y(Double location_y) {
		this.location_y = location_y;
	}
	
}