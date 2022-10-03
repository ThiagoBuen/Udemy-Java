package application;

import model.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.println("Enter product data: ");
        System.out.println("Name: ");
        product.name = sc.nextLine();
        System.out.print("Price: ");
        product.price = sc.nextDouble();
        System.out.println("Quantity in stock: ");
        product.quantity = sc.nextInt();

        //System.out.println(product.name + ", " + product.price + ", " + product.quantity);
        System.out.println(product);

        System.out.println("Enter the number of products to be added in the stock: ");
        int quantityToAdd = sc.nextInt();
        product.addProducts(quantityToAdd);

        System.out.println("Enter the number of products to be removed from the stock: ");
        int quantityToRemove = sc.nextInt();
        product.removeProducts(quantityToRemove);

        System.out.println(product);

        sc.close();
    }
}