package hibernate;

import model.UserDetails;
import model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Vijay");

//        Address home_address = new Address();
//        home_address.setPincode("600077");
//        home_address.setStreet("Chennai");
        //userDetails.setHome_address(home_address);

//        Address office_address = new Address();
//        office_address.setPincode("600044");
//        office_address.setStreet("Bangalore");
        //userDetails.setOffice_address(office_address);

        //userDetails.getAddressCollection().add(home_address);
        //userDetails.getAddressCollection().add(office_address);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setName("Vehicle1");
        session.save(vehicle);

        vehicle = new Vehicle();
        vehicle.setId(2);
        vehicle.setName("Vehicle2");
        session.save(vehicle);

        vehicle = new Vehicle();
        vehicle.setId(3);
        vehicle.setName("Vehicle3");
        session.save(vehicle);

        session.getTransaction().commit();

        session.close();

        /*session = sessionFactory.openSession();
        userDetails = (UserDetails) session.get(UserDetails.class, 1);
        session.close();*/

        //LazyException
        //Collection<Address> address = userDetails.getAddressCollection();
        //System.out.println(address.iterator().next().getPincode());
    }
}