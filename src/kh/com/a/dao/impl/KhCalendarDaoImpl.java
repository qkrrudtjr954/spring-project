package kh.com.a.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhCalendarDao;
import kh.com.a.model.CalendarDto;

@Repository
public class KhCalendarDaoImpl implements KhCalendarDao {
	
	@Autowired
	private SqlSession sqlSession;
	private String ns = "KHCalendar.";

	@Override
	public List<CalendarDto> getCalendarList(CalendarDto fcal) throws Exception {
		List<CalendarDto> list = sqlSession.selectList(ns+"getCalendarList", fcal);
		return list;
	}

	@Override
	public List<CalendarDto> getDayList(CalendarDto fcal) throws Exception {
		List<CalendarDto> callist = new ArrayList<CalendarDto>();
		return callist = sqlSession.selectList(ns+"getDayList", fcal);	
	}

	@Override
	public boolean writeCalendar(CalendarDto cal) throws Exception {
		sqlSession.insert(ns+"writeCalendar",cal);
		return true;
	}

	@Override
	public CalendarDto getDay(CalendarDto fcal) throws Exception {
		return (CalendarDto)sqlSession.selectOne(ns+"getDay",fcal);
	}

	@Override
	public void delCal(int seq) {
		sqlSession.delete(ns+"delCal", seq);
	}
	
	
	
}



