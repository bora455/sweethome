package com.sweethome.sweet.memberB.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.memberB.vo.MemberVOB;
import com.sweethome.sweet.memberB.vo.ContractVO;


public interface MemberDAOB {
	 public MemberVOB loginByIdB(MemberVOB memberVOB) throws DataAccessException;
	 
	 public MemberVOB selectMemberByIdB(String bp_id) throws DataAccessException;
	 public int updateMemberB(MemberVOB memberVOB) throws DataAccessException;
	 
	 public ContractVO selectContractByIdB(String bp_id) throws DataAccessException;
	 
	 public MemberVOB selectMemberB(String email) throws IOException;
	 public int pwUpdate(MemberVOB vo) throws IOException;
}
