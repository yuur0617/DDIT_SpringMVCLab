package kr.or.ddit.mission;

import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * url : /mission/now.nhn
 * method : GET
 * model : 현재 시각, model명: now
 * repsonse content type : HTML / JSON
 *
 */
@Controller
@RequestMapping("/mission/now.nhn")
public class ModelAndViewMissionController {
	@Inject
	private NowGeneratorService service;
	
	@GetMapping
	public String html(Model model) {
		LocalDateTime now = service.receiveNow();
		model.addAttribute("now", now);
		return "mission/resultView";
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String json(Model model) {
		LocalDateTime now = service.receiveNow();
		model.addAttribute("now", now);
		return "jsonView";
	}
}























