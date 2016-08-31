package pdv.online.auction.service.impl;

import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pdv.online.auction.model.Account;
import pdv.online.auction.model.AuctionLog;
import pdv.online.auction.model.Category;
import pdv.online.auction.model.Item;
import pdv.online.auction.repository.AuctLogRepository;
import pdv.online.auction.repository.CatRepository;
import pdv.online.auction.repository.ItemRepository;
import pdv.online.auction.service.ItemSrv;
import pdv.online.auction.service.PageSrv;

@Service(ItemSrv.NAME1)
@Transactional(propagation=Propagation.SUPPORTS)
public class ItemSrvImpl implements ItemSrv{
	
	@Autowired
	PageSrv pageSrv;
	
	@Autowired
	ItemRepository itemRepos;
	
	@Autowired
	CatRepository catRepos;
	
	@Autowired
	AuctLogRepository auctLogRepos;

	@Override
	public boolean addItem(Item item) {
		if(itemRepos.findOne(item.getId())!=null)
			return false;
		item.setCurBid(item.getMinBid());
		itemRepos.save(item);
		return true;
	}

	@Override
	public List<Item> getItemList(int page) {
		
		return null;
	}
	
	@Override
	@Transactional
	public Page<Item> getItemPage(String s, Integer cate, Pageable pageable){
		
		pageable=pageSrv.setPageDefault(pageable, new Sort(Direction.DESC,"endDate"));
		if(s==null && cate==null){
			return itemRepos.findAll(pageable);
		}
		if(cate==null){
			return itemRepos.findByNameContaining(s, pageable);
		}
		if(s==null){
			return getItemPage(cate, pageable);
		}
		return getItemPageFinal(s, cate, pageable);
	}

	private List<Category> getCateList(Integer cate){
		Category nCate= catRepos.getOne(cate);
		List<Category> cateList= nCate.getSubCate();
		cateList.add(nCate);
		return cateList;
	}
	
	private Page<Item> getItemPage(Integer cate, Pageable pageable){
		if(cate>0){
			
			return itemRepos.findByCategoryIn(getCateList(cate), pageable);
		}
		else {
			return itemRepos.findByCategoryId(cate==0?null:-cate, pageable);
		}
		
	}
	
	private Page<Item> getItemPageFinal(String s,Integer cate, Pageable pageable){
		if(cate>0){
			
			return itemRepos.findByCategoryInAndNameContaining(getCateList(cate),s, pageable);
		}
		else {
			return itemRepos.findByCategoryIdAndNameContaining(cate==0?null:-cate,s, pageable);
		}
		
		
	}
	
	@Override
	public Item getItem(int id) {
		return itemRepos.findOne(id);
	}

	@Override
	public Item udtItem(Item item) {
		return itemRepos.save(item);		
	}

	@Override
	public AuctionLog getLog(int itemId, String bidAcc, int bidValue) {
		AuctionLog auctLog = new AuctionLog();
		Item item = itemRepos.findOne(itemId);
		if(auctLog.getBidDate().after(item.getEndDate()))
			return null;
		item.setCurBid(bidValue);
		itemRepos.save(item);
		auctLog.setItem(item);
		auctLog.setBidValue(bidValue);
		Account acc = new Account();
		acc.setUsername(bidAcc);
		auctLog.setBidAcc(acc);
		auctLogRepos.save(auctLog);
		return auctLog;
	}

	@Override
	public Page<Item> getCateItem(Integer id, Pageable pageable) {
		if(id==0)
			id=null;
		return itemRepos.findByCategoryId(id, pageable);
	}

	@Override
	@Transactional
	public Item changeCat(int itemId, int catId) {
		Item item= itemRepos.findOne(itemId);
		if(catId==0){
			item.setCategory(null);
		}
		else{
			Category cate=new Category();
			cate.setId(catId);
			item.setCategory(cate);
		}
		return item;
	}

}
