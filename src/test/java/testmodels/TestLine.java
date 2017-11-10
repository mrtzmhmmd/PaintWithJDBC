package testmodels;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Line;

public class TestLine {
	private static Line line;

	@BeforeClass
	public static void startup() {
		line = new Line();
	}
	
	@Test
	public void testLineContains() {
		line.setColor(Color.GREEN);
		line.setStart(new Point(100, 102));
		line.setEnd(new Point(200, 202));
		assertTrue(line.contains(new Point(150, 152)));
	}

}
