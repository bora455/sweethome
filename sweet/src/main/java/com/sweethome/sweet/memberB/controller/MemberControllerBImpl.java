package com.sweethome.sweet.memberB.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sweethome.sweet.member.vo.MemberVO;
import com.sweethome.sweet.memberB.service.MemberServiceB;
import com.sweethome.sweet.memberB.vo.MemberVOB;




@Controller("memberControllerB")
//@EnableAspectJAutoProxy
public class MemberControllerBImpl implements MemberControllerB {
	@Autowired
	private MemberServiceB memberServiceB;
	@Autowired
	private MemberVOB memberVOB ;
	
	//로그인 후 메인페이지
	@RequestMapping(value = { "/memberB/mainB.do"}, method = RequestMethod.GET)
	private ModelAndView mainB(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	//로그인
	@Override
	@RequestMapping(value = "/memberB/loginB.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView loginB(@ModelAttribute("memberB") MemberVOB memberB,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	memberVOB = memberServiceB.loginB(memberB);
	if(memberVOB != null) {
	    HttpSession session = request.getSession();
	    session.setAttribute("memberB", memberVOB);
	    session.setAttribute("isLogOn", true);
	    //mav.setViewName("redirect:/memberB/listMembersB.do");
	    String action = (String)session.getAttribute("action");
	    session.removeAttribute("action");
	    if(action!= null) {
	       mav.setViewName("redirect:"+action);
	    }else {
	       mav.setViewName("redirect:/memberB/mainB.do");	
	    }

	}else {
	   rAttr.addAttribute("result","loginFailedB");
	   mav.setViewName("redirect:/memberB/loginFormB.do");
	}
	return mav;
	}
	
	//로그아웃
	@Override
	@RequestMapping(value = "/memberB/logoutB.do", method =  RequestMethod.GET)
	public ModelAndView logoutB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("memberB");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mainB.do");
		return mav;
	}	

	//로그인폼
	@RequestMapping(value = "/memberB/*FormB.do", method =  RequestMethod.GET)
	private ModelAndView formB(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		String viewNameB = (String)request.getAttribute("viewNameB");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewNameB);
		return mav;
	}
	
	@RequestMapping(value="/memberB/logInMemberB", method=RequestMethod.GET)
	public ModelAndView LogInMemberB(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    System.out.println("Call LogInMemberB-method of control");
	    request.setCharacterEncoding("utf-8");
	    String viewName = "/memberB/logInMemberB";
	    System.out.println("viewName : "+viewName);
	    HttpSession session = request.getSession();
	    MemberVOB memberVOB = (MemberVOB) session.getAttribute("memberB");
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("logInMemberB", memberVOB);
	    mav.setViewName(viewName);
	    return mav;
	}

	
	@Override
	@RequestMapping(value="/memberB/modMemberB", method=RequestMethod.GET)
	public ModelAndView modMemberB(@RequestParam("bp_id") String bp_id, HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
	    System.out.println("Call modMember-method of control");
	    request.setCharacterEncoding("utf-8");
	    String viewName = "/memberB/modMemberB";
	    System.out.println("viewName : "+viewName);

	    // 1. 세션에서 로그인한 회원 정보를 불러옵니다.
	    HttpSession session = request.getSession();
	    MemberVOB memberB = (MemberVOB) session.getAttribute("memberB");
	    if (memberB == null) { // 로그인한 회원 정보가 없는 경우
	        return new ModelAndView("redirect:/memberB/logInMemberB"); // 로그인 페이지로 이동합니다.
	    }

	    // 2. 로그인한 회원 정보를 사용해 회원 정보 수정을 진행합니다.
	    MemberVOB memberVOB = memberServiceB.modMemberB(memberB.getBp_id());
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("memberB",memberVOB);
	    mav.setViewName(viewName);
	    return mav;    
	}

	
	@Override
	@RequestMapping(value="/memberB/updateMemberB", method = RequestMethod.POST)
	public ModelAndView updateMemberB(@ModelAttribute("memberB") MemberVOB memberB, HttpServletRequest request, HttpServletResponse response)throws Exception{
	    System.out.println("Call updateMemberB-method of control");
	    request.setCharacterEncoding("utf-8");
	    int resultB = 0;
	    resultB = memberServiceB.updateMemberB(memberB);
	    ModelAndView mav = new ModelAndView("redirect:/memberB/modMemberB");
	    mav.addObject("bp_id", memberB.getBp_id()); // 수정된 회원의 ID를 전달
	    return mav;
	}
	
	@Override
	@RequestMapping(value="/memberB/listMembersB", method=RequestMethod.GET)
	public ModelAndView listMembersB(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("html/text;charset=utf-8");
	    String viewName = "/memberB/listMembersB"; // 수정된 부분
	    List<MemberVOB> businessList = memberServiceB.listMembersB();
	    ModelAndView mav = new ModelAndView(viewName);
	    mav.addObject("businessList", businessList);
	    return mav;
	}
	
	/*
	@Override
	@RequestMapping(value="/memberB/memModB", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memModB(HttpServletRequest request, HttpServletResponse response, MemberVOB memberVOB) throws Exception {
	    // 로그
	    System.out.println("Call memModB-method of control");
	    request.setCharacterEncoding("utf-8");
	    String viewName = "/memberB/memModB";
	    System.out.println("viewName : "+viewName);
	    HttpSession session = request.getSession();
	    // 세션에서 현재 로그인한 사용자의 아이디를 가져옴
	    String bp_id = (String) session.getAttribute("isLogOn");
	    // ModelAndView 객체 생성
	    ModelAndView mav = new ModelAndView();
	    if(request.getMethod().equals("GET")) {
	        // GET 요청인 경우, 회원 정보 수정을 위한 폼을 보여줌
	        MemberVOB memberB = memberServiceB.modMemberB(bp_id);
	        mav.addObject("memberB", memberB);
	    } else if(request.getMethod().equals("POST")) {
	        // POST 요청인 경우, 회원 정보를 수정하고 수정된 정보를 보여줌
	        // 입력받은 사용자 정보에 현재 로그인한 사용자의 아이디를 추가하여 업데이트
	        memberVOB.setBp_id(bp_id);
	        // 회원 정보 업데이트
	        memberServiceB.updateMemberB(memberVOB);
	        // 업데이트된 회원 정보 가져오기
	        MemberVOB memberB = memberServiceB.getMemberB(bp_id);
	        // 업데이트된 회원 정보와 메시지를 ModelAndView에 추가
	        mav.addObject("memberB", memberB);
	        mav.addObject("message", "회원정보가 수정되었습니다.");
	    }
	    // 뷰 이름 설정
	    mav.setViewName(viewName);
	    return mav;
	}*/


	private String getViewNameB(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		
		String viewNameB = uri.substring(begin, end);
		if (viewNameB.indexOf(".") != -1) {
			viewNameB = viewNameB.substring(0, viewNameB.lastIndexOf("."));
		}
		if (viewNameB.lastIndexOf("/") != -1) {
			viewNameB = viewNameB.substring(viewName.lastIndexOf("/", 1), viewNameB.length());
		}
		
		return viewName;
	}

	
	

}
