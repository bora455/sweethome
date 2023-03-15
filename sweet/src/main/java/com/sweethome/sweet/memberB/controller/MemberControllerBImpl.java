package com.sweethome.sweet.memberB.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sweethome.sweet.memberB.service.MemberServiceB;
import com.sweethome.sweet.memberB.vo.MemberVOB;




@Controller("memberControllerB")
//@EnableAspectJAutoProxy
public class MemberControllerBImpl   implements MemberControllerB {
	@Autowired
	private MemberServiceB memberServiceB;
	@Autowired
	private MemberVOB memberVOB ;
	
	@RequestMapping(value = { "/","/mainB.do"}, method = RequestMethod.GET)
	private ModelAndView mainB(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/memberB/listMembersB.do" ,method = RequestMethod.GET)
	public ModelAndView listMembersB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewNameB = (String)request.getAttribute("viewNameB");
		List membersListB = memberServiceB.listMembersB();
		ModelAndView mav = new ModelAndView(viewNameB);
		mav.addObject("membersListB", membersListB);
		return mav;
	}

	@Override
	@RequestMapping(value="/memberB/addMemberB.do" ,method = RequestMethod.POST)
	public ModelAndView addMemberB(@ModelAttribute("memberB") MemberVOB memberB,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int resultB = 0;
		resultB = memberServiceB.addMemberB(memberB);
		ModelAndView mav = new ModelAndView("redirect:/memberB/listMembersB.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/memberB/removeMemberB.do" ,method = RequestMethod.GET)
	public ModelAndView removeMemberB(@RequestParam("bp_id") String bp_id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		memberServiceB.removeMemberB(bp_id);
		ModelAndView mav = new ModelAndView("redirect:/memberB/listMembersB.do");
		return mav;
	}
	/*
	@RequestMapping(value = { "/member/loginForm.do", "/member/memberForm.do" }, method =  RequestMethod.GET)
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	*/
	
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
	    String actionB = (String)session.getAttribute("actionB");
	    session.removeAttribute("actionB");
	    if(actionB!= null) {
	       mav.setViewName("redirect:"+actionB);
	    }else {
	       mav.setViewName("redirect:/mainB.do");	
	    }

	}else {
	   rAttr.addAttribute("resultB","loginFailedB");
	   mav.setViewName("redirect:/memberB/loginFormB.do");
	}
	return mav;
	}
	
	@Override
	@RequestMapping(value="/memberB/modMemberB.do", method=RequestMethod.GET)
	public ModelAndView modMemberB(@RequestParam("bp_id") String bp_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Call modMemberB-method of control");
		request.setCharacterEncoding("utf-8");
	    String viewNameB = (String)request.getAttribute("viewNameB");
		System.out.println("viewNameB : "+viewNameB);
		MemberVOB memberVOB = memberServiceB.modMemberB(bp_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberB",memberVOB);
		mav.setViewName(viewNameB);
		return mav;	
	}

	@Override
	@RequestMapping(value = "/memberB/logoutB.do", method =  RequestMethod.GET)
	public ModelAndView logoutB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("memberB");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}	

	@RequestMapping(value = "/memberB/*FormB.do", method =  RequestMethod.GET)
	private ModelAndView formB(@RequestParam(value= "resultB", required=false) String resultB,
							  @RequestParam(value= "actionB", required=false) String actionB,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		String viewNameB = (String)request.getAttribute("viewNameB");
		HttpSession session = request.getSession();
		session.setAttribute("actionB", actionB);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("resultB",resultB);
		mav.setViewName(viewNameB);
		return mav;
	}
	

	@Override
	@RequestMapping(value="/memberB/updateMemberB.do", method = RequestMethod.POST)
	public ModelAndView updateMemberB(@ModelAttribute("memberB") MemberVOB memberB, HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("Call updateMemberB-method of control");
		request.setCharacterEncoding("utf-8");
		int resultB = 0;
		resultB = memberServiceB.updateMemberB(memberB);
		ModelAndView mav = new ModelAndView("redirect:/memberB/listMembersB.do");
		return mav;
	}

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
