package pdv.online.auction.service;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;

import pdv.online.auction.model.Account;

public interface AccSrv {
	public static String NAME1 = "accSrv1";
	//public static final String SORT1 = "endDate";
	//public static final Direction SDIR = Sort.Direction.DESC;
	//public List<Account> getAccList(int page);
	public Page<Account> getAccPage(Pageable page);
	public Account getAcc(String username);
	public boolean udtAcc(Account acc);
	//public long pageCount();
	public boolean addAcc(Account acc);
	public void delAcc(String username);
	public void lockAcc(String username);
}
