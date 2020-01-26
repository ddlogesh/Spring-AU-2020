package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parent implements Component{

    private String name;
    private List<Component> componentList;

    public Parent(String name){
        this.name = name;
        componentList = new ArrayList<>();
    }

    public void addComponent(Component component){
        componentList.add(component);
    }

    public String getName() {
        return name;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    @Override
    public int getFan() {
        return componentList.stream().map(Component::getFan).collect(Collectors.toList()).stream().reduce(0, Integer::sum);
    }

    @Override
    public int getTubeLight() {
        return componentList.stream().map(Component::getTubeLight).collect(Collectors.toList()).stream().reduce(0, Integer::sum);
    }

    @Override
    public int getWindows() {
        return componentList.stream().map(Component::getWindows).collect(Collectors.toList()).stream().reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        if(name.startsWith("Building"))
            return "name=" + name + ",\n" + componentList;
        else if(name.startsWith("Floor"))
            return "\n\tname=" + name + ",\n\t" + componentList;
        else
            return "\n\t\tname=" + name + ",\n\t\t" + componentList;
    }
}
