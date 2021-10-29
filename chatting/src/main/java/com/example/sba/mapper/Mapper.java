package com.example.sba.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.sba.domain.Member;

public interface Mapper {
	@Select("select * from members where email=#{email} and pwd=#{pwd}")
	public Member getMember(@Param("email") String email, @Param("pwd") String pwd);
}
