package Application;

import model.StaticCalculator;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter radius: ");

        double radius = sc.nextDouble();

        double c = StaticCalculator.circumference(radius);

        double v = StaticCalculator.volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.4f%n", StaticCalculator.PI);
        sc.close();
    }
}