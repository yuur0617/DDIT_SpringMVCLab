package kr.or.ddit.case8.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class InfoVO implements Serializable{
	@JsonIgnore
	private transient String info1;
	private String info2;
}
