package testmodels;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Circle;

public class TestCircle {

	private static Circle circle;

	@BeforeClass
	public static void startup() {
		circle = new Circle();
	}

	@Test
	public void testCircleContains() {
		circle.setColor(Color.GREEN);
		circle.setStart(new Point(100, 102));
		circle.setEnd(new Point(200, 202));
		Boolean boolean1 = circle.contains(new Point(100, 102));
		assertTrue(boolean1);
	}
}