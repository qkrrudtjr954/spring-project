package kh.com.a.service;

import java.util.List;

import kh.com.a.model.PdsDto;

public interface KhPdsService {
	public List<PdsDto> getPdsList();
	public void uploadPds(PdsDto dto);

}
