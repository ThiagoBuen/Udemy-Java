package application;

import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Program {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("TV", 900.00));
        productList.add(new Product("Notebook", 1100.00));
        productList.add(new Product("Tablet", 500.00));

        productList.sort((p1, p2) ->
                p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : productList) {
            System.out.println(p);
        }

    }
}