package pdv.online.auction.service.impl;

import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Resource;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import pdv.online.auction.model.Account;
import pdv.online.auction.repository.AccRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	AccRepository accRepos;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Account acc=accRepos.findOne(username);
		if(acc==null)
			return null;
		List<GrantedAuthority> roleList=new ArrayList<GrantedAuthority>();
		roleList.add(new SimpleGrantedAuthority(acc.getAccRole().toString()));
		return new User(acc.getUsername(),acc.getPassword(),acc.isEnable(),true,true,true,roleList);
	}

}
