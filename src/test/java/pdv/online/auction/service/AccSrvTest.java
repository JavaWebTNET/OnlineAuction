package pdv.online.auction.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class AccSrvTest {
	
	@Autowired
	private AccSrv accSrv;
	
	@Test
	public void test() {
		assertEquals("",null,accSrv);
		System.out.println("test");
	}
}
