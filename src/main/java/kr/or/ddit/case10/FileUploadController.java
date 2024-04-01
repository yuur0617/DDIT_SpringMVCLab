package kr.or.ddit.case10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.case10.vo.UploadFileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case10/upload2")
public class FileUploadController {
	@Value("file:d:/saveFiles/")
	private Resource saveFolder;
	
	@PostConstruct
	public void init() {
		log.info("saveFolder : {}", saveFolder);
	}
	
	@GetMapping
	public String formUI(@ModelAttribute("fileVO") UploadFileVO fileVO) {
		return "case10/uploadForm2";
	}
	
	
	public String postHandler1(HttpServletRequest req) throws IOException, ServletException {
		log.info("uploader : {}", req.getParameter("uploader"));
		log.info("count : {}", req.getParameter("count"));
		log.info("uploadFile : {}", req.getPart("uploadFile"));
		return "jsonView";
	}
	
	public String postHandler2(
		@RequestParam(required = false)	String uploader
		, @RequestParam(required = false, defaultValue = "1") int count
		, @RequestPart(required = true) MultipartFile[] uploadFile) throws IOException {
		
		log.info("uploader : {}", uploader);
		log.info("count : {}", count);
		log.info("uploadFile : {}", uploadFile);
		for(MultipartFile single : uploadFile) {
			if(single.isEmpty()) continue;
			String saveName = saveToResource(single, saveFolder);
			log.info("original file name : {}, save name : {}", single.getOriginalFilename(), saveName);
		}
		return "jsonView";
	}
	
	@PostMapping
	public String postHandler3(
		@Valid @ModelAttribute("fileVO") UploadFileVO commandObject 
		, BindingResult errors 	
	) throws IOException {
		if(errors.hasErrors()) {
			return "case10/uploadForm2";
		}else {
			log.info("command object : {}", commandObject);
			log.info("uploadFile : {}", commandObject.getUploadFile());
			for(MultipartFile single : commandObject.getUploadFile()) {
				if(single.isEmpty()) continue;
				String saveName = saveToResource(single, saveFolder);
				log.info("original file name : {}, save name : {}", single.getOriginalFilename(), saveName);
			}
			return "jsonView";
		}
	}
	
	
	private String saveToResource(MultipartFile single, Resource saveFolder) throws IOException {
		// 저장 절차
		String saveName = UUID.randomUUID().toString();
		Resource saveFileRes = saveFolder.createRelative(saveName);
		File saveFile = saveFileRes.getFile();
		try(
			InputStream is = single.getInputStream();	
//					FileOutputStream fos = new FileOutputStream(saveFile);
		){
//					IOUtils.copy(is, fos);
			FileUtils.copyInputStreamToFile(is, saveFile);
			return saveName;
		}
	}
}

















