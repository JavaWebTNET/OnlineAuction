package pdv.online.auction.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="account")
public class Account{	

	public enum AccountRole{ROLE_ADMIN,ROLE_USER}
	
	@Id
	@Size(min = 6, max = 15, message = "Username must be between 6 and 15 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	private String username;	
	
	@Size(min = 3, max = 15, message = "Firstname must be between 3 and 15 characters long.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Firstname must be alphabetic with no spaces")
	private String fname;
		
	@Size(min = 2, max = 15, message = "Lastname must be between 2 and 15 characters long.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Lastname must be alphabetic with no spaces")
	private String lname;

	@NotNull	
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be alphanumeric with no spaces")
	private String password;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private AccountRole accRole=AccountRole.ROLE_USER;
	
	private boolean enable=true;
	
	public Account(){
		super();
	}

	public Account(String fname, String lname, String username,String password, String email){
		this(username,password,email);
		this.fname=fname;
		this.lname=lname;
	}
	
	public Account(String username,String password, String email) {
		
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Account(Account m){
		this(m.getUsername(),m.getPassword(),m.getEmail());
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String toString(){
		return fname+ lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountRole getAccRole() {
		return accRole;
	}

	public void setAccRole(AccountRole accRole) {
		this.accRole = accRole;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
