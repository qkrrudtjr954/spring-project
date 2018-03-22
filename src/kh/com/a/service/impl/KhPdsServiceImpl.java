package kh.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.a.dao.KhPdsDao;
import kh.com.a.model.PdsDto;
import kh.com.a.service.KhPdsService;

@Service
public class KhPdsServiceImpl implements KhPdsService{


	@Autowired
	private KhPdsDao pdsDao;
	
	@Override
	public List<PdsDto> getPdsList() {
		return pdsDao.getPdsList();
	}

}
