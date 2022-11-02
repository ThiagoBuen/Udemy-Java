package app;

import model.Rent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("How many rooms will be rented?");

        int totalRooms = sc.nextInt();

        Rent[] rents = new Rent[10];

        for (int i = 0; i < totalRooms; i++){
            System.out.println("Enter the room number to be rented:");
            int roomToRent = sc.nextInt();

            System.out.println("Enter the name of the student ");
            String studentName = sc.next();

            System.out.println("Enter the email of the student ");
            String studentEmail = sc.next();

            System.out.println("Enter the rent for the room " + (i+1));
            Double rentToBePaid = sc.nextDouble();

            rents[roomToRent] = new Rent(studentName, studentEmail, roomToRent, rentToBePaid);

        }

        System.out.println();
        System.out.println("Busy Rooms");

        for (int i = 0; i < 10; i++) {
            if (rents[i] != null){
                System.out.println(i + ": " + rents[i]);
            }
        }

        sc.close();
    }
}