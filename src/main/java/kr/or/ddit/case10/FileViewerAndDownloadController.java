package kr.or.ddit.case10;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/case10")
public class FileViewerAndDownloadController {
	@Value("file:D:/01.medias/images/")
	private Resource imageFolder;
	
	@GetMapping(value="fileView/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public Resource fileService1(@PathVariable String fileName) throws IOException {
		Resource imageFile = imageFolder.createRelative(fileName);
		if(!imageFile.exists())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%s 파일을 찾을 수 없음.", fileName));
		return imageFile;
	}
	
	@GetMapping(value="file/{fileName}")
	public ResponseEntity<Resource> fileService2(@PathVariable String fileName) throws IOException {
		
		Resource imageFile = imageFolder.createRelative(fileName);
		if(!imageFile.exists())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%s 파일을 찾을 수 없음.", fileName));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentLength(imageFile.contentLength());
//		Content-Disposition: attachment; filename="filename.jpg"
		ContentDisposition disposition = ContentDisposition.attachment()
											.filename(fileName, Charset.forName("UTF-8"))
											.build();
		headers.setContentDisposition(disposition);
		return  ResponseEntity.ok()
						.headers(headers)
						.body(imageFile);
	}
}














