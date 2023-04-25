package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValController {
	@RequestMapping("/")
	public String root() {
		return "insertForm";//insertForm을 연결할 Mapping설정
	}
	
	@RequestMapping("/done")// "/done"이라는 주소와 'done()'이라는 메소드를 매핑하여 클라이언트 요청을 처리
	public String insert(@ModelAttribute("dto") ContentDTO contentDto, 
			BindingResult result) {
		String page="donePage";
		
		if(result.hasErrors()) {
			System.out.println("getAllErrors : "+result.getAllErrors());
			if(result.getFieldError("writer")!=null) {
				System.out.println("error:"
						+result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content")!=null) {
				System.out.println("error:"
						+result.getFieldError("content").getCode());
			}
			page = "insertForm";//insertForm으로 다시 돌아간다
		}
		return page;
	}
}
