package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model.User;

public class UserEntityManager {
	User resultUser = null;

	private boolean update(String query) throws SQLException {
		Statement stmt = (Statement) SqlConnection.getConnection().createStatement();
		try {
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addUser(User user) throws SQLException {
		String query = null;
		Statement stmt = (Statement) SqlConnection.getConnection().createStatement();
		ResultSet userSet = stmt
				.executeQuery("SELECT * FROM `PAINTWITHJDBC`.USER WHERE USERNAME='" + user.getUsername() + "';");
		if (!userSet.next()) {
			query = "INSERT INTO `PAINTWITHJDBC`.USER (`NAME`, `FAMILY`, `USERNAME`, `PASSWORD`) VALUES ('"
					+ user.getName() + "', '" + user.getFamily() + "', '" + user.getUsername() + "','"
					+ user.getPassword() + "');";
			if (update(query))
				return true;
		}
		return false;
	}

	public User userExist(User user) throws SQLException {
		Statement stmt = (Statement) SqlConnection.getConnection().createStatement();
		ResultSet rsUser = stmt.executeQuery("SELECT * FROM `PAINTWITHJDBC`.`USER` WHERE USERNAME='"
				+ user.getUsername() + "' and PASSWORD='" + user.getPassword() + "';");
		if (rsUser.next()) {
			String name = rsUser.getString(1);
			String family = rsUser.getString(2);
			String username = rsUser.getString(3);
			String password = rsUser.getString(4);
			resultUser = new User(name, family, username, password);
		}
		return resultUser;
	}
}