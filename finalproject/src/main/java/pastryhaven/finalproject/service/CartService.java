// CartService.java
package pastryhaven.finalproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import pastryhaven.finalproject.model.Cart;
import pastryhaven.finalproject.model.CartItem;
import pastryhaven.finalproject.model.Product;
import pastryhaven.finalproject.repository.CartRepository;
import pastryhaven.finalproject.repository.ProductsRepository;

@Service
public class CartService {

    private final CartRepository cartRepo;
    private final ProductsRepository productRepo;

    public CartService(CartRepository cartRepo, ProductsRepository productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    @Transactional
    public Cart addItem(Long cartId, Long productId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUserId("someUser");  // replace with actual user context
                    return cartRepo.save(c);
                });

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<CartItem> existing = cart.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst();

        if (existing.isPresent()) {
            existing.get().setQuantity(existing.get().getQuantity() + 1);
        } else {
            CartItem item = new CartItem();
            item.setCart(cart);
            item.setProduct(product);
            item.setQuantity(1);
            item.setPrice(product.getPrice());
            cart.getItems().add(item);
        }

        return cartRepo.save(cart);
    }
}
