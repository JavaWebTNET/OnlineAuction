package pdv.online.auction.service.impl;

//import java.sql.Date;
//import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pdv.online.auction.model.Account;
import pdv.online.auction.repository.AccRepository;
//import pdv.online.auction.model.VnDate;
import pdv.online.auction.service.AccSrv;
import pdv.online.auction.service.PageSrv;


@Service(AccSrv.NAME1)
@Transactional(propagation=Propagation.SUPPORTS)
public class AccSrvImpl implements AccSrv{
	
	@Autowired
	AccRepository accRepos;
	
	@Autowired
	PageSrv pageSrv;
		
	//@Override
	public List<Account> getAccList(int page) {				
		return null;
	}

	@Override
	@Transactional
	public boolean addAcc(Account acc) {		
		if(accRepos.findOne(acc.getUsername())!=null)
			return false;
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		acc.setPassword(encoder.encodePassword(acc.getPassword(), null));
		accRepos.save(acc);
		return true;
	}

	//@Override
	public long pageCount() {
		return 0;
	}

	@Override
	public Account getAcc(String username) {
		return accRepos.findOne(username);
	}

	@Override
	@Transactional
	public boolean udtAcc(Account acc) {
		 accRepos.save(acc);
		 acc.setPassword("");
		 return true;
	}

	@Override
	@Transactional
	public void delAcc(String username) {
		Account acc=accRepos.findOne(username);
		accRepos.delete(acc);
	}

	@Override
	@Transactional
	public void lockAcc(String username) {
		Account acc=accRepos.findOne(username);
		acc.setEnable(!acc.isEnable());
		//accRepos.save(acc);
	}

	@Override
	public Page<Account> getAccPage(Pageable page) {
		page=pageSrv.setPageDefault(page, new Sort(Direction.ASC,"fname","lname"));
		return accRepos.findAll(page);
	}
}
