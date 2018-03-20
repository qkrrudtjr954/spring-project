package kh.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhCalendarDao;
import kh.com.a.model.CalendarDto;

@Repository
public class CalendarDaoImpl implements KhCalendarDao {

	@Autowired
	private SqlSession sqlSession;
	private String ns = "KHCalendar.";

	@Override
	public List<CalendarDto> getCalendarList(CalendarDto fcal) throws Exception {
		List<CalendarDto> list = sqlSession.selectList(ns+"getCalendarList", fcal);
		return list;
	}
	

}
