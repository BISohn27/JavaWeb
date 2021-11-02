package com.example.sba.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.sba.domain.Member;

public interface MemberMapper {
	@Select("select * from members where email=#{email} and pwd=#{pwd}")
	public Member getLogin(@Param("email")String email, @Param("pwd")String pwd)throws Exception;
	@Select("select * from members limit 10")
	public List<Member> getMemberList () throws Exception;
	@Select("select * from members where email=#{email}")
	public Member getLoginInfo(@Param("email")String email)throws Exception;
	
	//xml로 접근 시 사용하는 함수
	//함수명과 xml id를 일치
	public Member getMember(@Param("email")String email)throws Exception;
	public void createMember(Map<String,String> map) throws Exception;
}
