package kr.or.ddit.mission.ajax;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.mission.vo.PropertyVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/ajax/propView")
public class PropertyInsertAjaxController {
	@GetMapping
	public void formUI() {}
	
	@PostMapping
	public String processFormData(
			@Valid @ModelAttribute("property") PropertyVO property
			, BindingResult errors
			, RedirectAttributes redirectAttributes
	) {
		if(!errors.hasErrors()) {
			log.info("command object : {}", property);
//			message 속성 전달(프로퍼티 등록 성공)
			redirectAttributes.addFlashAttribute("message", "프로퍼티 등록 성공");
			return "redirect:/";
		}else {
			return "jsonView";
		}
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String processJsonPayload(
			@Valid @RequestBody PropertyVO property
			, BindingResult errors
			, RedirectAttributes redirectAttributes
			) {
		if(!errors.hasErrors()) {
			log.info("command object : {}", property);
//			message 속성 전달(프로퍼티 등록 성공)
			redirectAttributes.addFlashAttribute("message", "프로퍼티 등록 성공");
			return "redirect:/";
		}else {
			return "jsonView";
		}
	}
}











