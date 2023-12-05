package application;

import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter full file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Product> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            double avgPrice = list.stream().map(p -> p.getPrice()).reduce(0.0, (x,y) -> x + y) / list.size();
            System.out.println("Average Price: " + String.format("%.2f", avgPrice));

            Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = list.stream()
                                    .filter(p -> p.getPrice() < avgPrice)
                                    .map(p -> p.getName())
                                    .sorted(comp.reversed())
                                    .toList();
            names.forEach(System.out::println);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}