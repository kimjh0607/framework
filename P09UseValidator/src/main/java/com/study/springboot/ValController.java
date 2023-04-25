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
	
	@RequestMapping("/done")
	public String insert(@ModelAttribute("dto") ContentDTO contentDto, 
			BindingResult result) {
		System.out.println(contentDto);
		String page="donePage";
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto, result);
		if(result.hasErrors()) {
			page = "insertForm";//insertForm으로 다시 돌아간다
		}
		return page;
	}
}
