package ru.geekbrains.hw2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите : \\end - выход,");
        System.out.println("        : \\list - вывод всех продуктов,");
        System.out.println("        : \\list id - вывод продукта по id,");
        System.out.println("        : \\add title price - ввод нового продукта с названием title и ценой price,");
        System.out.println("        : \\rem id - удаление по id.");
        while (true) {
            Cart cart = context.getBean(Cart.class);
            System.out.println("Введите команду:");
            String str = sc.nextLine();
            String[] s = str.split("\\s+");
            if (s[0].equals("\\end")) {
                break;
            }
            if (s[0].equals("\\list")) {
                if (s.length > 1) {
                    long id = Long.parseLong(s[1]);
                    System.out.println(cart.getProductById(id));
                    continue;
                }else {
                    System.out.println(cart.getProductAll());
                }
                continue;
            }
            if (s[0].equals("\\add")) {
                String title = s[1];
                int price = Integer.parseInt(s[2]);
                cart.addProduct(title, price);
            }
            if (s[0].equals("\\rem")){
                long id = Long.parseLong(s[1]);
                cart.removeProduct(id);
            }
        }
        context.close();
    }
}