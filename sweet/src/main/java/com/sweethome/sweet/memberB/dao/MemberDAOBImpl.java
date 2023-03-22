package com.sweethome.sweet.memberB.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sweethome.sweet.memberB.vo.MemberVOB;
import com.sweethome.sweet.memberB.vo.ContractVO;


@Repository("memberDAOB")
public class MemberDAOBImpl implements MemberDAOB {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVOB loginByIdB(MemberVOB memberVOB) throws DataAccessException{
		  MemberVOB voB = sqlSession.selectOne("mapper.memberB.loginByIdB",memberVOB);
		return voB;
	}
	
	@Override
	public MemberVOB selectMemberByIdB(String bp_id) throws DataAccessException {
		MemberVOB memberVOB = (MemberVOB)sqlSession.selectOne("mapper.memberB.selectMemberByIdB", bp_id);
		return memberVOB;
	}
	
	@Override
	public int updateMemberB(MemberVOB memberVOB) throws DataAccessException {
		int resultB = sqlSession.update("mapper.memberB.updateMemberB", memberVOB);
		return resultB;
	}
	
	@Override
	public ContractVO selectContractByIdB(String bp_id) throws DataAccessException {
		ContractVO contractVO = (ContractVO)sqlSession.selectList("mapper.memberB.selectContractByIdB", bp_id);
		return contractVO;
	}

	@Override
    public MemberVOB selectMemberB(String email) throws IOException {
        return sqlSession.selectOne("mapper.memberB.selectMemberB", email);
    }
	
	@Override
    public int pwUpdate(MemberVOB vo) throws IOException {
        return sqlSession.update("mapper.memberB.pwUpdate", vo);
    }
}
