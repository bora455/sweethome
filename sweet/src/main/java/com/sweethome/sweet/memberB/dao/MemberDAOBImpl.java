package com.sweethome.sweet.memberB.dao;

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
	
	// 회원 정보 조회
    public MemberVOB readMember(String bp_id) throws Exception {
        return sqlSession.selectOne("mapper.memberB.readMember", bp_id);
    }

    // 비밀번호 변경
    public void updatePw(MemberVOB memberVOB) throws Exception {
        sqlSession.update("mapper.memberB.updatePw", memberVOB);
    }

    // 아이디 중복 체크
    public MemberVOB idCheck(String bp_id) throws Exception {
        return sqlSession.selectOne("mapper.memberB.idCheck", bp_id);
    }
    
	
}
