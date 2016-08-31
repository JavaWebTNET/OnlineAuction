package pdv.online.auction.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageSrv {
	public static String NAME1 = "imageSrv1";
	ResponseEntity<byte[]> getResponseImage(String urlImage) throws IOException;
	public String saveImage(MultipartFile file) throws IOException;
}
