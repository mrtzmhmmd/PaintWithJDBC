package testmodels;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;

import org.junit.BeforeClass;
import org.junit.Test;

import model.RoundRectangle;

public class TestRoundRectangle {

	private static RoundRectangle roundRectangle;

	@BeforeClass
	public static void startup() {
		roundRectangle = new RoundRectangle();
	}

	@Test
	public void testCircleContains() {
		roundRectangle.setColor(Color.GREEN);
		roundRectangle.setStart(new Point(100, 102));
		roundRectangle.setEnd(new Point(200, 202));
		assertTrue(roundRectangle.contains(new Point(100, 150)));
	}
}