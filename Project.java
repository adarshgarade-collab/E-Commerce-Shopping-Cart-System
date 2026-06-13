class Item {
    private String name;
    private double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Product extends Item {
    private int quantity;

    Product(String name, double price, int quantity) {
        super(name, price);   // calling parent constructor
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    void display() {
        System.out.println(getName() + " - Rs." + getPrice() + " x " + quantity);
    }
}

class Cart {
    private Product[] items = new Product[10];
    private int count = 0;

    void addProduct(Product p) {
        items[count++] = p;
        System.out.println(p.getName() + " added!");
    }

    void viewCart() {
        for (int i = 0; i < count; i++) {
            items[i].display();
        }
    }

    void checkout() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += items[i].getPrice() * items[i].getQuantity();
        }

        double discount = total * 0.10;
        double tax = (total - discount) * 0.05;
        double finalAmount = total - discount + tax;

        System.out.println("Total: Rs." + total);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Tax: Rs." + tax);
        System.out.println("Final Amount: Rs." + finalAmount);
    }
}

public class Project {
    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.addProduct(new Product("Shirt", 500, 2));
        cart.addProduct(new Product("Shoes", 1000, 1));

        System.out.println("\n--- Cart ---");
        cart.viewCart();

        System.out.println("\n--- Bill ---");
        cart.checkout();
    }
}
