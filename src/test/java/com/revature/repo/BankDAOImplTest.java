package com.revature.repo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BankDAOImplTest {
	
	BankDAO b;
	
	@Before
	public void setupBankDAOImpl() {
		b = new BankDAOImpl();
	}
	
	@Test
	public void testAssertions() {
		
		assertEquals(false, b.transferMoney("", "tsunami" , 0, "james"));
		assertEquals(false, b.transferMoney("waterfall", "", 0, "theo"));
		assertEquals(false, b.transferMoney("summer", "autumn", 0, "ashley" ));
		assertEquals(false, b.transferMoney("summer", "autumn", 5000, "ashley" ));
		assertEquals(false, b.transferMoney("summer", "autumn", -1, "ashley" ));
		assertEquals(false, b.takeMoney("summer", 0));
		assertEquals(false, b.addDeposit("summer", 0));
		assertEquals(false, b.takeMoney("autumn", 900000000));
		assertEquals(false, b.viewBalance("summer", "blizzard"));
		assertEquals(false, b.addAccount("summer", 0, "autumn", "fdhg", "ashley" ));
		assertEquals("", b.loginUser("kailey", "tooshort2"));
		
	}

}
