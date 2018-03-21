package kh.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.a.model.CalendarDto;
import kh.com.a.model.MemberDto;
import kh.com.a.model.myCal;
import kh.com.a.service.KhCalendarService;
import kh.com.a.util.CalendarUtil;

@Controller
public class KhCalendarController {
	
	private static final Logger logger = LoggerFactory.getLogger(KhCalendarController.class);
	
	@Autowired
	private KhCalendarService khCalendarService;

	@RequestMapping(value="calendar.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String calendar(HttpServletRequest req, Model model, myCal jcal) throws Exception{
		logger.info("Welcome CalendarController calendar! "+ new Date());
		
		model.addAttribute("doc_title", "달력");
		
		jcal.calculate(); // 현재 시간 설정 및 취득
		
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		/*String smonth = "";
		if((jcal.getMonth() + "").length() < 2) {	// 1 -> 01 로 만들어 주기 위해서
			smonth = "0" + (jcal.getMonth() + "");
		}
		String yyyymm = jcal.getYear() + smonth;
		*/
		
		String yyyymm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> flist = khCalendarService.getCalendarList(fcal);
		
		model.addAttribute("flist", flist);
		model.addAttribute("jcal", jcal);
		
		return "calendar.tiles";		
	}
	
}










