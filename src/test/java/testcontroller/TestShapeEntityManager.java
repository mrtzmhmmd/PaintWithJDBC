package testcontroller;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.ShapeEntityManager;
import model.Circle;
import model.Shape;
import model.User;

public class TestShapeEntityManager {

	private static ShapeEntityManager shapeEntityManager;
	static User user = new User("reza", "reza", "reza", "123");

	@BeforeClass
	public static void startup() {
		shapeEntityManager = new ShapeEntityManager(user);
	}

	@Test
	public void testLoadShape() throws SQLException {
		Boolean boolean1 = false;
		Shape shape = new Circle(Color.GREEN, new Point(467, 76), new Point(451, 91), user);
		ArrayList<Shape> shapes = shapeEntityManager.loadShape();
		for(Shape s: shapes) {
			if(s.equals(shape))
				boolean1 = true;
		}
		assertTrue(boolean1);
	}
}