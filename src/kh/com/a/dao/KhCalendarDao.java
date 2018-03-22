package kh.com.a.dao;

import java.util.List;

import kh.com.a.model.CalendarDto;

public interface KhCalendarDao {
	
	public List<CalendarDto> getCalendarList(CalendarDto fcal) throws Exception;
	public List<CalendarDto> getDayList(CalendarDto fcal)throws Exception;
	
	public boolean writeCalendar(CalendarDto cal) throws Exception;
	public CalendarDto getDay(CalendarDto fcal) throws Exception;
	
	public void delCal(int seq);
}
