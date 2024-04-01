package kr.or.ddit.case2;

import java.net.URLDecoder;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case2")
public class CookieReceiveController {
	@GetMapping("cookie1")
	public void handler1(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		Arrays.stream(cookies)
			.forEach(c->{
				try {
					String decoded = URLDecoder.decode(c.getValue(), "UTF-8");
					log.info("{} : {}", c.getName(), decoded);
				}catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
	}
	
	@GetMapping("cookie2")
	public void handler2(@CookieValue String sample2) {
		log.info("sample2 cookie : {}", sample2);
	}
}















