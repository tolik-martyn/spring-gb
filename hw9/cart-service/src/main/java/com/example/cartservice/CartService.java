package com.example.cartservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Map<Long, Integer> getCart() {
        return cartRepository.getCartItems();
    }

    public void addToCart(Long productId) {
        cartRepository.addToCart(productId);
    }

    public void removeFromCart(Long productId) {
        cartRepository.removeFromCart(productId);
    }

    public void checkout() {
        cartRepository.clearCart();
    }
}