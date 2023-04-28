package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.IBasicBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired //BasicBbsDao타입의 객체를 자동 주입.
	IBasicBbsDao dao; //@Autowired 를 붙이지 않으면 BasicBbsDao 의 객체가 된다
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";  //주소list를 호출한다
	}
	
	@RequestMapping("/list") //게시글 목록을 보여주는 페이지를 처리, 모델에 게시글 목록을 추가하고 list뷰 반환.
	public String userlist(Model model) {
		model.addAttribute("list",dao.listDao());
		return "list";
	}
	
	@RequestMapping("/write") //게시글 작성폼을 보여주는 페이지처리
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/writing") //게시글 작성요청을 처리. 작성자 제목 내용받아 db에 저장후 게시글 목록페이지로 리다이렉트
	public String write(HttpServletRequest req,Model model) {
		dao.writeDao(req.getParameter("writer")
				, req.getParameter("title")
				, req.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/view") //요청에서 게시글의 ID를 받아 해당 게시글의 정보를 모델에 추가, 'view'라는 뷰를 반환
	public String detailView(HttpServletRequest req,Model model) {
		String uId=req.getParameter("id");
		model.addAttribute("dto",dao.viewDao(uId));
		return "view";
	}
	
	@RequestMapping("/delete") //요청에서 게시글의 ID를 받아 해당 게시글을 db에서 삭제하고 목록 페이지로 리다이렉트
	public String delete(HttpServletRequest req,Model model) {
		dao.deleteDao(req.getParameter("id"));
		return "redirect:list";
	}
}








