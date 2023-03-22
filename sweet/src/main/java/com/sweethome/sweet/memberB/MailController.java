package com.sweethome.sweet.memberB;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/sendMail.do", method=RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			StringBuffer sb = new StringBuffer();
			sb.append("<html><body>");
			sb.append("<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
			sb.append("<h1>"+"제품소개"+"<h1><br>");
			sb.append("신간 도서를 소개합니다.<br><br>");
			sb.append("<a href='https://product.kyobobook.co.kr/detail/S000200128317'>");
			sb.append("<img src='https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791190538510.jpg' /><a><br>");
			sb.append("<a href='https://product.kyobobook.co.kr/detail/S000200128317'>상품보기</a>");
			sb.append("</body></html>");
			String str=sb.toString();
			mailService.sendMail("bomi258@naver.com", "신상품을 소개합니다.", str);
			
			/*mailService.sendMail("bomi258@naver.com", "테스트메일", "안녕하세요");
			mailService.sendPreConfiguredMail("테스트메일입니다.");*/
			out.print("메일 전송 완료");
	}
	

}
