package kh.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.a.model.BbsDto;
import kh.com.a.model.BbsParam;
import kh.com.a.service.KhBbsService;

@Controller
public class KhBbsController {

	private static final Logger logger = LoggerFactory.getLogger(KhBbsController.class);
	
	@Autowired
	KhBbsService khBbsService;
	
	@RequestMapping(value="bbslist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String bbslist(Model model, BbsParam param) throws Exception{
		logger.info("KhBbsController bbslist param : {}", param);		

		model.addAttribute("doc_title", "BBS 글 목록");
		
		int sn = param.getPageNumber();
		int start = (sn)*param.getRecordCountPerPage()+1;
		int end = (sn+1)*param.getRecordCountPerPage();
		
		param.setStart(start);
		param.setEnd(end);
		
		int totalRecordCount = khBbsService.getBbsCount(param);		
		
		List<BbsDto> list = khBbsService.getBbsPagingList(param);
		model.addAttribute("bbslist", list);
		
		model.addAttribute("pageNumber", sn);
		model.addAttribute("pageCountPerScreen", 10);
		model.addAttribute("recordCountPerPage", param.getRecordCountPerPage());
		model.addAttribute("totalRecordCount", totalRecordCount);
		
		model.addAttribute("s_category", param.getS_category());
		model.addAttribute("s_keyword", param.getS_keyword());
		
		
		return "bbslist.tiles";
	}
	
	@RequestMapping(value = "bbswrite.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswrite(Model model) {
		logger.info("KhBbsController bbswrite "+ new Date());
		return "bbswrite.tiles";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs, Model model) throws Exception {
		if(bbs.getContent().equals("") || bbs.getTitle().equals("")){
			return "bbswrite.tiles";
		}
		logger.info("Welcome KhBbsController bbswriteAf! "+ new Date());
		
		khBbsService.writeBbs(bbs);
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq,Model model) throws Exception {
		logger.info("Welcome KhBbsController bbsdetail! "+ new Date());
		BbsDto bbs=null;		
		bbs=khBbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		return "bbsdetail.tiles";
	}
	/*
	@RequestMapping(value = "answer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answer(int seq, Model model) throws Exception {
		logger.info("Welcome KhBbsController answer! "+ new Date());
		BbsDto bbs=null;		
		bbs=khBbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		return "answer";
	}
	
	@RequestMapping(value = "answerAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answerAf(BbsDto bbs, Model model) throws Exception {
		logger.info("Welcome KhBbsController answer! "+ new Date());
		khBbsService.reply(bbs);		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs(int seq, Model model) throws Exception {
		logger.info("Welcome KhBbsController deleteBbs! "+ new Date());
		khBbsService.deleteBbs(seq);
		return "redirect:/bbslist.do";		
	}
	
	@RequestMapping(value = "bbsupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(int seq, Model model) throws Exception{
		logger.info("Welcome KhBbsController bbsupdate! "+ new Date());
		
		BbsDto bbs=khBbsService.getBbs(seq);		
		model.addAttribute("bbs", bbs);		
		return "bbsupdate";
	}*/
	 
}






