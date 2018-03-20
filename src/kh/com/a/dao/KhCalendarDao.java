package kh.com.a.dao;

import java.util.List;

import kh.com.a.model.BbsDto;
import kh.com.a.model.BbsParam;
import kh.com.a.model.CalendarDto;

public interface KhCalendarDao {

	List<CalendarDto> getCalendarList(CalendarDto fcal) throws Exception;
	

}
