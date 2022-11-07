package app;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        LocalDate date01 = LocalDate.now();
        LocalDateTime date02 = LocalDateTime.now();
        Instant date03 = Instant.now();

        LocalDate date04 = LocalDate.parse("2022-07-20");
        LocalDateTime date05 = LocalDateTime.parse("2022-07-20T22:35:14");
        Instant date06 = Instant.parse("2022-07-20T22:35:14Z");
        Instant date07 = Instant.parse("2022-07-20T22:35:14-03:00");

        LocalDate date08 = LocalDate.parse("20/07/2022", fmt1);
        LocalDateTime date09 = LocalDateTime.parse("20/07/2022 14:55", fmt2);

        LocalDate date10 = LocalDate.of(2022, 7, 20);
        LocalDateTime date11 = LocalDateTime.of(2022, 7, 20, 11, 35);

        System.out.println("data01: " + date01);
        System.out.println("data02: " + date02);
        System.out.println("data03: " + date03);
        System.out.println("data04: " + date04);
        System.out.println("data05: " + date05);
        System.out.println("data06: " + date06);
        System.out.println("data07: " + date07);
        System.out.println("data08: " + date08);
        System.out.println("data09: " + date09);
        System.out.println("data10: " + date10);
        System.out.println("data11: " + date11);


        //Convertions

        System.out.println("data04 formatted: " + date04.format(fmt1));
        System.out.println("data04 formatted: " + fmt1.format(date04));
        System.out.println("data05 formatted: " + fmt1.format(date05));
        System.out.println("data05 formatted: " + fmt2.format(date05));
        System.out.println("data06 formatted: " + fmt3.format(date06));
        System.out.println("data05 formatted: " + fmt4.format(date05));
        System.out.println("data06 formatted: " + fmt5.format(date06));
        System.out.println("data06 formatted: " + date06.toString());
    }
}