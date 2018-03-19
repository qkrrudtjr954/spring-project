package kh.com.a.dao;

import kh.com.a.model.MemberDto;

public interface KhMemberDao {

	boolean addmember(MemberDto mem)throws Exception;
	
	MemberDto login(MemberDto mem)throws Exception;
}
