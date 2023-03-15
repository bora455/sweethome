package com.sweethome.sweet.memberB.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sweethome.sweet.memberB.vo.MemberVOB;


@Repository("memberDAOB")
public class MemberDAOBImpl implements MemberDAOB {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberListB() throws DataAccessException {
		List<MemberVOB> membersListB = null;
		membersListB = sqlSession.selectList("mapper.memberB.selectAllMemberListB");
		return membersListB;
	}

	@Override
	public int insertMemberB(MemberVOB memberVOB) throws DataAccessException {
		int resultB = sqlSession.insert("mapper.memberB.insertMemberB", memberVOB);
		return resultB;
	}

	@Override
	public int deleteMemberB(String bp_id) throws DataAccessException {
		int resultB = sqlSession.delete("mapper.memberB.deleteMemberB", bp_id);
		return resultB;
	}
	
	
	@Override
	public MemberVOB selectMemberByIdB(String bp_id) throws DataAccessException {
		MemberVOB memberVOB = (MemberVOB)sqlSession.selectOne("mapper.memberB.selectMemberByIdB", bp_id);
		return memberVOB;
	}

	@Override
	public MemberVOB loginByIdB(MemberVOB memberVOB) throws DataAccessException{
		  MemberVOB voB = sqlSession.selectOne("mapper.memberB.loginByIdB",memberVOB);
		return voB;
	}

	@Override
	public int updateMemberB(MemberVOB memberVOB) throws DataAccessException {
		int resultB = sqlSession.update("mapper.memberB.updateMemberB", memberVOB);
		return resultB;
	}
	

}
