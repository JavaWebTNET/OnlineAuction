package pdv.online.auction.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pdv.online.auction.model.Account;



public interface AccRepository extends JpaRepository<Account, String>{
	public List<Account> findByFname(String fname, Pageable pagable);
}