package com.sweethome.sweet.memberB.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.member.vo.MemberVO;
import com.sweethome.sweet.memberB.vo.MemberVOB;

public interface MemberServiceB {
	 public MemberVOB loginB(MemberVOB memberVOB) throws Exception;
	 
	 public MemberVOB modMemberB(String bp_id) throws DataAccessException;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
	 
}
