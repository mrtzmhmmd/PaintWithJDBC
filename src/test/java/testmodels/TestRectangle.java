package testmodels;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Rectangle;

public class TestRectangle {

	private static Rectangle rectangle;
	
	@BeforeClass
	public static void startup() {
		rectangle = new Rectangle();
	}

	@Test
	public void testCircleContains() {
		rectangle.setColor(Color.GREEN);
		rectangle.setStart(new Point(100, 102));
		rectangle.setEnd(new Point(200, 202));
		assertTrue(rectangle.contains(new Point(100, 200)));
		assertFalse(rectangle.contains(new Point(150, 200)));
	}
}