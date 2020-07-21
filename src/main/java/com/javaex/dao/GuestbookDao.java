package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	//방명록 리스트 가져오기
	public List<GuestVo> select(){
		System.out.println("guestbookDao/select");
		
		return sqlSession.selectList("guestbook.select");
	}
	
	//방명록 글 저장
	public int insert(GuestVo guestbookVo){
		System.out.println("guestbookDao/insert");
		
		return sqlSession.insert("guestbook.insert", guestbookVo);	
	}
	
	//방명록 글 삭제
	public int delete(GuestVo guestbookVo){
		System.out.println("guestbookDao/delete");
		
		return sqlSession.delete("guestbook.delete", guestbookVo);
	}

	//방명록 글 저장(ajax)
	public void insertSelectKey(GuestVo guestbookVo) {
		System.out.println(guestbookVo.toString()); //no값 없음
		sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		System.out.println(guestbookVo.toString()); //no값 있음
	}
	
	//글가져오기(ajax 자신이 등록한 글)
	public GuestVo selectByNo(int no) {
		return sqlSession.selectOne("guestbook.selectByNo", no);
	}
	
}
