package service;

import model.CartItem;
import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ShoppingCart {

    private final List<CartItem> cartItemList = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        if (!isContains(cartItemList, cartItem.getProduct())) {
            cartItemList.add(cartItem);
        } else {
            for (CartItem item : cartItemList) {
                if (item.getProduct().equals(product)) {
                    item.setQuantity(item.getQuantity() + quantity);
                }
            }
        }

    }

    public boolean isContains(List<CartItem> list, Product product) {
        for (CartItem cartItem : list) {
            if (cartItem.getProduct().equals(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean findById(Long productId) {
        for (int i = 0; i < cartItemList.size(); i++) {
            if(!cartItemList.get(i).getProduct().getId().equals(productId)){
                return false;
            }
        }
        return true;
    }

    public void removeProduct(Long productId) {
        if (findById(productId)) {
            throw new NoSuchElementException("Нет такого продукта с id: " + productId);
        }
        int index = 0;
        for (int i = 0; i < cartItemList.size(); i++) {
            if (cartItemList.get(i).getProduct().getId().equals(productId)) {
                index = i;
            }
        }
        cartItemList.remove(index);
    }

    public void updateQuantity(Long productId, int quantity) {

    }

    public BigDecimal getTotalPrice() {
        return null;
    }

    public List<CartItem> getItems() {
        return cartItemList;
    }
}
