public class Product {
    int id;
    String name;
    int quantity;
    Double rate;

    public Product(int id, String name, int quantity, Double rate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
    }

    public Product addQuantity(int quantity) {
        this.quantity += quantity;
        return this;
    }

    public Product removeQuantity(int quantity) {
        this.quantity -= quantity;
        return this;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
