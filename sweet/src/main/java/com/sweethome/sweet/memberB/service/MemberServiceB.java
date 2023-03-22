package com.sweethome.sweet.memberB.service;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.memberB.vo.MemberVOB;
import com.sweethome.sweet.memberB.vo.ContractVO;

public interface MemberServiceB {
	 public MemberVOB loginB(MemberVOB memberVOB) throws Exception;
	 
	 public MemberVOB modMemberB(String bp_id) throws DataAccessException;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
	 
	 public ContractVO listContractB(String bp_id) throws DataAccessException;
	 
	 public MemberVOB selectMemberB(String email) throws IOException;
	 public int pwUpdate(MemberVOB vo) throws IOException;
}
