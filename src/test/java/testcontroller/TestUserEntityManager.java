package testcontroller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.MD5;
import controller.UserEntityManager;
import model.User;

public class TestUserEntityManager {
	
	private static UserEntityManager userEntityManager;
	
	@BeforeClass
	public static void startup() {
		userEntityManager = new UserEntityManager();
	}
	
	@Test
	public void testAddUser() throws NoSuchAlgorithmException, SQLException {
		String name = "Amin";
		String family = "Amini";
		String username = "Amin";
		String password = MD5.getDigest("123");
		User user = new User(name, family, username, password);
		boolean bool = userEntityManager.addUser(user);
		assertTrue(bool);
	}
	
	@Test
	public void testUserExist() throws NoSuchAlgorithmException, SQLException {
		String username = "Hamed";
		String password = MD5.getDigest("123");
		User user = userEntityManager.userExist(new User(username, password));
		assertNotNull(user);
	}
}