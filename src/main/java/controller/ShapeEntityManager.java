package controller;

import java.awt.Color;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import model.Circle;
import model.Line;
import model.Rectangle;
import model.RoundRectangle;
import model.Shape;
import model.User;
import view.Paint;

public class ShapeEntityManager {

	private User user;

	public ShapeEntityManager() {

	}

	public ShapeEntityManager(User user) {
		this.user = user;
	}

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

	public void saveShape(Shape shape) throws SQLException {
		String query = null;
		query = "INSERT INTO `SHAPE` (`x1`, `y1`, `x2`, `y2`, `color`, `username`, `type`) VALUES ('"
				+ shape.getStart().getX() + "', '" + shape.getStart().y + "', '" + shape.getEnd().x + "', '"
				+ shape.getEnd().y + "', '" + Paint.colorToString(shape.getColor()) + "', '"
				+ shape.getUser().getUsername() + "','" + shape.getType() + "');";
		update(query);
	}

	public ArrayList<Shape> loadShape() throws SQLException {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		String query = "SELECT * FROM `PAINTWITHJDBC`.`SHAPE` WHERE `USERNAME` = '" + user.getUsername() + "';";
		Statement stmt = (Statement) SqlConnection.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs != null) {
			while (rs.next()) {
				int x1 = rs.getInt("x1");
				int y1 = rs.getInt("y1");
				int x2 = rs.getInt("x2");
				int y2 = rs.getInt("y2");
				int type = rs.getInt("type");
				Color color = Paint.strToColor(rs.getString("color"));
				if (type == 1) {
					shapes.add(new Rectangle(color, new Point(x1, y1), new Point(x2, y2), user));
				} else if (type == 2) {
					shapes.add(new Circle(color, new Point(x1, y1), new Point(x2, y2), user));
				} else if (type == 3) {
					shapes.add(new Line(color, new Point(x1, y1), new Point(x2, y2), user));
				} else if (type == 4) {
					shapes.add(new RoundRectangle(color, new Point(x1, y1), new Point(x2, y2), user));
				}
			}
		}
		return shapes;
	}

	public void deleteShape(Shape shape) throws SQLException {
		String query = null;
		query = "DELETE FROM `PAINTWITHJDBC`.`SHAPE` WHERE COLOR= '" + Paint.colorToString(shape.getColor())
				+ "' AND X1=" + shape.getStart().x + " AND Y1=" + shape.getStart().y + " AND X2=" + shape.getEnd().x
				+ " AND y2=" + shape.getEnd().y + " AND USERNAME='" + shape.getUser().getUsername() + "' AND TYPE="
				+ shape.getType() + ";";
		update(query);
	}

	public void updateShape(Shape shape, Color color) throws SQLException {
		String query = null;
		query = "UPDATE `PAINTWITHJDBC`.`SHAPE` SET COLOR= '" + Paint.colorToString(color) + "' WHERE X1="
				+ shape.getStart().x + " AND Y1=" + shape.getStart().y + " AND X2=" + shape.getEnd().x + " AND y2="
				+ shape.getEnd().y + " AND USERNAME='" + shape.getUser().getUsername() + "' AND TYPE=" + shape.getType()
				+ ";";
		update(query);
	}
}