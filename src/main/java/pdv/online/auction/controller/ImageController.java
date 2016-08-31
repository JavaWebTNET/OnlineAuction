package pdv.online.auction.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pdv.online.auction.service.ImageSrv;

@Controller
public class ImageController {
	@Autowired
	private ImageSrv imageSrv;
	
	@RequestMapping("/image/{pathImage:.*}")
	public ResponseEntity<byte[]> testphoto(@PathVariable String pathImage,
			HttpServletResponse response) throws IOException {
		
		if(StringUtils.isBlank(pathImage)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		ResponseEntity<byte[]> responseEntity = imageSrv.getResponseImage(pathImage);
		if(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		return responseEntity;
	}
}
