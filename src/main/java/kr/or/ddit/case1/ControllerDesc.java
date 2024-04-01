package kr.or.ddit.case1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case1/request1.do")
public class ControllerDesc {
	
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public void handler1() {
		log.info("handler method 1번 동작(GET)");
	}
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public void handler2() {
		log.info("handler method 2번 동작(POST)");
	}
	
	@RequestMapping
	public void handler3() {
		log.info("handler method 3번 동작(others...)");
	}
	
}















