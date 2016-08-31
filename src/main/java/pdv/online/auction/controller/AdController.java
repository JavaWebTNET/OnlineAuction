package pdv.online.auction.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pdv.online.auction.model.Account;
import pdv.online.auction.model.Category;
import pdv.online.auction.model.Item;
import pdv.online.auction.service.AccSrv;
import pdv.online.auction.service.CatSrv;
import pdv.online.auction.service.ItemSrv;

@Controller 
@RequestMapping("/admin")
public class AdController {
	
	private List<Category> mainCate;
	
	@Autowired
	private AccSrv accSrv;
	
	@Autowired
	private CatSrv catSrv;
	
	@Autowired
	private ItemSrv itemSrv;
	
	
	
	@RequestMapping(value={"/","index"}, method=RequestMethod.GET)	
	public String getPageIndex(ModelMap model,
			@PageableDefault(value=2)
			Pageable pageable) {
		Page<Account> accPage=accSrv.getAccPage(pageable);
		model.put("accPage", accPage);
		mainCate=catSrv.getMainCate();
		model.put("mainCate", mainCate);
		return "admin/index";
	}
	
	@RequestMapping(value="addCat", method=RequestMethod.GET)
	public String getPageAddCat(Category category, ModelMap model, 
			@RequestParam(value="super", required= false) Integer supId){
		if(supId!=null){
			model.put("supId", supId);
		}
		mainCate=catSrv.getMainCate();
		model.put("mainCate", mainCate);
		return "admin/addCat";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String getAddAcc(){
		return "redirect:/admin/addAcc";
	}
	
	
	
	@RequestMapping(value="addCat", method=RequestMethod.POST)
	public String addCat(@Valid Category category, BindingResult brs){
		if(brs.hasErrors()) return null;
		
		if(catSrv.addCat(category)){
			return addSuccess(category);
		}
		
		brs.addError(new FieldError("category","id","primary key duplicated"));
		return null;
		
	}

	private String addSuccess(Category category) {
		if(category.getSuperCate()!=null){
			return "redirect:/admin/cat?id=" +category.getSuperCate().getId();
		}
		return "redirect:/admin/addCat";
	}
	
	@RequestMapping(value="editAcc", method=RequestMethod.GET)
	public String getEdit(@RequestParam(required= false) String username, Account account, ModelMap m){
		if(username==null)
			return "redirect:admin";
		account=accSrv.getAcc(username);
		m.put("acc", account);
		if(account==null)
			return "redirect:admin";
	
		return "admin/editAcc";
	}
	
	@RequestMapping(value="editAcc", method=RequestMethod.POST)
	public String editAcc(@Valid Account account, BindingResult brs){
		if(brs.hasErrors()) 
			return null;
		accSrv.udtAcc(account);
		return "redirect:/admin";
	}
	@RequestMapping(value="delAcc", method=RequestMethod.POST)
	public String delAcc(@RequestParam String username){
		accSrv.delAcc(username);
		return "redirect:/admin";
	}
	@RequestMapping(value="lockAcc", method=RequestMethod.POST)
	public String lockAcc(@RequestParam("username") String username, @RequestParam("page") int page){
		accSrv.lockAcc(username);
		return "redirect:/admin/?page=" +page;
	}
	@RequestMapping(value="cat", method=RequestMethod.GET)
	public String getCatePage(@RequestParam(value="id", required= false) Integer id, ModelMap model, Pageable pageable){
		if(id!=null){
			Category cat=catSrv.getCat(id);
			model.addAttribute("cate", cat);
			Page<Item> catItems=itemSrv.getCateItem(id, pageable);
			model.addAttribute("catItems", catItems);
			/*List<Category> cateList= catSrv.getCateList(id);
			model.addAttribute("cateList", cateList);
			model.addAttribute("supCat", catSrv.getCat(id));*/
		}
		mainCate=catSrv.getMainCate();
		model.put("mainCate", mainCate);
		return "admin/cat";
	}
	@RequestMapping(value="changeCat", method=RequestMethod.POST)
	public String changeCat(@RequestParam("itemId") int itemId, @RequestParam("catId") int catId){
		itemSrv.changeCat(itemId, catId);
		return "redirect:/admin/cat?id=" +catId;
	}
}
