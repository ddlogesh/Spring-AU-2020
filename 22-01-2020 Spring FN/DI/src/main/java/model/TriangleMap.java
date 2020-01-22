package model;

import java.util.Map;

public class TriangleMap {
    private Map<Integer, Point> map;

    public TriangleMap(Map<Integer, Point> map) {
        this.map = map;
    }

    public Map<Integer, Point> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Point> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        String res = "";
        for (Map.Entry<Integer, Point> entry : map.entrySet())
        	res += "Key : " + entry.getKey() + " Value : " + entry.getValue() + "\n";
        return res;
    }
}
