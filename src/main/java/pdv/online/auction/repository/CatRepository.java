package pdv.online.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pdv.online.auction.model.Category;

public interface CatRepository extends JpaRepository<Category, Integer>{
	public List<Category> findBySuperCateOrderByNameAsc(Category superCate);
	
}
