package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {

	protected Color color;
	protected Point start;
	protected Point end;
	protected User user;
	protected int type;

	public Shape() {

	}

	public Shape(Color color, Point start, Point end, User user) {
		setColor(color);
		setStart(start);
		setEnd(end);
		setUser(user);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getStart() {
		return start;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Point getEnd() {
		return end;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public abstract void draw(Graphics g);

	public abstract boolean contains(Point point);
}