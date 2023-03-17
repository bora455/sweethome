package com.sweethome.sweet.memberB.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sweethome.sweet.member.vo.MemberVO;
import com.sweethome.sweet.memberB.dao.MemberDAOB;
import com.sweethome.sweet.memberB.vo.MemberVOB;



@Service("memberServiceB")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceBImpl implements MemberServiceB {
	@Autowired
	private MemberDAOB memberDAOB;

	@Override
	public MemberVOB loginB(MemberVOB memberVOB) throws Exception{
		return memberDAOB.loginByIdB(memberVOB);
	}
	
	@Override
	public List listMembersB() throws DataAccessException {
		List businessList = null;
		businessList = memberDAOB.selectAllMemberListB();
		return businessList;
	}

	public MemberVOB modMemberB(String bp_id) throws DataAccessException {
		MemberVOB memberVOB = new MemberVOB();
		memberVOB = memberDAOB.selectMemberByIdB(bp_id);
		return memberVOB;
	}
	
	@Override
	public int updateMemberB(MemberVOB memberB)throws DataAccessException{
		return memberDAOB.updateMemberB(memberB);
	}
	
	/*
	@Override //수정한 회원 정보 가져옴
    public int getMemberB(String bp_id) throws Exception {
		return memberDAOB.getMemB(memberVOB);
    }

    @Override //수정한 회원 정보 db에 업데이트
    public int updateMemberB(MemberVOB memberVOB) throws Exception {
    	return memberDAOB.updateMemB(memberVOB);
    }

    @Override
    public MemberVOB getMemberB(String bp_id) throws Exception {
        return memberDAOB.getMemberB(bp_id);
    }

    @Override
    public void updateMemberB(MemberVOB memberVOB) throws Exception {
        memberDAOB.updateMemberB(memberVOB);
    }

    @Override
    public MemberVOB modMemberB(String bp_id) throws Exception {
        return memberDAOB.getMemberB(bp_id);
    }
    */
}
