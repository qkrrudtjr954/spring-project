package kh.com.a.service;

import java.util.List;

import kh.com.a.model.CalendarDto;

public interface KhCalendarService {
	public List<CalendarDto> getCalendarList(CalendarDto fcal) throws Exception;
	public List<CalendarDto> getDayList(CalendarDto fcal) throws Exception;
	
	public boolean writeCalendar(CalendarDto cal) throws Exception;
	public CalendarDto getDay(CalendarDto fcal) throws Exception;
	
	public void delCal(int seq);
}
