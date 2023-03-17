package com.sweethome.sweet.memberB.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.member.vo.MemberVO;
import com.sweethome.sweet.memberB.vo.MemberVOB;

public interface MemberServiceB {
	 public MemberVOB loginB(MemberVOB memberVOB) throws Exception;
	 
	 public List listMembersB() throws DataAccessException;
	 public MemberVOB modMemberB(String bp_id) throws DataAccessException;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
	 
	// 로그인한 회원 정보 가져오기
	 public MemberVOB LogInMemberB(String bp_id) throws DataAccessException;

	 
	/* public MemberVOB modMemberB(String bp_id) throws DataAccessException;
	 public int getMemberB(String bp_id) throws DataAccessException;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
	 
	 MemberVOB getMemberB(String bp_id) throws Exception;
	 void updateMemberB(MemberVOB memberVOB) throws Exception;
	 MemberVOB modMemberB(String bp_id) throws Exception;*/
}
