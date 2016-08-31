package pdv.online.auction.service;

import java.util.List;

import pdv.online.auction.model.Category;

public interface CatSrv {
	public static String NAME1 = "catSrv1";
	public boolean addCat(Category cat);
	public List<Category> getMainCate();
	public Category getCat(int id);
	public List<Category> getCateList(int supId);
}
