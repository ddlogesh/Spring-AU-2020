import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner input;
    private static List<Product> productList;
    private static List<Product> cartList;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        initProducts();

        do {
            showMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    return;
            }
        }
        while (true);
    }

    public static void initProducts() {
        productList = new ArrayList<>();
        cartList = new ArrayList<>();

        productList.add(new Product(1, "Jeans", 3, 890.00));
        productList.add(new Product(2, "T Shirt", 6, 450.00));
        productList.add(new Product(3, "Pant", 4, 500.00));
        productList.add(new Product(4, "Chudidhar", 2, 780.00));
        productList.add(new Product(5, "Saree", 10, 940.00));
    }

    public static void showMenu() {
        System.out.println("Menu: \n1.Add Product in Cart\n2.Remove Product in Cart\n3.View Cart\n4.Place Order\n5.Cancel Order\nChoice: ");
    }

    public static void addProduct() {
        if (productList.size() > 0) {
            System.out.println("Id\tName (Qty)\tCost");
            for (Product p : productList) {
                System.out.println(p.getId() + "\t" + p.getName() + " (" + p.getQuantity() + ")\t" + p.getRate());
            }
            System.out.println("Choice (Id Qty): ");
            int id = input.nextInt();
            int qty = input.nextInt();
            Product p = productList.get(id - 1);
            while (qty > p.getQuantity()) {
                System.out.println("Stock not available! Available quantity: " + p.getQuantity() + "\nQty: ");
                qty = input.nextInt();
            }
            int quantity = qty;

            //Update cart & product list
            List<Product> result = cartList.stream().filter(item -> item.getId() == id).map(item -> item.addQuantity(quantity)).collect(Collectors.toList());
            if (result.size() == 0)
                cartList.add(new Product(id, p.getName(), qty, p.getRate()));

            if (qty == p.getQuantity())
                productList.removeIf(item -> item.getId() == id && quantity == p.getQuantity());
            else
                productList.stream().filter(item -> item.getId() == id).map(item -> item.removeQuantity(quantity));
        } else
            System.out.println("No products available, Please try again later!");
    }

    public static void removeProduct(){

    }

    public static void viewCart(){
        
    }
}