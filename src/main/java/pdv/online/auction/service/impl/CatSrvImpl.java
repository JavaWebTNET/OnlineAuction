package pdv.online.auction.service.impl;

import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pdv.online.auction.model.Category;
import pdv.online.auction.repository.CatRepository;
import pdv.online.auction.service.CatSrv;

@Service(CatSrv.NAME1)
@Transactional(propagation=Propagation.SUPPORTS)
public class CatSrvImpl implements CatSrv{

	@Autowired
	CatRepository catRepos;
	
	@Override
	public boolean addCat(Category cat) {
		if(catRepos.findOne(cat.getId())!=null)
			return false;
		catRepos.save(cat);
		return true;
	}

	@Override
	public List<Category> getMainCate() {
		return catRepos.findBySuperCateOrderByNameAsc(null);
	}

	@Override
	public Category getCat(int id) {
		if(id==0)
			return new Category();
		return catRepos.findOne(id);
	}

	@Override
	public List<Category> getCateList(int supId) {
		Category cate=new Category();
		cate.setId(supId);
		return catRepos.findBySuperCateOrderByNameAsc(cate);
	}

}
