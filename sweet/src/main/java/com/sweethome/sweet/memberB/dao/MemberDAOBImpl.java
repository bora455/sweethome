package com.sweethome.sweet.memberB.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sweethome.sweet.member.vo.MemberVO;
import com.sweethome.sweet.memberB.vo.MemberVOB;


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
	public List selectAllMemberListB() throws DataAccessException {
		List<MemberVOB> businessList = null;
		businessList = sqlSession.selectList("mapper.memberB.selectAllMemberListB");
		return businessList;
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
	public MemberVOB getMemberB(String bp_id) throws DataAccessException {
	    return sqlSession.selectOne("mapper.memberB.getMemberB", bp_id);
	}

	
/*	@Override
	public MemberVOB loginMemB(String bp_id) throws DataAccessException {
		MemberVOB memberVOB = (MemberVOB)sqlSession.selectOne("mapper.memberB.loginMemB", bp_id);
		return memberVOB;
	}
	
	@Override
	public MemberVOB getMemB(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.getMemB", id);
		return result;
	}
	
	@Override
	public int updateMemB(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.updateMemB", memberVO);
		return result;
	}
	
	@Override
    public MemberVOB getMemberB(String bp_id) throws Exception {
        return sqlSession.selectOne("mapper.member.getMemberB", bp_id);
    }
    
    @Override
    public void updateMemberB(MemberVOB memberVOB) throws Exception {
        sqlSession.update("mapper.member.updateMemberB", memberVOB);
    }*/
	
}
