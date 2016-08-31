package pdv.online.auction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pdv.online.auction.common.MailHandler;
import pdv.online.auction.model.Account;

import pdv.online.auction.model.Category;
import pdv.online.auction.model.Item;
import pdv.online.auction.service.AccSrv;
import pdv.online.auction.service.CatSrv;
import pdv.online.auction.service.ItemSrv;

@Controller
public class IndexController {
	
	private List<Category> mainCate;
	private Page<Item> itemPage;
	private String msg;
	
	@Autowired
	MailHandler mailHandler;
	
	@Autowired
	private AccSrv accSrv;
	
	@Autowired
	private CatSrv catSrv;
	
	@Autowired
	private ItemSrv itemSrv;
	
	@RequestMapping(value="sendmail", method=RequestMethod.GET)
	public String sendMail(@RequestParam(value="msg", required=false) String msg){
		if(msg==null)
			msg="test";
		String add = "khdng0424@gmail.com";
		mailHandler.sendMail(add, add, "non-subject", msg);
		return "redirect:/";
	}
	
	@RequestMapping(value={"/","index"}, method=RequestMethod.GET)
	public String getIndexPage(ModelMap model,
			@RequestParam(value="s", required=false) String s,
			@RequestParam(value="cat", required=false) Integer cat,
			@PageableDefault(value=3)
			Pageable pageable){
		mainCate=catSrv.getMainCate();
		itemPage=itemSrv.getItemPage(s,cat,pageable);
		model.put("mainCate", mainCate);
		model.put("itemPage", itemPage);
		model.put("s", s);
		model.put("cat", cat);
		model.put("msg", msg);
		msg=null;
		return "index";
	}
	
	@RequestMapping("login")
	public String getLogin(){
		return "login";
	}
	@RequestMapping("register")
	public String getRegister(Account account){
		return "register";
	}
	@RequestMapping("erpage")
	public String getErpage(){
		return "admin/erpage";
	}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(@Valid Account account, BindingResult brs){
		if(brs.hasErrors())
			return null;
		
		if(accSrv.addAcc(account))
			return "redirect:login?reg=1";

		brs.addError(new FieldError("account","username","primary key duplicated"));
		return null;
		
		
	}
	@RequestMapping(value="bid", method=RequestMethod.POST)
	public String applyBid(@RequestParam("bidAcc") String bidAcc, 
			@RequestParam("itemId") Integer itemId,
			@RequestParam("bidValue") Integer bidValue){
		if(itemSrv.getLog(itemId, bidAcc, bidValue)==null){
			msg="timeout";
		}
		else{
			msg="done";
		}
			
		return "redirect:/";
	}
}
