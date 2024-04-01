package kr.or.ddit.case7.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

/**
 * command object 활용할 객체
 *
 */
@Data
public class SampleVO {
	@NotBlank
	private String strParam;
	@Min(1)
	private int numParam;
	private char chParam;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateParam;
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime dateTimeParam;
	
	private Integer optionParam;
	
	// has a 관계
	@NotNull
	@Valid
	private HasAInnerVO inner;
	// has many 관계
	@NotEmpty
	@Valid
	private List<@NotNull HasManyInnerVO> innerList;
}



















