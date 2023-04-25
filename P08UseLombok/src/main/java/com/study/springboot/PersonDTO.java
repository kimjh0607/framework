package com.study.springboot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //lombok 어노테이션
@Setter
@ToString
public class PersonDTO {
	private String name;
	private String age;
}
