package testcontroller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import controller.MD5;

public class TestMD5 {

	@Test
	public void testMD5() throws NoSuchAlgorithmException {
		String md5 = "202cb962ac59075b964b07152d234b70";
		assertEquals(md5, MD5.getDigest("123"));
		assertNotEquals(md5, MD5.getDigest("1234"));
	}
}