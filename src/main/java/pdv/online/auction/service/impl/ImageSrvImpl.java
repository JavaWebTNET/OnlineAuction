package pdv.online.auction.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pdv.online.auction.common.ImageHandler;
import pdv.online.auction.service.ImageSrv;

@Service
public class ImageSrvImpl implements ImageSrv{
	
	
	
	@Autowired
	private ImageHandler imgHdlr;

	@Override
	public ResponseEntity<byte[]> getResponseImage(String urlImage)
			throws IOException {
		if(StringUtils.isBlank(urlImage)){
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		File file = imgHdlr.getFileImage(urlImage);
		if(file == null){
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
		byte[] data = IOUtils.toByteArray(bf);
		
		final HttpHeaders headers = extractHeader(file);
	    return new ResponseEntity<byte[]>(data,headers, HttpStatus.OK);
	}
	
	private HttpHeaders extractHeader(File file) {
		final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);
	    headers.setContentLength(file.length());
	    headers.set("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		return headers;
	}

	@Override
	public String saveImage(MultipartFile file) throws IOException{
		byte[] bytes = file.getBytes();
		String fname = imgHdlr.genFilename(file.getOriginalFilename());
		String name = imgHdlr.getPathImg(fname);
		BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(new File(name)));
		bf.write(bytes);
		bf.close();
		return fname;
	}
}
