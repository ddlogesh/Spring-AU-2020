package model;

import java.util.List;

public class TriangleList {
	private List<Point> list;

	public TriangleList(List<Point> list) {
		this.list = list;
	}

	public List<Point> getList() {
		return list;
	}

	public void setList(List<Point> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		String res = "";
		for (Point point : list)
			res += point + "\n";
		return res;
	}
}