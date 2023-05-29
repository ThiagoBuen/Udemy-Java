import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(5, 42 ,25);
        printList(myInts);

        List<String> myStrs = Arrays.asList("Alex", "Joao", "Maria");
        printList(myStrs);
    }

    public static void printList(List<?> list) {
        System.out.println("Printing list: ");
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}