package com.poscodx.msa.service.emaillist.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmaillistVo {
	private Long no;
	private String firstName;
	private String lastName;
	private String email;
}