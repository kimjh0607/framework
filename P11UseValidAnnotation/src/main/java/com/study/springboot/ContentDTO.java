package com.study.springboot;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter //롬복이용 간편화 
public class ContentDTO {
	private int id;
	
	@NotNull(message="writer is null")
	@NotEmpty(message="writer is empty")
	@Size(min=2, max=10, message="writer 최소 두자 최대 열자")
	private String writer;
	@NotNull(message="content is null")
	@NotEmpty(message="content is empty")
	private String content;
}
