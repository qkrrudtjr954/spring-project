package kh.com.a.arrow;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import kh.com.a.service.KhPdsService;

public class DownloadView extends AbstractView {

	@Autowired
	KhPdsService khPdsService;
	
	private static final Logger logger = LoggerFactory.getLogger(DownloadView.class);

	public DownloadView() {
		logger.info("DownloadView");
	}
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		logger.info("DownloadView");
		
		File file = (File)model.get("downloadFile");
		resp.setContentType(this.getContentType());
		resp.setContentLength((int)file.length());
		
		String userAgent = req.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;	//	Microsoft Internet Exploer 가 아닐 때
		
		String filename = null;
		
		if(ie) {
			filename = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			filename = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");
        resp.setHeader("Content-Length", "" + file.length());
        resp.setHeader("Pragma", "no-cache;");
        resp.setHeader("Expires", "-1;");
		
        OutputStream out = resp.getOutputStream();
        FileInputStream fis = null;
        
        try {
        	fis = new FileInputStream(file);
        	
        	//	file copy api in springframework
        	FileCopyUtils.copy(fis, out);
        	
        	// download count 증가
        	int seq = (int)model.get("seq");
        	
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	if(fis!=null) fis.close();
        	if(out!=null) out.close();
        }
	}

}
