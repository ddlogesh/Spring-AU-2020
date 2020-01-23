package model;

import java.util.Map;

public class EmployeeMap {
    private Map<Integer, Employee> map;

    public EmployeeMap(Map<Integer, Employee> map) {
        this.map = map;
    }

    public Map<Integer, Employee> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Employee> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        String res = "";
        for (Map.Entry<Integer, Employee> entry : map.entrySet())
        	res += "Key : " + entry.getKey() + " Value : " + entry.getValue();
        return res;
    }
}
