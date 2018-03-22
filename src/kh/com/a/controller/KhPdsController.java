package kh.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kh.com.a.arrow.FUpUtil;
import kh.com.a.model.PdsDto;
import kh.com.a.service.KhPdsService;

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
	
	@RequestMapping(value="pdswrite.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdswrite(Model model) {
		logger.info("KhPdsController >> pdswrite >> {}", new Date());
		return "pdswrite.tiles";
	}
	
	@RequestMapping(value="pdsupload.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdsupload(PdsDto pdsdto, HttpServletRequest req, @RequestParam(value="fileload", required=false) MultipartFile fileload, Model model) {
		
		model.addAttribute("doc_title", "자료 업로드");
		
		//	upload MultipartResolver
		logger.info("KhPdsController >> pdsupload >> {}", new Date());
		
		pdsdto.setFilename(fileload.getOriginalFilename());

		String fupload = req.getServletContext().getRealPath("/upload");
		//	String fupload = "d://tmp";
		logger.info("uploader path : {}", fupload);
		
		String f = pdsdto.getFilename();
		String newFile = FUpUtil.getNewFile(f);
		
		logger.info("file upload to {}/{}", fupload, newFile);
		pdsdto.setFilename(newFile);
		
		
		try {
			File file = new File(fupload+"/"+newFile);
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			khPdsService.uploadPds(pdsdto);
			
			logger.info("file upload success");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("file upload fail");
		
		}
		
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value="fileDownload.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String download(int seq, String filename, HttpServletRequest req, Model model) {
		
		String fupload = req.getServletContext().getRealPath("/upload");
		//	String fupload = "d://tmp";
		
		File downloadFile = new File(fupload+"/"+filename);
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("seq", seq);
		
		//	servlet-context에 선언된 클래스로 이동한다.
		return "downloadView";
	}
	
}
