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
	
	@RequestMapping(value="bbslist.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String bbslist(Model model, BbsParam param) throws Exception{
		logger.info("KhBbsController bbslist");
		
		model.addAttribute("doc_title", "BBS 글목록");
		
		// paging 처리
		int sn = param.getPageNumber();
		int start = (sn) * param.getRecordCountPerPage() + 1;
		int end = (sn+1) * param.getRecordCountPerPage();
		
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
		
		System.out.println(param.toString());
		
		return "bbslist.tiles";
	}
	
	@RequestMapping(value = "bbswrite.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswrite(Model model) {
		
		model.addAttribute("doc_title", "BBS 글쓰기");
		
		logger.info("Welcome SistMemberController bbswrite! "+ new Date());
		return "bbswrite.tiles";
	}
	
	@RequestMapping(value = "bbswriteAf.do", 
			method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs, Model model) throws Exception {
		if(bbs.getContent().equals("") || bbs.getTitle().equals("")){
			return "bbswrite";
		}
		logger.info("Welcome SistMemberController bbswriteAf! "+ new Date());
		khBbsService.writeBbs(bbs);
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdetail.do", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String bbsdetail(BbsDto bbs, Model model)throws Exception {
		logger.info("Welcome KhBbsController bbsdetail! "+ new Date());				
		
		model.addAttribute("doc_title", "BBS 상세보기");			
		
		khBbsService.readCount(bbs.getSeq());		
		BbsDto rbbs=khBbsService.getBbs(bbs.getSeq());		
		model.addAttribute("bbs", rbbs);
		return "bbsdetail.tiles";
	}
	
	@RequestMapping(value = "bbsreply.do", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String bbsreply(BbsDto bbs, Model model)throws Exception {
		logger.info("Welcome KhBbsController bbsreply! "+ new Date());
		
		model.addAttribute("doc_title", "BBS 답글달기");
		
		BbsDto rbbs = khBbsService.getBbs(bbs.getSeq());
		model.addAttribute("bbs", rbbs);
		return "bbsreply.tiles";
	}
	
	@RequestMapping(value = "bbsreplyAf.do", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String bbsreplyAf(BbsDto bbs, Model model) {
		logger.info("Welcome KhBbsController bbsreplyAf! "+ new Date());
	
		try {
			khBbsService.reply(bbs);
		} catch (Exception e) {	}
			
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsupdate.do", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String bbsupdate(BbsDto bbs, Model model)throws Exception {
		logger.info("Welcome BBSController bbsupdate! "+ new Date());
		logger.info("Welcome BBSController SistBBSDTO! "+ bbs);
		model.addAttribute("doc_title", "BBS 수정하기");
		
		BbsDto rbbs = khBbsService.getBbs(bbs.getSeq());
		model.addAttribute("bbs", rbbs);
		return "bbsupdate.tiles";
	}
	
	@RequestMapping(value = "bbsupdateAf.do", 
			method = RequestMethod.POST)
	public String bbsupdateAf(BbsDto bbs,Model model) throws Exception {
		logger.info("Welcome BBSController bbsupdateAf! "+ new Date());
		khBbsService.updateBbs(bbs);
		return "redirect:/bbslist.do";
	}
	
	
}






