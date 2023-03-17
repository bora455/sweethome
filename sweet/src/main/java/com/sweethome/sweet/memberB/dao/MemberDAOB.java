package com.sweethome.sweet.memberB.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.member.vo.MemberVO;
import com.sweethome.sweet.memberB.vo.MemberVOB;


public interface MemberDAOB {
	 public MemberVOB loginByIdB(MemberVOB memberVOB) throws DataAccessException;
	 
	 public MemberVOB selectMemberByIdB(String bp_id) throws DataAccessException;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
	 
}
