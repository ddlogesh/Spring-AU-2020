package model;

public class Leaf implements Component {
    private String name;
    private int tubeLight;
    private int fan;
    private int window;

    public Leaf(String name, int tubeLight, int fan, int window) {
        this.name = name;
        this.tubeLight = tubeLight;
        this.fan = fan;
        this.window = window;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getFan() {
        return fan;
    }

    @Override
    public int getTubeLight() {
        return tubeLight;
    }

    @Override
    public int getWindows() {
        return window;
    }

    @Override
    public String toString() {
        return "\n\t\t\tname=" + name + ", tubeLight=" + tubeLight + ", fan=" + fan + ", window=" + window;
    }
}
