package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedNativeQuery(
    name = "getAllCustomers",
    query = "SELECT * FROM Customer",
    resultClass=Customer.class
)
public class Customer {

    @Id
    @Column(name = "custId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String mobile;
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "num", column = @Column(name = "HOME_number")),
            @AttributeOverride(name = "street", column = @Column(name = "HOME_street")),
            @AttributeOverride(name = "area", column = @Column(name = "HOME_area")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_city")),
            @AttributeOverride(name = "pincode", column = @Column(name = "HOME_pincode"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "num", column = @Column(name = "shipping_number")),
            @AttributeOverride(name = "street", column = @Column(name = "shipping_street")),
            @AttributeOverride(name = "area", column = @Column(name = "shipping_area")),
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
            @AttributeOverride(name = "pincode", column = @Column(name = "shipping_pincode"))
    })
    private Address shippingAddress;

    @OneToMany
    @JoinTable(name = "CustomerOrders", joinColumns = @JoinColumn(name = "custId"), inverseJoinColumns = @JoinColumn(name = "orderId"))
    private List<Orders> ordersList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private Cart cart;

    public Customer() {
        ordersList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Customer: " + "id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email +
                ", homeAddress=" + homeAddress + ", shippingAddress=" + shippingAddress;
    }
}
