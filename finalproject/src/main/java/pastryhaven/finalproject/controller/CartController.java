package pastryhaven.finalproject.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pastryhaven.finalproject.model.Cart;
import pastryhaven.finalproject.model.CartItem;
import pastryhaven.finalproject.service.CartService;
import pastryhaven.finalproject.repository.ProductsUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user/cart")
public class CartController {


    @Autowired
    private ProductsUserRepository productRepo;

    @Autowired
    private CartService cartService;

    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        model.addAttribute("cart", cart);
        return "user/cart";
    }

    // CartController.java
    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam(required=false) Long cartId,
                            HttpSession session) {
        
        // Retrieve or generate a temporary user ID
        String tempUserId = (String) session.getAttribute("tempUserId");
        if (tempUserId == null) {
            tempUserId = UUID.randomUUID().toString();
            session.setAttribute("tempUserId", tempUserId);
        }

        // retrieve cartId from session or param
        Long currentCartId = (Long) session.getAttribute("cartId");
        Cart cart = cartService.addItem(currentCartId, productId);
        session.setAttribute("cartId", cart.getId());

        // you may also refresh session-stored cart DTO if you like
        return "redirect:/user/cart";
    }


    @GetMapping("/remove")
    public String removeFromCart(@RequestParam int id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getId() == id);
            session.setAttribute("cart", cart);
        }
        return "redirect:/user/cart";
    }

}
