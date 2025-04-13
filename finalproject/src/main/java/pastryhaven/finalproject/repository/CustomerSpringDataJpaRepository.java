package pastryhaven.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pastryhaven.finalproject.model.Customer;


public interface CustomerSpringDataJpaRepository extends JpaRepository<Customer, Long>{
	    List<Customer> findByEmailAddress(String emailAdress);
	    List<Customer> findByContactNumber(Integer contactNumber);
	
}
