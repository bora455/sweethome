package com.sweethome.sweet.memberB.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sweethome.sweet.memberB.vo.MemberVOB;
import com.sweethome.sweet.memberB.vo.ContractVO;


public interface MemberControllerB {
	public ModelAndView loginB(@ModelAttribute("memberB") MemberVOB memberB,RedirectAttributes rAttr,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logoutB(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView modMemberB(@RequestParam("bp_id") String bp_id, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView updateMemberB(@ModelAttribute("memberB") MemberVOB memberVOB, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView sendMail(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public String pwFind() throws Exception;
	public String pwNew(MemberVOB vo, HttpSession session) throws IOException;
}