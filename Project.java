import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(name + " - Rs." + price + " x " + quantity);
    }
}

class Cart {
    Product[] items = new Product[10];
    int count = 0;

    void addProduct(Product p) {
        items[count] = p;
        count++;
        System.out.println(p.name + " added!");
    }

    void viewCart() {
        for (int i = 0; i < count; i++) {
            items[i].display();
        }
    }

    void checkout() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].price * items[i].quantity;
        }
        double discount = total * 0.10;
        double tax = (total - discount) * 0.05;
        double final_amount = total - discount + tax;

        System.out.println("Total: Rs." + total);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Tax: Rs." + tax);
        System.out.println("Final Amount: Rs." + final_amount);
    }
}

public class Project {
    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.addProduct(new Product("Shirt", 500, 2));
        cart.addProduct(new Product("Shoes", 1000, 1));

        System.out.println("--- Cart ---");
        cart.viewCart();

        System.out.println("--- Bill ---");
        cart.checkout();
    }
}