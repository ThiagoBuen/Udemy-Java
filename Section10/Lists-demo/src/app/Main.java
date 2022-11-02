package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Mary");
        list.add("John");
        list.add("Matthew");

        list.add(2, "Peter");

        System.out.println(list.size());

        for (String x: list) {
            System.out.println(x);
        }

        System.out.println("------------");

        list.remove(1);
        list.removeIf(x -> x.charAt(0) == 'M');

        System.out.println(list.size());
        for (String x: list) {
            System.out.println(x);
        }

        System.out.println("------------");

        System.out.println("Index of Peter: " + list.indexOf("Peter"));
        System.out.println("Index of Julie: " + list.indexOf("Julie"));

        System.out.println("------------");
        List<String> result = list.stream().filter(x -> x.charAt(0) != 'P').collect(Collectors.toList());

        for (String x: result) {
            System.out.println(x);
        }

        System.out.println("------------");
        String name = list.stream().filter(x -> x.charAt(0) == 'P').findFirst().orElse(null);
        System.out.println(name);



    }
}