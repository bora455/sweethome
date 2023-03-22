package com.sweethome.sweet.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sweethome.sweet.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws Exception;
	 
	 public MemberVO modMember(String member_id) throws DataAccessException;
	 public int updateMember(MemberVO member)throws DataAccessException;
}
