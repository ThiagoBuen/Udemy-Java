package app;

import model.Product;
import util.UppercaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.00));
        list.add(new Product("HD Case", 80.90));

//        List<String> names = list.stream().map(new UppercaseName()).collect(Collectors.toList());
//        List<String> names = list.stream().map(Product::staticUppercaseName).collect(Collectors.toList());
//        List<String> names = list.stream().map(Product::nonStaticUppercaseName).collect(Collectors.toList());

//        Function<Product,String> func = p -> {           //declared labmda function
//          return p.getName().toUpperCase();
//        };
//
//        List<String> names = list.stream().map(func).collect(Collectors.toList());

        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}