package pdv.online.auction.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="item")
public class Item {
	
	public enum BidStatus{A,I}
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min = 5, max = 30, message = "Category Name must be between 5 and 30 characters long.")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Category Name must be alphabetic with any spaces")
	private String name;
	
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Description must be alphabetic with any spaces")
	private String description;
		
	@ManyToOne
	private Category category;
	
	@Enumerated(EnumType.STRING)
	private BidStatus bidStatus=BidStatus.A;
	
	private int bidInc;
	
	private int minBid;
	
	private int curBid;
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Date startDate=new Date();
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Date endDate=Date.from(new Date().toInstant().plusSeconds(3*24*3600));
	
	private String image;
	
	@ManyToOne
	private Account sellAcc;
	
	@OneToMany(mappedBy="item", fetch = FetchType.EAGER)
	@OrderBy("bidDate DESC")
	private List<AuctionLog> auctLog;
	
	public Item(){
		super();
	}
	
	public Item(int id, String name, Category category,
			int minBid, Account sellAcc) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.minBid = minBid;
		this.sellAcc = sellAcc;
	}

	public Item(int id, String name, String description, Category category,
			BidStatus bidStatus, int bidInc, int minBid, Date startDate,
			Date endDate, Account sellAcc) {
		this(id,name,category,minBid,sellAcc);		
		this.description = description;		
		this.bidStatus = bidStatus;
		this.bidInc = bidInc;		
		this.startDate = startDate;
		this.endDate = endDate;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BidStatus getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(BidStatus bidStatus) {
		this.bidStatus = bidStatus;
	}

	public int getBidInc() {
		return bidInc;
	}

	public void setBidInc(int bidInc) {
		this.bidInc = bidInc;
	}

	public int getMinBid() {
		return minBid;
	}

	public void setMinBid(int minBid) {
		this.minBid = minBid;
	}
	
	public int getCurBid() {
		return curBid;
	}

	public void setCurBid(int curBid) {
		this.curBid = curBid;
	}

	public Date getStartDate() {
		return new VnDate(startDate);
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return new VnDate(endDate);
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Account getSellAcc() {
		return sellAcc;
	}

	public void setSellAcc(Account sellAcc) {
		this.sellAcc = sellAcc;
	}

	public List<AuctionLog> getAuctLog() {
		return auctLog;
	}

	public void setAuctLog(List<AuctionLog> auctLog) {
		this.auctLog = auctLog;
	}
		
}
