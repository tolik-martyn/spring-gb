package com.example.cartservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "view-cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId) {
        cartService.addToCart(productId);
        return "redirect:/cart/";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam Long productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart/";
    }

    @PostMapping("/checkout")
    public String checkout() {
        cartService.checkout();
        return "redirect:/cart/";
    }
}