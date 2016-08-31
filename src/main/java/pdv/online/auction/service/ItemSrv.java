package pdv.online.auction.service;

import java.util.List;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pdv.online.auction.model.AuctionLog;
import pdv.online.auction.model.Item;


public interface ItemSrv {

	public static String NAME1 = "itemSrv1";
	public boolean addItem(Item item);
	public List<Item> getItemList(int page);
	public Page<Item> getItemPage(String s, Integer cat, Pageable pageable);
	public Page<Item> getCateItem(Integer id, Pageable pageable);
	public Item getItem(int id);
	public Item udtItem(Item item);
	public Item changeCat(int itemId, int catId);
	public AuctionLog getLog(int itemId, String bidAcc, int bidValue);
}
