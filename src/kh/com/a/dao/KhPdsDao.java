package kh.com.a.dao;

import java.util.List;

import kh.com.a.model.PdsDto;

public interface KhPdsDao {
	public List<PdsDto> getPdsList();
	public void uploadPds(PdsDto dto);
}
