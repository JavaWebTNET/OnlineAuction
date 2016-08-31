package pdv.online.auction.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pdv.online.auction.model.Category;
import pdv.online.auction.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{
	
	public List<Item> findByBidStatusAndEndDateBefore(Item.BidStatus status, Date date);
	public Page<Item> findByNameContaining(String s, Pageable pageable);
	public Page<Item> findByCategoryId(Integer id, Pageable pageable);
	public Page<Item> findByCategory(Category cate, Pageable pageable);
	public Page<Item> findByCategoryIn(Collection<Category> cateList, Pageable pageable);
	public Page<Item> findByCategoryIdAndNameContaining(Integer id, String s, Pageable pageable);
	public Page<Item> findByCategoryInAndNameContaining(
			Collection<Category> cateList,String s, Pageable pageable);
}
