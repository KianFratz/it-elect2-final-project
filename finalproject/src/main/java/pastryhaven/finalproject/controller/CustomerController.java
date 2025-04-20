package pastryhaven.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import pastryhaven.finalproject.model.Customer;
import pastryhaven.finalproject.repository.CustomerRepository;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    
    @GetMapping({""})
    public String listCustomer(Model model) {
        model.addAttribute("customer", repository.findAll());
        return "customer-list";
    }
    
    @GetMapping("/aboutus")
    public String aboutUspage() {
    	return "about-us";
    }
    
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        // Check if customer is being created or updated
        if (customer.getId() == null) { // New customer
            // If no password is provided, set a default password
            if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
                customer.setPassword("defaultPassword123");  // Set default password
            }
        } else { // Existing customer, update
            // If no new password is provided, keep the existing password
            Customer existingCustomer = repository.findById(customer.getId())
                                                  .orElseThrow(() -> new IllegalArgumentException("Invalid Customer ID: " + customer.getId()));
            if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
                customer.setPassword(existingCustomer.getPassword()); // Keep old password
            }
        }
        
        // Save the customer entity
        repository.save(customer);

        return "redirect:/customer";
    }


    
    // Show edit form
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Customer customer = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Customer ID: " + id));
        model.addAttribute("customer", customer);
        return "customer-update";  // Renders customer-update.html
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/customer";  // Redirect ensures page refreshes
    }


}

