package Main;

import model.Leaf;
import model.Parent;

public class Composite {
    public static void main(String[] args) {

        Parent building = new Parent("Building");

        Parent floor1 = new Parent("Floor1");
        Parent floor2 = new Parent("Floor2");

        /*********************************************************************************/
        // Floor-1 Flat-1

        Leaf room1 = new Leaf("Room1",2,1,2);
        Leaf room2 = new Leaf("Room2",3,2,2);
        Leaf room3 = new Leaf("Room3",1,1,3);

        Parent flat1 = new Parent("Flat1");
        flat1.addComponent(room1);
        flat1.addComponent(room2);
        flat1.addComponent(room3);

        /***********************************************************/
        // Floor-1 Flat-2

        room1 = new Leaf("Room1",2,1,3);
        room2 = new Leaf("Room2",1,3,2);

        Parent flat2 = new Parent("Flat2");
        flat2.addComponent(room1);
        flat2.addComponent(room2);

        /***********************************************************/
        // Floor-1 Flat-3

        room1 = new Leaf("Room1",2,1,3);

        Parent flat3 = new Parent("Flat3");
        flat3.addComponent(room1);

        floor1.addComponent(flat1);
        floor1.addComponent(flat2);
        floor1.addComponent(flat3);

        /*********************************************************************************/
        // Floor-2 Flat-1

        room1 = new Leaf("Room1",1,2,1);
        room2 = new Leaf("Room2",2,3,1);

        flat1 = new Parent("Flat1");
        flat1.addComponent(room1);
        flat1.addComponent(room2);

        /***********************************************************/
        // Floor-2 Flat-2

        room1 = new Leaf("Room1",1,2,1);

        flat2 = new Parent("Flat2");
        flat2.addComponent(room1);

        floor2.addComponent(flat1);
        floor2.addComponent(flat2);

        /*********************************************************************************/
        // Building Floor(2)

        building.addComponent(floor1);
        building.addComponent(floor2);

        /***********************************************************/
        // Final stage

        System.out.println("\n" + building);
        System.out.println("\nTB: " + building.getTubeLight()  + ", Fan: " + building.getFan() + ", Window: " + building.getWindows());

        System.out.println("\n****************************************************");

        System.out.println(floor1);
        System.out.println("\nTB: " + floor1.getTubeLight()  + ", Fan: " + floor1.getFan() + ", Window: " + floor1.getWindows());

        System.out.println("\n****************************************************");

        System.out.println("Floor-1 Flat-2 Room-1");
        flat2 = (Parent) floor1.getComponentList().get(1);
        room3 = (Leaf) flat2.getComponentList().get(0);
        System.out.println("\nTB: " + room3.getTubeLight()  + ", Fan: " + room3.getFan() + ", Window: " + room3.getWindows());
    }
}
