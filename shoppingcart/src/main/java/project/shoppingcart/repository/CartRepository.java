package project.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import project.shoppingcart.model.Cart;

public interface CartRepository extends CrudRepository<Cart,Long> {
}
