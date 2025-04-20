package pastryhaven.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pastryhaven.finalproject.model.Customer;
import pastryhaven.finalproject.model.CustomerDto;
import pastryhaven.finalproject.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer authenticateCustomer(String emailAddress, String password) {
        // Check if email exists
        Customer customer = customerRepository.findByEmailAddress(emailAddress)
                .orElseThrow(() -> new RuntimeException("Email not found!"));

        // Validate password
        if (!password.equals(customer.getPassword())) {
            throw new IllegalArgumentException("Incorrect password!");
        }

        return customer; // Return authenticated customer
    }

    public CustomerService(CustomerRepository repo) {
        this.customerRepository = repo;
    }

    public boolean isEmailRegistered(String email) {
        return customerRepository.existsByEmailAddress(email);
    }

    public Customer registerNewCustomer(CustomerDto dto) {
        // map dto to entity, set fields…
        return customerRepository.save(new Customer(dto));
    }

}
