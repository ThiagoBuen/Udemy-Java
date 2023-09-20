package app;

import model.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
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

        //list.removeIf(p -> p.getPrice() >= 100);  // lambda function
        //list.removeIf(new ProductPredicate());   // Predicate interface
        //list.removeIf(Product::staticProductPredicate); //method reference
        //list.removeIf(Product::nonStaticProductPredicate); //method reference

        Predicate<Product> pred = p -> p.getPrice() >= 100.0;    //declared lambda through a predicate
        list.removeIf(pred);

        for (Product p :
            list ) {
            System.out.println(p);

        }

    }
}