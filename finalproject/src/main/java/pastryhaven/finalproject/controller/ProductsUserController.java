package pastryhaven.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pastryhaven.finalproject.model.Product;
import pastryhaven.finalproject.repository.ProductsUserRepository;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ProductsUserController {

    @Autowired
    private ProductsUserRepository productsUserRepository;

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> products = productsUserRepository.findAll();
        model.addAttribute("products", products);
        return "user/product";
    }
}
