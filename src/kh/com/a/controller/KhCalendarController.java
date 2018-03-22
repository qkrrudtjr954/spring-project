package kh.com.a.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.a.arrow.CalendarUtil;
import kh.com.a.arrow.myCal;
import kh.com.a.model.CalendarDto;
import kh.com.a.model.CalendarParam;
import kh.com.a.model.MemberDto;
import kh.com.a.service.KhCalendarService;

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
		}	*/	
		
		// 연도와 달을 문자열로 변환하는 함수
		String yyyymm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> flist = khCalendarService.getCalendarList(fcal);
		
		model.addAttribute("flist", flist);
		model.addAttribute("jcal", jcal);
		
		return "calendar.tiles";		
	}
	
	// 월별일정
		@RequestMapping(value = "calendar3.do", 
				method = {RequestMethod.POST,RequestMethod.GET})
		public String calendar3(HttpServletRequest request,
				myCal jcal, Model model) throws Exception {
			logger.info("Welcome CalendarController callist! "+ new Date());
			jcal.calculate();
			String id=((MemberDto)request.getSession().getAttribute("login")).getId();
			String yyyyMm=CalendarUtil.yyyymm(
					jcal.getYear(), jcal.getMonth());
			CalendarDto fcal=new CalendarDto();
			fcal.setId(id);
			fcal.setRdate(yyyyMm);
			
			List<CalendarDto> flist= khCalendarService.getCalendarList(fcal);
			model.addAttribute("doc_title", "CALENDAR DAYLIST");
			model.addAttribute("callist", flist);
			model.addAttribute("year", jcal.getYear());
			model.addAttribute("month", jcal.getMonth());
			
			return "calendar3.tiles";
		}
		
		@RequestMapping(value="calendar2.do", 
				method={RequestMethod.GET, RequestMethod.POST})
		public String calendar2(myCal jcal, Model model){
			
			logger.info("CalendarController calendar2 " + new Date());
			model.addAttribute("doc_title", "Ajax Calendar");
			
			jcal.calculate();
			String yyyyMm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
			
			CalendarDto fcal = new CalendarDto();
			fcal.setRdate(yyyyMm);

			model.addAttribute("jcal", jcal);
			
			return "calendar2.tiles";		
		}
		
		@ResponseBody
		@RequestMapping(value="calendarjson.do", 
				method=RequestMethod.POST)		
		public Map<String, List<CalendarDto>> 
			calendarjson(CalendarDto fcal, Model model)throws Exception{
			
			logger.info("CalendarController calendarjson " + new Date());
			
			List<CalendarDto> flist=khCalendarService.getDayList(fcal);
			
			Map<String, List<CalendarDto>> map 
				= new HashMap<String, List<CalendarDto>>();
			map.put("my", flist);
			
			return map;
		}
		
		
		@RequestMapping(value = "calwrite.do", method = RequestMethod.GET)
		public String calwrite(
				HttpServletRequest request,
				myCal jcal,Model model) {
			logger.info("Welcome CalendarController calwrite! "+ new Date());
			jcal.calculate();
			model.addAttribute("jcal", jcal);
			model.addAttribute("doc_title", "CALENDAR");
			return "calwrite.tiles";
		}
		
		@RequestMapping(value = "callist.do", 
				method = {RequestMethod.POST,RequestMethod.GET})
		public String callist(HttpServletRequest request,
				CalendarParam calparam, Model model) throws Exception {
			logger.info("Welcome CalendarController callist! "+ new Date());
			
			String id=((MemberDto)request.getSession().getAttribute("login")).getId();
			String yyyyMmdd=CalendarUtil.yyyymmdd(calparam.getYear(),
					calparam.getMonth(), calparam.getDay());
			
			CalendarDto fcal=new CalendarDto(
					-1,
					id,
					null,
					null,
					yyyyMmdd,
					null
					);
			
			List<CalendarDto> flist=khCalendarService.getDayList(fcal);
			model.addAttribute("callist", flist);
			model.addAttribute("doc_title", "CALENDAR DAYLIST");
			model.addAttribute("year", calparam.getYear());
			model.addAttribute("month", calparam.getMonth());
			return "callist.tiles";
		}
		
		@RequestMapping(value = "calwriteAf.do", method = RequestMethod.POST)
		public String calwriteAf(HttpServletRequest request,
				CalendarParam calparam,Model model) throws Exception {
			logger.info("Welcome CalendarController calwriteAf! "+ new Date());

			String yyyyMmdd=CalendarUtil.yyyymmddhhmm(calparam.getYear(),
					calparam.getMonth(), calparam.getDay(),
					calparam.getHour(),calparam.getMin());
			CalendarDto fcal=new CalendarDto(
					calparam.getId(),
					calparam.getTitle(),
					calparam.getContent(),
					yyyyMmdd
					);
			
			khCalendarService.writeCalendar(fcal);
			model.addAttribute("doc_title", "CALENDAR");
			model.addAttribute("year", calparam.getYear());
			model.addAttribute("month", calparam.getMonth());
			
			return "forward:/calendar.do";
		}
		
		
		@RequestMapping(value = "caldetail.do", 
				method = {RequestMethod.GET,RequestMethod.POST})
		public String caldetail(HttpServletRequest request,
				CalendarDto fcal,Model model) throws Exception {
			logger.info("Welcome CalendarController caldetail! "+ new Date());
			
			CalendarDto flist= khCalendarService.getDay(fcal);
			String wdate=flist.getWdate();
			
			String year=wdate.substring(0,4);
			String month=CalendarUtil.toOne(wdate.substring(4,6))+"";
			String urls=String.format("%s?year=%s&month=%s",
					"calendar.do",year,month);
			model.addAttribute("cal", flist);
			model.addAttribute("urls", urls);
			model.addAttribute("doc_title", "CALENDAR DETAIL");
			return "caldetail.tiles";
		}
		
		@RequestMapping(value="caldel.do", method={RequestMethod.GET, RequestMethod.POST})
		public String caldel(CalendarDto dto) {
			logger.info("Welcome CalendarController caldel! "+ new Date());
			
			khCalendarService.delCal(dto.getSeq());
			return "redirect:/calendar.do";
		}
	
}










