package project.productcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productcatalog.model.Product;
import project.productcatalog.repository.ProductRepository;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;



    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product){
    return productRepository.save(product);
}

    @RequestMapping(method = RequestMethod.GET)
    public Optional<Product> getById(@PathVariable Long id){
        return productRepository.findById(id);
    };

}
