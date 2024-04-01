package kr.or.ddit.case6;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.case6.vo.Case6DummyVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case6")
public class ParameterReceiveController {
	
	@GetMapping("sendParameter1")
	public void handler1(@RequestParam(required = true) String param1) {
		log.info("param1 : {}", param1);
	}
	
	@GetMapping("sendParameterAndHeader")
	public void handler2(
			String param1
			, @RequestHeader("accept-language") String acceptLanguage
			, Locale reqLocale
	) {
		log.info("param1 : {}", param1);
		log.info("acceptLanguage : {}", acceptLanguage);
		log.info("reqLocale : {}", reqLocale);
	}
	
	@GetMapping("sendParameter3")
	public void handler3(@RequestParam(required = false, defaultValue = "1") int param1) {
		log.info("param1 : {}", param1);
	}
	
	@GetMapping("sendParameter4")
	public void handler4(@RequestParam Map<String, Object> parameterMap) {
		log.info("parameter map : {}", parameterMap);
	}
	
	@GetMapping("sendParameter5")
	public void handler5(@RequestParam MultiValueMap<String, Object> parameterMap) {
		log.info("parameter map : {}", parameterMap);
	}
	
	@GetMapping("sendParameter6")
	public String handler6(@ModelAttribute("dummy") Case6DummyVO dummy) {
		log.info("dummy : {}", dummy);
		return "case6/modelView1";
	}
}























