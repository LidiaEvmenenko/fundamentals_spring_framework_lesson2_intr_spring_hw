package ru.geekbrains.hw2;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products= new ArrayList<>(Arrays.asList(
                new Product(1L, "Молоко", 85),
                new Product(2L, "Хлеб", 25),
                new Product(3L, "Сыр", 560),
                new Product(4L, "Макароны", 90),
                new Product(5L, "Творог", 125)
        ));
    }

    public Product getProductById(Long id){
        return products.stream().filter(i -> i.getId()== id).findFirst().get();
    }

    public List<Product> getProductAll() {
        return products;
    }

    public void addProduct(String title, int price){
        Long newId = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
        Product product = new Product(newId, title, price);
        products.add(product);
    }

    public void removeProduct(Long id){
        for (int i=0; i< products.size(); i++){
            if (products.get(i).getId() == id){
                products.remove(i);
                break;
            }
        }
    }
}

