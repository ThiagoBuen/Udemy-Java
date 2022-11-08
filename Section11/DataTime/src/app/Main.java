package app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

        //DateTime Operations

        LocalDate r01 = LocalDate.ofInstant(date06, ZoneId.systemDefault());
        LocalDate r02 = LocalDate.ofInstant(date06, ZoneId.of("Portugal"));
        LocalDateTime r03 = LocalDateTime.ofInstant(date06, ZoneId.systemDefault());
        LocalDateTime r04 = LocalDateTime.ofInstant(date06, ZoneId.of("Portugal"));


        System.out.println("r01: " + r01);
        System.out.println("r02: " + r02);
        System.out.println("r03: " + r03);
        System.out.println("r04: " + r04);

        System.out.println("d04 day: " + date04.getDayOfMonth());
        System.out.println("d04 month: " + date04.getMonthValue());
        System.out.println("d04 year: " + date04.getYear());

        LocalDate pastWeekLocalDate = date04.minusWeeks(1);
        LocalDate nextWeekLocalDate = date04.plusDays(7);

        System.out.println("pastWeekLocalDate: " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate: " + nextWeekLocalDate);

        LocalDateTime pastYearLocalDateTime = date05.minusYears(2);
        LocalDateTime nextYearLocalDateTime = date05.plusYears(2);

        System.out.println("pastYearLocalDateTime: " + pastYearLocalDateTime);
        System.out.println("nextYearLocalDateTime: " + nextYearLocalDateTime);

        Instant pastWeekInstant = date06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = date06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant: " + pastWeekInstant);
        System.out.println("nextWeekInstant: " + nextWeekInstant);

        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), date04.atStartOfDay());
        Duration t2 = Duration.between(pastYearLocalDateTime, date05);
        Duration t3 = Duration.between(date06, pastWeekInstant);
        System.out.println("t1: " + t1.toDays());
        System.out.println("t2: " + t2.toDays());
        System.out.println("t3: " + t3.toDays());

    }
}