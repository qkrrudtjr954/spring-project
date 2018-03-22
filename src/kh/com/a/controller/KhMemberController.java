package kh.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.a.model.MemberDto;
import kh.com.a.model.YesMember;
import kh.com.a.service.KhMemberService;

@Controller
public class KhMemberController {
	private static final Logger logger = LoggerFactory.getLogger(KhMemberController.class);
	
	@Autowired
	KhMemberService khMemberService;
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("KhMemberController login");
		return "login.tiles";
	}
	
	
	@RequestMapping(value="regi.do", method=RequestMethod.GET)
	public String regi(Model model) {
		logger.info("KhMemberController regi");				
		return "regi.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="getID.do", method=RequestMethod.POST)
	public YesMember getID(Model model, MemberDto mem) {
		logger.info("KhMemberController getID");	
		
		int count = khMemberService.getID(mem);
		
		YesMember yes = new YesMember();
		if(count > 0) {
			yes.setMessage("SUCS");
		}else {
			yes.setMessage("FAIL");
		}
		return yes;		
	}
	
	
	
	@RequestMapping(value="regiAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String regiAf(MemberDto mem, Model model)throws Exception{
		logger.info("KhMemberController regiAf");	
		
		khMemberService.addmember(mem);		
		return "login.tiles";		
	}	
	
	@RequestMapping(value="loginAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String loginAf(HttpServletRequest req, MemberDto mem, Model model)throws Exception{
		logger.info("KhMemberController loginAf");
		
		MemberDto login = null;
		login = khMemberService.login(mem);
		
		if(login != null && !login.getId().equals("")) {
			req.getSession().setAttribute("login", login);
			return "redirect:/bbslist.do";
		}else {
			return "redirect:/login.do";
		}		
	}
	
	@RequestMapping(value="logout.do", 
			method=RequestMethod.GET)
	public String logout(HttpServletRequest req, Model model)throws Exception{
		logger.info("Welcome logout");		
		req.getSession().invalidate();			
		return "login.tiles";		
	}
	
	
}













