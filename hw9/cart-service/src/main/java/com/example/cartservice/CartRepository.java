package com.example.cartservice;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepository {

    private final Map<Long, Integer> cartItems = new HashMap<>();

    public Map<Long, Integer> getCartItems() {
        return cartItems;
    }

    public void addToCart(Long productId) {
        cartItems.put(productId, cartItems.getOrDefault(productId, 0) + 1);
    }

    public void removeFromCart(Long productId) {
        if (cartItems.containsKey(productId)) {
            int quantity = cartItems.get(productId);
            if (quantity > 1) {
                cartItems.put(productId, quantity - 1);
            } else {
                cartItems.remove(productId);
            }
        }
    }

    public void clearCart() {
        cartItems.clear();
    }
}