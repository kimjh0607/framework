package com.study.springboot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //롬복이용 간편화 
public class ContentDTO {
	private int id;
	private String writer;
	private String content;
}
