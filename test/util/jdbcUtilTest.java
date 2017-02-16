package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class jdbcUtilTest {

	@Test
	public void testTest() {
		JdbcTest test=new JdbcTest();
		assertTrue(test.getName().equals("ȫ�浿"));
	}

}
