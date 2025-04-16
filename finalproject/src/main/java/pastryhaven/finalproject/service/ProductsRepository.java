package pastryhaven.finalproject.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pastryhaven.finalproject.model.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
}
