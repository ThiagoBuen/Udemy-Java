package app;

import model.ImportedProduct;
import model.Product;
import model.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char productType = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String productName =  sc.next();
            System.out.print("Price: ");
            double productPrice = sc.nextDouble();

            if (productType == 'c') {
                Product product = new Product(productName, productPrice);
                products.add(product);
            } else if (productType == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY) : ");
                Date manufactureDate = sdf.parse(sc.next());
                Product product = new UsedProduct(productName, productPrice, manufactureDate);
                products.add(product);
            } else {
                System.out.print("Customs fee : ");
                double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(productName, productPrice, customsFee);
                products.add(product);
            }
        }

        System.out.println();

        System.out.println("PRICE TAGS");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();

    }
}