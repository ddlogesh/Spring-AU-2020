package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="UPDATE_ORDERS_BY_ID", query=Orders.UPDATE_ORDERS_BY_ID_QUERY)
public class Orders {
    public static final String UPDATE_ORDERS_BY_ID_QUERY = "UPDATE Orders d SET d.amount=:amount where d.id = :id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private int id;

    private Double amount;
    private Date date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "OrderHistory", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> productList;

    @Embedded
    private Address deliveryAddress;

    private String status;

    public Orders() {
        productList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order id=" + id + ", amount=" + amount +
                "\nDelivery Address: " + deliveryAddress + "\nstatus=" + status;
    }
}
