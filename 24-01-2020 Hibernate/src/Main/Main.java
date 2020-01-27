package Main;

import config.DBConfig;
import model.*;
import org.hibernate.query.Query;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Populate products (Mobile)
        Mobile mobile1 = new Mobile();
        mobile1.setId(1);
        mobile1.setName("Oppo F1 plus");
        mobile1.setUrl("https://oppo.com");
        mobile1.setCost(8900.00);
        mobile1.setBrand("Oppo");
        mobile1.setModelNumber("F1 plus");

        Mobile mobile2 = new Mobile();
        mobile2.setId(2);
        mobile2.setName("Vivo V3");
        mobile2.setUrl("https://vivo.com");
        mobile2.setCost(13000.00);
        mobile2.setBrand("Vivo");
        mobile2.setModelNumber("V3");

        // Populate products (Dress)
        Dress dress1 = new Dress();
        dress1.setId(1);
        dress1.setName("Jeans");
        dress1.setUrl("https://jean.com");
        dress1.setCost(890.00);
        dress1.setSize(40);
        dress1.setModel("Peter England");

        Dress dress2 = new Dress();
        dress2.setId(2);
        dress2.setName("Shirt");
        dress2.setUrl("https://jean.com");
        dress2.setCost(450.50);
        dress2.setSize(32);
        dress2.setModel("Otto");

        /********************************************************/
        // Set Address

        Address deliveryAddress = new Address();
        deliveryAddress.setNumber(10);
        deliveryAddress.setStreet("Rajaji street");
        deliveryAddress.setArea("Thiruverkadu");
        deliveryAddress.setCity("Chennai");
        deliveryAddress.setPincode("600077");

        /********************************************************/
        // Populate orders

        Orders orders1 = new Orders();
        orders1.setId(1);
        orders1.setAmount(1150.00);
        orders1.setStatus("Processing");
        orders1.getProductList().add(dress1);
        orders1.getProductList().add(dress2);
        orders1.setDeliveryAddress(deliveryAddress);

        Orders orders2 = new Orders();
        orders2.setId(2);
        orders2.setAmount(760.70);
        orders2.setStatus("Delivered");
        orders2.getProductList().add(mobile1);
        orders2.getProductList().add(mobile2);
        orders2.setDeliveryAddress(deliveryAddress);

        /********************************************************/
        // Populate Cart items

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setAmount(120.00);
        cart1.getProductList().add(mobile1);
        cart1.getProductList().add(dress2);

        Cart cart2 = new Cart();
        cart2.setId(2);
        cart2.setAmount(340.00);
        cart2.getProductList().add(mobile2);
        cart2.getProductList().add(dress1);

        /********************************************************/
        // Populate Customer

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Logesh");
        customer.setMobile("9176786586");
        customer.setEmail("logesh.d@accoliteindia.com");
        customer.setHomeAddress(deliveryAddress);
        customer.setShippingAddress(deliveryAddress);

        customer.getOrdersList().add(orders1);
        customer.getOrdersList().add(orders2);
        customer.setCart(cart1);

        /********************************************************/
        // Populate crud.Transaction

        Transaction transaction1 = new Transaction();
        transaction1.setId(1);
        transaction1.setDate(new Date());
        transaction1.setOrderId(orders1);
        transaction1.setPaymentMode("DEBIT");
        transaction1.setStatus("Success");
        transaction1.setTransAmount(120.00);

        Transaction transaction2 = new Transaction();
        transaction2.setId(2);
        transaction2.setDate(new Date());
        transaction2.setOrderId(orders2);
        transaction2.setPaymentMode("UPI");
        transaction2.setStatus("Pending");
        transaction2.setTransAmount(430.00);

        /********************************************************/
        // CRUD Operations

        DBConfig.initiateDB();
        DBConfig.insert(mobile1);
        DBConfig.insert(mobile2);
        DBConfig.insert(dress1);
        DBConfig.insert(dress2);
        DBConfig.insert(orders1);
        DBConfig.insert(orders2);
        DBConfig.insert(cart1);
        DBConfig.insert(cart2);
        DBConfig.insert(customer);
        DBConfig.insert(transaction1);
        DBConfig.insert(transaction2);
        System.out.println("After Insert: " + DBConfig.getAllValues("Transaction"));

        DBConfig.delete(transaction2);
        System.out.println("After Delete: " + DBConfig.getAllValues("Transaction"));

        transaction1.setStatus("Failure");
        DBConfig.update(transaction1);
        System.out.println("After Update: " + DBConfig.getAllValues("Transaction"));

        System.out.println(DBConfig.getSession().get(Orders.class, 5));

        /********************************************************/
        // Named Query Demo

        Query query = DBConfig.getSession().getNamedQuery("UPDATE_ORDERS_BY_ID").setInteger("id", 5).setDouble("amount", 200.00);
        query.executeUpdate();

        /********************************************************/
        // Named Native Query Demo

        query = DBConfig.getSession().getNamedQuery("getAllCustomers");
        System.out.println(query.list());

        /********************************************************/

        DBConfig.close();
    }
}