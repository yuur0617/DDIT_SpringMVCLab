package kr.or.ddit.case5;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case5")
public class FlowControlCaseController {
	@GetMapping("start1")
	public String handler1_start(Model model) {
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("now", now);
		return "forward:/case5/dest1";
	}

	@GetMapping("dest1")
	public String handler1_dest(@RequestAttribute(name = "now", required = false) LocalDateTime now) {
		log.info("forward 로 전달된 model data : {}", now);
		return "case5/finalView1";
	}

	@GetMapping("start2")
	public String handler2_start(RedirectAttributes redirectAttributes) {
		LocalDateTime now = LocalDateTime.now();
		redirectAttributes.addFlashAttribute("now", now);
		return "redirect:/case5/dest2";
	}

	@GetMapping("dest2")
	public String handler2_dest(Model model) {
		log.info("redirect로 전달된 model data : {}", model.getAttribute("now"));
		return "case5/finalView2";
	}
}
