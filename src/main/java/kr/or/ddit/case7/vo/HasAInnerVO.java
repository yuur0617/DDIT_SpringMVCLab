package kr.or.ddit.case7.vo;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class HasAInnerVO {
	
	private String innerParam1;
	@Min(1)
	private int innerParam2;
}
