package project.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.shoppingcart.model.Cart;
import project.shoppingcart.model.Item;
import project.shoppingcart.repository.CartRepository;

import java.util.Optional;

public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Long id, @RequestBody Item item){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if(savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        }else{
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @RequestMapping(value = {"/id"},method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Long id){
        return cartRepository.findById(id);
    }

    @RequestMapping(value = {"/id"}, method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")Long id){
        cartRepository.deleteById(id);
    }




}


