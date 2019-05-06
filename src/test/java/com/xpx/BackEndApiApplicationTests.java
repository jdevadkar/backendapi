package com.xpx;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackEndApiApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testTrue() {
		System.out.println("testTrue");
		Assert.assertFalse(false);
	}
	

}
