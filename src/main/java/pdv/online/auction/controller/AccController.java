package pdv.online.auction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

//import pdv.online.auction.model.Account;
import pdv.online.auction.model.Item;
import pdv.online.auction.service.ImageSrv;
import pdv.online.auction.service.ItemSrv;
//import pdv.online.auction.service.AccSrv;

@Controller
@RequestMapping("/account")
public class AccController {
	
	@Autowired
	private ItemSrv itemSrv;
	
	@Autowired
	private ImageSrv imageSrv;
	
	@RequestMapping({"/","index"})
	public String getPageIndex(){
		return "account/index";
	}
	
	@RequestMapping(value="addItem", method=RequestMethod.GET)
	public String getAddItem(Item item){
		return "account/addItem";
	}
	@RequestMapping(value="addItem", method=RequestMethod.POST)
	public String addItem(@Valid Item item, BindingResult brs, @RequestParam("file") MultipartFile file){
		if(brs.hasErrors()){
			
			return null;
		}
		try{
			String image = imageSrv.saveImage(file);
			item.setImage(image);
			itemSrv.addItem(item);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return "redirect:addItem";
	}
}
