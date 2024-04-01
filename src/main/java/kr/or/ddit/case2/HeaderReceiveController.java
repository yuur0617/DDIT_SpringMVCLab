package kr.or.ddit.case2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case2")
public class HeaderReceiveController {
	@GetMapping("header1")
	public void handler1(HttpServletRequest request) {
		String accept = request.getHeader("accept");
		log.info("accetp : {}", accept);
	}
	
	@GetMapping("header2")
	public void handler2(@RequestHeader("accept") String accept) {
		log.info("accetp : {}", accept);
	}
	
	@GetMapping("header3")
	public void handler3(@RequestHeader(value="myheader", required = false, defaultValue = "0") int customHeader) {
		log.info("customHeader : {}", customHeader);
	}
	
	@GetMapping("header4")
	public void handler4(@RequestHeader Map<String,String> headers) {
		log.info("headers : {}", headers);
		log.info("accept : {}", headers.get("accept"));
	}
	
	@GetMapping("header5")
	public void handler5(@RequestHeader MultiValueMap<String, String> headers) {
		log.info("headers : {}", headers);
		log.info("accept : {}", headers.get("accept"));
	}
	
	@GetMapping("header6")
	public void handler6(@RequestHeader HttpHeaders headers) {
		log.info("headers : {}", headers);
		log.info("accept : {}", headers.getAccept());
	}
}















