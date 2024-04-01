package kr.or.ddit.case3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case3")
public class Model2CaseController {
	@GetMapping("sendRequest1")
	public String handler1() {
		String logicalViewName = "case3/inner1";
		return logicalViewName;		
	}
	
	@GetMapping(value = "sendRequest2")
	public String handler2() {
		return "jsonView";
	}
	
	@RequestMapping(value="sendRequest3", method = RequestMethod.GET, produces = "text/html")
	public void handler3_html() {
		log.info("=======(HTML 요청 처리)===============");
	}
	
	@GetMapping(value="sendRequest3", produces = "application/json")
	public void handler3_json() {
		log.info("======(JSON 요청 처리)================");
	}
}













