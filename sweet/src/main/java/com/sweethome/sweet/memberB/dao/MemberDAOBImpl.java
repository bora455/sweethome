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
	public MemberVOB memView(String bp_id) throws DataAccessException {
		MemberVOB memberVOB = (MemberVOB)sqlSession.selectOne("mapper.memberB.memView", bp_id);
		return memberVOB;
	}

	@Override
	public int memMod(MemberVOB memberVOB) throws DataAccessException {
		int result = sqlSession.update("mapper.memberB.memMod", memberVOB);
		return result;
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
}