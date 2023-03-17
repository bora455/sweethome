package com.sweethome.sweet.memberB.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.member.vo.MemberVO;
import com.sweethome.sweet.memberB.vo.MemberVOB;


public interface MemberDAOB {
	 public MemberVOB loginByIdB(MemberVOB memberVOB) throws DataAccessException;
	 
	 public List selectAllMemberListB() throws DataAccessException;
	 public MemberVOB selectMemberByIdB(String bp_id) throws DataAccessException;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
	 
/*	 public MemberVO loginMemB(String id) throws DataAccessException;
	 public int getMemberB(String id) throws DataAccessException;
	 public int updateMemB(MemberVO memberVO) throws DataAccessException ;
	 
	 public MemberVOB getMemberB(String bp_id) throws Exception;
	 public void updateMemberB(MemberVOB memberVOB) throws Exception; */
}
