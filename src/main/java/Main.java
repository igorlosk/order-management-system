import model.CartItem;
import model.Product;
import service.ShoppingCart;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setPrice(new BigDecimal("80000"));

        Product mouse = new Product();
        mouse.setName("Mouse");
        mouse.setPrice(new BigDecimal("1500"));

        Product keyboard = new Product();
        keyboard.setName("Keyboard");
        keyboard.setPrice(new BigDecimal("5000"));

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(laptop, 1);
        cart.addProduct(mouse, 2);
        cart.addProduct(keyboard, 1);
        cart.addProduct(mouse, 1);

        cart.removeProduct(4L);

        cart.getItems().forEach(System.out::println);


    }
}
