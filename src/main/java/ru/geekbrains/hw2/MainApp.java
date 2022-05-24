package ru.geekbrains.hw2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите : \\end - выход,");
        System.out.println("        : \\list - вывод всех продуктов в корзине,");
        System.out.println("        : \\add id1 ... idN - добавление продуктов в корзину,");
        System.out.println("        : \\rem id1 ... idN - удаление продуктов из корзины по id,");
        System.out.println("        : \\sum - покупка(смена корзины)");
        CartService cart = context.getBean(CartService.class);
        System.out.println("Список предлагаемых продуктов:");
        System.out.println(cart.getProductRepositoryAll());
        while (true) {
            System.out.println("Введите команду:");
            String str = sc.nextLine();
            String[] s = str.split("\\s+");
            if (s[0].equals("\\end")) {
                break;
            }
            if (s[0].equals("\\list")) {
                System.out.println(cart.getProductCartAll());
                continue;
            }
            if (s[0].equals("\\add")) {
                if(s.length > 1) {
                    for (int i = 1; i < s.length; i++) {
                        long id = Long.parseLong(s[i]);
                        cart.addProductCart(id);
                    }
                }
            }
            if (s[0].equals("\\rem")){
                if(s.length > 1) {
                    for (int i = 1; i < s.length; i++) {
                        long id = Long.parseLong(s[i]);
                        cart.removeProductCart(id);
                    }
                }
            }
            if (s[0].equals("\\sum")){
                cart.setCart(context.getBean(Cart.class));
            }
        }
        context.close();
    }
}