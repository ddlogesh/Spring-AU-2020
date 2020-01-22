package model;

public class Point {
	private int x;
	private int y;
	private String pointName;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, String pointName) {
		this.x = x;
		this.pointName = pointName;
	}
	
	public Point(String pointName, int x, int y) {
		this.pointName = pointName;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "x: " + x + " y: " + y + " name: " + pointName;
	}
}
