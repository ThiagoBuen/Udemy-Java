import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the csv path: ");
        String strPath = sc.nextLine();
        boolean success = true;

        if (!new File("./fileOutput").exists()) {
            success = new File("./fileOutput").mkdir();
        }

        String pathToStoreFile = "./fileOutput/summary.csv";

        File path = new File(strPath);
        ArrayList<Product> productList = new ArrayList<Product>();

        if (path.isFile() && success) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))){
                String line = br.readLine();
                while (line != null) {
                    System.out.println(line);
                    String[] splittedLine = line.split(",");
                    if (splittedLine.length == 3) {
                        String name = splittedLine[0];
                        Double price = Double.valueOf(splittedLine[1]);
                        Integer quantity = Integer.valueOf(splittedLine[2]);
                        productList.add(new Product(name, price, quantity));
                    }
                    line = br.readLine();

                }
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToStoreFile, true))) {
            bw.write("name" + "," + "totalValue");
            bw.newLine();

            productList.forEach(product -> {
                try {
                    System.out.println(product.getName());
                    bw.write(product.getName() + "," + product.total());
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}