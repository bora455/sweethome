package com.sweethome.sweet.memberB;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller("memberBController")
public class MemberBController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberBController.class);
	
	@RequestMapping(value = "/memberB/goodsList", method = RequestMethod.GET)
	public String goodsList(Locale locale, Model model) {
		logger.info("상품 목록", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/memberB/goodsList";
	}
	
	@RequestMapping(value = "/memberB/goodsDetail", method = RequestMethod.GET)
	public String item(Locale locale, Model model) {
		logger.info("상품 상세", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/memberB/goodsDetail";
	}
	
	@RequestMapping(value = "/memberB/goodsAdd", method = RequestMethod.GET)
	public String add(Locale locale, Model model) {
		logger.info("상품 등록", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/memberB/goodsAdd";
	}
	
	@RequestMapping(value = "/memberB/goodsMod", method = RequestMethod.GET)
	public String edit(Locale locale, Model model) {
		logger.info("상품 수정", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/memberB/goodsMod";
	}
	
	@RequestMapping(value = "/memberB/memberBMod", method = RequestMethod.GET)
	public String modBP(Locale locale, Model model) {
		logger.info("회원 정보 수정", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/memberB/memberBMod";
	}
	
	@RequestMapping(value = "/memberB/myPageMainB", method = RequestMethod.GET)
	public String myPageMainB(Locale locale, Model model) {
		logger.info("마이페이지", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/memberB/myPageMainB";
	}
	
}
