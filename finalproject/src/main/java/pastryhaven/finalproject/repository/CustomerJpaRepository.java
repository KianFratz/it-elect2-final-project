package pastryhaven.finalproject.repository;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import pastryhaven.finalproject.model.Customer;

@Repository
@Transactional
public class CustomerJpaRepository {
	@PersistenceContext
	private EntityManager entitymanager;
	
	public void insert(Customer customer) {
		entitymanager.merge(customer);
    }

    public Customer findById(long id) {
        return entitymanager.find(Customer.class, id);
    }

    public void deleteById(long id) {
    	Customer customer = entitymanager.find(Customer.class, id);
    	entitymanager.remove(customer);
    }

}
