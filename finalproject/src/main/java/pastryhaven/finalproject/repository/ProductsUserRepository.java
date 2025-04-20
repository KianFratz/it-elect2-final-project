package pastryhaven.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pastryhaven.finalproject.model.Product;

public interface ProductsUserRepository extends JpaRepository<Product, Long> {
}
