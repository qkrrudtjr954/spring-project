package kh.com.a.service;

import java.util.List;

import kh.com.a.model.CalendarDto;

public interface KhCalendarService {

	List<CalendarDto> getCalendarList(CalendarDto fcal) throws Exception;
	
}







