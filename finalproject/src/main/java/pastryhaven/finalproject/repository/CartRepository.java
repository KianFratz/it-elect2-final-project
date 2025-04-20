// CartRepository.java
package pastryhaven.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pastryhaven.finalproject.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // you can add findByUserId() if you want one cart per user
}
