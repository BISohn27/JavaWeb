package dao;

import java.util.List;

import dto.Member;

public interface MemberDAO {
	List<Member> selectList() throws Exception;
	int insert(Member member) throws Exception;
	int delete(int no) throws Exception;
	Member selectOne(int no) throws Exception;
	int update(Member member) throws Exception;
	Member exist(String id, String password) throws Exception;
}
