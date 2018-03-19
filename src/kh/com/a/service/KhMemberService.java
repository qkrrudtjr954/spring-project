package kh.com.a.service;

import kh.com.a.model.MemberDto;

public interface KhMemberService {
	public boolean addmember(MemberDto mem) throws Exception;
	public MemberDto login(MemberDto mem) throws Exception;
}
