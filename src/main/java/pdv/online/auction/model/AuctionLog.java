package pdv.online.auction.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="auctionlog")
public class AuctionLog {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@ManyToOne
	private Account bidAcc;
	
	@NotNull
	@ManyToOne
	private Item item;
	
	private Date bidDate= new Date();
	
	private int bidValue;
	
	public AuctionLog(){
		super();
	}

	public AuctionLog(int id, Account bidAcc, Item item, Date bidDate,
			int bidValue) {
		super();
		this.id = id;
		this.bidAcc = bidAcc;
		this.item = item;
		this.bidDate = bidDate;
		this.bidValue = bidValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getBidAcc() {
		return bidAcc;
	}

	public void setBidAcc(Account bidAcc) {
		this.bidAcc = bidAcc;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getBidDate() {
		return new VnDate(bidDate);
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public int getBidValue() {
		return bidValue;
	}

	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
	}
	
}
