package com.sweethome.sweet.memberB.controller;

import java.io.IOException;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sweethome.sweet.memberB.service.MemberServiceB;
import com.sweethome.sweet.memberB.vo.MemberVOB;
import com.sweethome.sweet.memberB.vo.ContractVO;

@Controller("memberControllerB")
//@EnableAspectJAutoProxy
public class MemberControllerBImpl implements MemberControllerB {
	@Autowired
	private MemberServiceB memberServiceB;
	@Autowired
	private MemberVOB memberVOB ;
	@Autowired
	private ContractVO contractVO ;
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	
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
	       mav.setViewName("redirect:/main.do");	
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
		String viewName = (String)request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	//회원 정보 수정
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
	        return new ModelAndView("redirect:/memberB/loginB.do"); // 로그인 페이지로 이동합니다.
	    }

	    // 2. 로그인한 회원 정보를 사용해 회원 정보 수정을 진행합니다.
	    MemberVOB memberVOB = memberServiceB.modMemberB(memberB.getBp_id());
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("memberB",memberVOB);
	    mav.setViewName(viewName);
	    return mav;    
	}

	//수정한 회원 정보 업데이트
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
	
	//비밀번호 찾기 form
	@RequestMapping(value = "/memberB/pwFind")
	public String pwFind() throws Exception{
		return "/memberB/pwFind";
	}
	
	//이메일로 인증번호 보내기
	@RequestMapping(value = "/memberB/sendMail", method = RequestMethod.POST)
	public ModelAndView sendMail(HttpSession session, 
			@RequestParam("name") String name,
			@ModelAttribute("email") String email,
            HttpServletRequest request, 
            HttpServletResponse response) throws IOException {
		String viewName = "/memberB/sendMail";
	    System.out.println("viewName : "+viewName);
		
		MemberVOB vo = memberServiceB.selectMemberB(email);
			
		if(vo != null) {
		Random r = new Random();
		int num = r.nextInt(999999); // 랜덤난수설정
		
		if (vo.getName().equals(name)) {
			session.setAttribute("email", vo.getEmail1() + vo.getEmail2());

			String setfrom = "bomi258@naver.com"; //보내는사람 
			String tomail = email; //받는사람
			String title = "[스윗홈] 비밀번호변경 인증 이메일 입니다"; 
			String content = System.getProperty("line.separator") + "안녕하세요 회원님" + System.getProperty("line.separator")
					+ "비밀번호변경 인증번호는 " + num + " 입니다." + System.getProperty("line.separator"); // 

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

				messageHelper.setFrom(setfrom); 
				messageHelper.setTo(tomail); 
				messageHelper.setSubject(title);
				messageHelper.setText(content); 

				mailSender.send(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			ModelAndView mv = new ModelAndView();
			mv.setViewName("/memberB/sendMail");
			mv.addObject("num", num);
			return mv;
		}else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/memberB/pwFind");
			return mv;
		}
		}else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/memberB/pwFind");
			return mv;
		}
	}
	
	//이메일 인증번호 확인
	@RequestMapping(value = "/memberB/checkEmail", method = RequestMethod.POST)
	public String pw_set(@RequestParam(value="email_injeung") String email_injeung, @RequestParam(value = "num") String num) throws IOException{
			
			if(email_injeung.equals(num)) {
				return "/memberB/pwNew";
			}
			else {
				return "/memberB/pwFind";
			}
	} 
	
	//새 비밀번호 없데이트
	@RequestMapping(value = "/memberB/pwNew", method = RequestMethod.POST)
	public String pwNew(MemberVOB vo, HttpSession session) throws IOException{
		int result = memberServiceB.pwUpdate(vo);
		if(result == 1) {
			return "/memberB/loginFormB.do";
		}
		else {
			System.out.println("pw_update"+ result);
			return "/memberB/pwNew";
		}
	}
}
