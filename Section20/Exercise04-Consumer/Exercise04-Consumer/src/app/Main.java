package app;

import model.Product;
import util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.00));
        list.add(new Product("HD Case", 80.90));

//        list.forEach(new PriceUpdate());          Consumer interface with forEach
//        list.forEach(Product::staticPriceUpdate); Static method
//        list.forEach(Product::nonStaticPriceUpdate); Non static method

        double factor = 1.1;
//        Consumer<Product> cons = p -> {           //declared labmda function
//          p.setPrice(p.getPrice() * factor);
//        };
//        list.forEach(cons);

        list.forEach(p -> p.setPrice(p.getPrice() * factor));       //lambda inline
        list.forEach(System.out::println);
    }
}