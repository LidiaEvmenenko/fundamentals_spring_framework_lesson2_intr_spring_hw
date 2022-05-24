package ru.geekbrains.hw2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CartService {
    private ProductRepository productRepository;
    private Cart cart;

    @Autowired
    public void setProductRepository(@Qualifier(value = "productRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setCart(@Qualifier(value = "cart")Cart cart) {
        this.cart = cart;
    }
    public List<Product> getProductCartAll() {
        return cart.getProductCartAll();
    }
    public void addProductCart(Long id){
        cart.addProductCart(productRepository.getProductById(id));
    }
    public void removeProductCart(Long id){
        cart.removeProductCart(id);
    }
    public List<Product> getProductRepositoryAll(){
        return productRepository.getProductAll();
    }
}

