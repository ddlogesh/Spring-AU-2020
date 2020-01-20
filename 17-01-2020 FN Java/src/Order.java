import java.util.List;

public class Order {
    int id;
    String name;
    List<Product> productList;
    Double total;

    public Order(int id, String name, List<Product> productList, Double total) {
        this.id = id;
        this.name = name;
        this.productList = productList;
        this.total = total;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
