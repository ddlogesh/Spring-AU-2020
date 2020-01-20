import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Scanner input;
    private static List<Product> productList;
    private static List<Product> cartList;
    private static List<Order> orderList;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        initProducts();

        do {
            System.out.println("-----------------------------------");
            System.out.println("Menu: \n1.Add Product in Cart\n2.Remove Product in Cart\n3.View Cart\n4.Place Order\n5.Cancel Order\n6.View Order\nChoice: ");
            try {
                int choice = input.nextInt();
                System.out.println("-----------------------------------");
                switch (choice) {
                    case 1:
                        modifyProduct(productList, cartList);
                        break;
                    case 2:
                        modifyProduct(cartList, productList);
                        break;
                    case 3:
                        viewCart();
                        break;
                    case 4:
                        placeOrder();
                        break;
                    case 5:
                        cancelOrder();
                        break;
                    case 6:
                        viewOrder();
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                return;
            }
        } while (true);
    }

    public static void initProducts() {
        productList = new ArrayList<>();
        cartList = new ArrayList<>();
        orderList = new ArrayList<>();

        productList.add(new Product(1, "Jeans", 3, 890.00));
        productList.add(new Product(2, "T Shirt", 6, 450.00));
        productList.add(new Product(3, "Pant", 4, 500.00));
        productList.add(new Product(4, "Shorts", 2, 220.00));
        productList.add(new Product(5, "Saree", 10, 940.00));
    }

    /* Single function to add or remove products from cart by interchanging List
     * Add Product (productList, cartList)
     * Remove Product (cartList, productList)
     */
    public static void modifyProduct(List<Product> productList, List<Product> cartList) {
        String choice = "y";

        while (productList.size() > 0 && choice.equals("y")) {
            System.out.println("Id\tName\t\tQty\tRate");
            for (Product p : productList)
                System.out.println(p.getId() + "\t" + p.getName() + "\t\t" + p.getQuantity() + "\t" + p.getRate());

            System.out.println("Choice (Id Qty): ");
            try {
                int id = input.nextInt();
                int qty = input.nextInt();
                System.out.println("-----------------------------------");

                Supplier<Stream<Product>> productStream = () -> productList.stream().filter(item -> item.getId() == id && item.getQuantity() >= qty);
                if (productStream.get().findFirst().isPresent()) {  // (Item/Stock available)

                    //Update cart list
                    Supplier<Stream<Product>> cartStream = () -> cartList.stream().filter(item -> item.getId() == id);
                    if (cartStream.get().findFirst().isPresent())
                        cartStream.get().map(item -> item.addQuantity(qty)).collect(Collectors.toList());
                    else {
                        Product p = productStream.get().findFirst().orElse(null);
                        cartList.add(new Product(p.getId(), p.getName(), qty, p.getRate()));
                    }

                    //Update product list
                    productStream.get().map(item -> item.removeQuantity(qty)).collect(Collectors.toList());
                    productList.removeIf(item -> item.getQuantity() <= 0);
                } else
                    System.out.println("Item/Stock not available!");
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }

            try {
                System.out.println("Wish 2 continue (y/n): ");
                choice = input.next();
            } catch (Exception e) {
                choice = "n";
            }
        }
        if (productList.size() == 0)
            System.out.println("No products available, Please try again later!");
    }

    public static void viewCart() {
        if (cartList.size() > 0) {
            System.out.println("Id\tName\t\tQty\tRate\tCost");
            for (Product p : cartList)
                System.out.println(p.getId() + "\t" + p.getName() + "\t\t" + p.getQuantity() + "\t" + p.getRate() + "\t" + p.getQuantity() * p.getRate());

            List<Double> costs = cartList.stream().map(item -> item.getRate() * item.getQuantity()).collect(Collectors.toList());
            Double total = costs.stream().reduce(0.00, Double::sum);
            System.out.println("Total: " + total);
            System.out.println("-----------------------------------");
        } else
            System.out.println("Cart is empty!");
    }

    public static void placeOrder() {
        if (cartList.size() > 0) {
            System.out.println("Name: ");
            String name = input.next();
            List<Double> costs = cartList.stream().map(item -> item.getRate() * item.getQuantity()).collect(Collectors.toList());
            Double total = costs.stream().reduce(0.00, Double::sum);
            orderList.add(new Order(orderList.size() + 1, name, new ArrayList<>(cartList), total));
            cartList.clear();
            System.out.println("Order placed successfully!");
        } else
            System.out.println("Cannot place order as cart is empty.");
    }

    public static void cancelOrder() {
        String choice = "y";

        while (orderList.size() > 0 && choice.equals("y")) {
            for (Order order : orderList) {
                System.out.println(order.getId() + ". " + order.getName());
                System.out.println("Id\tName\t\tQty\tRate\tCost");
                for (Product p : order.getProductList())
                    System.out.println(p.getId() + "\t" + p.getName() + "\t\t" + p.getQuantity() + "\t" + p.getRate() + "\t" + p.getQuantity() * p.getRate());
                System.out.println("Total: " + order.getTotal());
                System.out.println("-----------------------------------");
            }

            System.out.println("Choice (Order-id): ");
            try {
                int id = input.nextInt();
                orderList.removeIf(item -> item.getId() == id);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }

            try {
                System.out.println("Wish 2 continue (y/n): ");
                choice = input.next();
            } catch (Exception e) {
                choice = "n";
            }
        }
        if (orderList.size() == 0)
            System.out.println("No Orders!");
    }

    public static void viewOrder() {
        if (orderList.size() > 0) {
            for (Order order : orderList) {
                System.out.println(order.getId() + ". " + order.getName());
                System.out.println("Id\tName\t\tQty\tRate\tCost");
                for (Product p : order.getProductList())
                    System.out.println(p.getId() + "\t" + p.getName() + "\t\t" + p.getQuantity() + "\t" + p.getRate() + "\t" + p.getRate() * p.getQuantity());
                System.out.println("Total: " + order.getTotal());
                System.out.println("-----------------------------------");
            }
        } else
            System.out.println("No Orders!");
    }
}