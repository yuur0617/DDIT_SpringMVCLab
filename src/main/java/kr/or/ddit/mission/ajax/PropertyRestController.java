package kr.or.ddit.mission.ajax;

import java.util.Collection;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.mission.vo.PropertyVO;

/**
 * RESTfurl URI
 * 명사(자원의 식별자) : /mission/ajax/property
 *  /mission/ajax/property(GET) : 전체 조회  
 *  /mission/ajax/property/a001(GET) : 한건 조회   /mission/ajax/property?propertyName=a001
 *  /mission/ajax/property/a001(PUT) : 한건 수정
 *  /mission/ajax/property/a001(DELETE) : 한건 삭제
 *  /mission/ajax/property(POST) : 신규 등록
 *
 */
//@Controller
@RestController
@RequestMapping(value="/mission/ajax/property", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PropertyRestController {
	@GetMapping
//	@ResponseBody
	public Collection<PropertyVO> getAll() {
		return null;
	}
	
	@GetMapping("{propertyName}")
//	@ResponseBody
	public PropertyVO getOne(@PathVariable String propertyName) {
		return null;
	}
	
	@PostMapping
//	@ResponseBody
	public Map<String, Object> insert(@RequestBody PropertyVO newProp) {
		return null;
	}
	
	@PutMapping("{propertyName}")
//	@ResponseBody
	public Map<String, Object> update(@RequestBody PropertyVO newProp) {
		return null;
	}
	
	@DeleteMapping("{propertyName}")
//	@ResponseBody
	public Map<String, Object> delete(@PathVariable String propertyName) {
		return null;
	}
}



























