package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="productType", discriminatorType = DiscriminatorType.INTEGER)
public class Product {
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Double cost;
    private String url;

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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product id=" + id + ", name=" + name + ", cost=" + cost + ", url=" + url;
    }
}
