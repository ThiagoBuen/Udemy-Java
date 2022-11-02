package model;

public class CurrencyConverter {

    public static double IOF = 0.06;

    public static double exchangeConverter(double exchangeRate){
        return exchangeRate * (1+IOF);
    }
}
