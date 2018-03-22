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

import kh.com.a.model.PdsDto;
import kh.com.a.service.KhPdsService;
import kh.com.a.service.impl.KhPdsServiceImpl;

@Controller
public class KhPdsController {
	private static final Logger logger = LoggerFactory.getLogger(KhPdsController.class);
	
	@Autowired
	private KhPdsService khPdsService;
	
	@RequestMapping(value="pdslist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdslist(Model model) {
		
		logger.info("KhPdsController >> pdslist >> {}", new Date());
		
		List<PdsDto> pdslist = khPdsService.getPdsList();
		
		model.addAttribute("doc_title", "자료실");
		model.addAttribute("pdslist", pdslist);
		
		return "pdslist.tiles";
	}
	
	
}
