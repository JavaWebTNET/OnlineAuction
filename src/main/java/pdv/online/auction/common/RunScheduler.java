package pdv.online.auction.common;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pdv.online.auction.model.Account;
import pdv.online.auction.model.AuctionLog;
import pdv.online.auction.model.Item;
import pdv.online.auction.repository.AuctLogRepository;
import pdv.online.auction.repository.ItemRepository;

@Component
public class RunScheduler {
	
	@Autowired
	MailHandler mailHandler;
	
	@Autowired
	ItemRepository itemRepos;
	
	@Autowired
	AuctLogRepository auctLogRepos;
	
	@Scheduled(cron="0/5 * * * * *")
	public void run() {	
		System.out.println(new Date());
		auctionEnd();		
	}
		
	private void auctionEnd(){
		List<Item> items = itemRepos.findByBidStatusAndEndDateBefore(Item.BidStatus.A, new Date());
		for(Item item: items){
			item.setBidStatus(Item.BidStatus.I);
			itemRepos.save(item);
			Account bidAcc=getBidAcc(item);
			System.out.println(new Date());
			System.out.println(item.getName() + " -done");
			System.out.println("seller: " + item.getSellAcc().getEmail());
			if(bidAcc==null){
				System.out.println("unsuccess");
			}
			else{
				System.out.println("bid winner: " + bidAcc.getEmail());
			}
			
		}
	}
	
	private Account getBidAcc(Item item){
		List<AuctionLog> auctLogs= auctLogRepos.findByItemAndBidValue(item, item.getCurBid());
		if(auctLogs.isEmpty())
			return null;
		return auctLogs.get(0).getBidAcc();
	}
}
