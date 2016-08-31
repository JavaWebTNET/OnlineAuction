package pdv.online.auction.common;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImageHandler {
public static final int DEFAULT_BUFFER_SIZE = 10240;
	
	@Value("${"+SystemConstant.IMAGE_DOCROOT+"}")
	private String rootbaseImg;
	
	public String getPathImg(String urlImage){
		return rootbaseImg + File.separator + urlImage;
	}
	
	public String getBaseUrl(){
		return rootbaseImg;
	}
	
	public File getFileImage(String urlImage) throws IOException{
		String pathImage = getPathImg(urlImage);
		File file = new File(pathImage);
		if(!file.exists()){
			return null;
		}
		return file;
	}
	
	public String genFilename(String urlImage) throws IOException{
		File file;
		String nextImage;
		Random random = new Random();
		do{
			nextImage=String.format("%d_%s", random.nextInt(1000),urlImage);
			file=getFileImage(nextImage);
		}while(file!=null);
		return nextImage;
	}
}
