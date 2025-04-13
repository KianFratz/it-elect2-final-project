package pastryhaven.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	
	@GetMapping("/login")
    public String viewLogin() {
    	return "login";
    }
    
    @GetMapping("/register")
    public String viewRegister() {
    	return "register";
    }
    
    @GetMapping("/product")
    public String viewProduct() {
    	return "product";
    }
	
}
