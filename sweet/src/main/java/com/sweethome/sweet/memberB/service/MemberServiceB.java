package com.sweethome.sweet.memberB.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.memberB.vo.MemberVOB;

public interface MemberServiceB {
	 public List listMembersB() throws DataAccessException;
	 public int addMemberB(MemberVOB memberVOB) throws DataAccessException;
	 public MemberVOB modMemberB(String bp_id) throws DataAccessException;
	 public int removeMemberB(String bp_id) throws DataAccessException;
	 public MemberVOB loginB(MemberVOB memberVOB) throws Exception;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
}
