package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.BasicBbsDto;

@Repository //이 클래스가 DB와 연통하여 데이터를 처리하는 DAO임을 나타냄.
public class BasicBbsDao implements IBasicBbsDao {
	
	@Autowired //JdbcTemplate(SQL쿼리를 실행)타입의 객체를 자동주입.
	JdbcTemplate jtemplete;
	
	@Override //DB에서 게시글의 목록을 가져와 그 결과를 BBD타입의 리스트로 반환
	public List<BasicBbsDto> listDao() { 
		System.out.println("listDao()");
		String query="select * from basic_bbs order by id desc";
		List<BasicBbsDto> dtos=jtemplete.query(query, 
			new BeanPropertyRowMapper<BasicBbsDto>(BasicBbsDto.class));
		return dtos;
	}

	@Override //ID를 인자로 받아 해당 게시글의 정보를 DB에서 가져오고 BBD객체로 반환
	public BasicBbsDto viewDao(String id) {
		System.out.println("viewDao()");
		String query="select * from basic_bbs where id="+id;
		BasicBbsDto dto=jtemplete.queryForObject(query,
			new BeanPropertyRowMapper<BasicBbsDto>(BasicBbsDto.class));
		return dto;
	}

	@Override //세 인자를 받아 DB에 새로운 게시글을 추가, 성공하면=1 실패하면=0 반환
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		String query="insert into basic_bbs(id,writer,title,content) "+
				"values(basic_bbs_seq.nextval,?,?,?)";
		return jtemplete.update(query,writer,title,content);
	}

	@Override //ID를 인자로받아 해당 게시글을 DB에서 삭제 성공=1, 실패=0
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		String query="delete from basic_bbs where id=?";
		return jtemplete.update(query,Integer.parseInt(id));
	}

}
