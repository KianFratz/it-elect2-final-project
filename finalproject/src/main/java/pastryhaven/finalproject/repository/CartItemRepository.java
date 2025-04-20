// CartItemRepository.java  (optional; cascade=true means you may not need this)
package pastryhaven.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pastryhaven.finalproject.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> { }
