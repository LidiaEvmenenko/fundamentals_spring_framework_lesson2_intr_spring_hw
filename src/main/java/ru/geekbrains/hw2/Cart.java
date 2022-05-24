package ru.geekbrains.hw2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private List<Product> cartList;

    public Cart(List<Product> cartList) {
        this.cartList = cartList;
    }

    public List<Product> getProductCartAll() {
        return cartList;
    }
    public void addProductCart(Product product){
        cartList.add(product);
    }
    public void removeProductCart(Long id){
        for (int i=0; i< cartList.size(); i++){
            if (cartList.get(i).getId() == id){
                cartList.remove(i);
                break;
            }
        }
    }
}
