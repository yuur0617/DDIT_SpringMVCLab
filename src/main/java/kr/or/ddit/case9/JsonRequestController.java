package kr.or.ddit.case9;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.case9.vo.PayloadVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case9")
public class JsonRequestController {
	@PostMapping("jsonPayload1")
	@ResponseBody
	public Map<String, Object> handler1(@RequestBody Map<String, Object> payload) {
		log.info("payload : {}", payload);
		return payload;
	}
	
	@PostMapping("jsonPayload2")
	@ResponseBody
	public PayloadVO handler2(@RequestBody PayloadVO payload) {
		log.info("payload : {}", payload);
		return payload;
	}
}















