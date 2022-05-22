package ru.geekbrains.hw2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(@Qualifier(value = "productRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }
    public List<Product> getProductAll() {
        return productRepository.getProductAll();
    }
    public void addProduct(String title, int price){
        productRepository.addProduct(title, price);
    }
    public void removeProduct(Long id){
        productRepository.removeProduct(id);
    }
}