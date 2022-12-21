package model;

public class Citizen extends TaxPayer{

    private double healthCosts;

    public Citizen() {
        super();
    }

    public Citizen(String name, double annualIncome, double healthCosts) {
        super(name, annualIncome);
        this.healthCosts = healthCosts;
    }

    public double getHealthCosts() {
        return healthCosts;
    }

    public void setHealthCosts(double healthCosts) {
        this.healthCosts = healthCosts;
    }

    @Override
    public double calculateTax(){

        double taxToPay = 0.0;
        double annualIncome = super.getAnnualIncome();

        if (annualIncome < 20000) {
            taxToPay += annualIncome * 0.15;
        } else {
            taxToPay += annualIncome * 0.25;
        }

        taxToPay -= healthCosts * 0.5;

        return taxToPay;
    }
}
