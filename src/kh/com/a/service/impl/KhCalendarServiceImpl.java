package kh.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.a.dao.KhCalendarDao;
import kh.com.a.model.CalendarDto;
import kh.com.a.service.KhCalendarService;

@Service
public class KhCalendarServiceImpl implements KhCalendarService {

	@Autowired
	private KhCalendarDao khCalendarDao; 
	
	@Override
	public List<CalendarDto> getCalendarList(CalendarDto fcal) throws Exception {
		// TODO Auto-generated method stub
		return khCalendarDao.getCalendarList(fcal);		
	}

	@Override
	public List<CalendarDto> getDayList(CalendarDto fcal) throws Exception {
		// TODO Auto-generated method stub
		return khCalendarDao.getDayList(fcal);		
	}

	@Override
	public boolean writeCalendar(CalendarDto cal) throws Exception {
		return khCalendarDao.writeCalendar(cal);
	}

	@Override
	public CalendarDto getDay(CalendarDto fcal) throws Exception {
		return khCalendarDao.getDay(fcal);
	}

	@Override
	public void delCal(int seq) {
		khCalendarDao.delCal(seq);		
	}
	
	
	

	
}
