package pdv.online.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pdv.online.auction.model.AuctionLog;
import pdv.online.auction.model.Item;

public interface AuctLogRepository extends JpaRepository<AuctionLog,Integer>{
	
	public List<AuctionLog> findByItemAndBidValue(Item item, int bid);

}
