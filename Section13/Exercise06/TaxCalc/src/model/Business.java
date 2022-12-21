package model;

public class Business extends TaxPayer{

    private Integer employeesAmount;

    public Business() {
        super();
    }

    public Business(String name, double annualIncome, Integer employeesAmount) {
        super(name, annualIncome);
        this.employeesAmount = employeesAmount;
    }

    public Integer getEmployeesAmount() {
        return employeesAmount;
    }

    public void setEmployeesAmount(Integer employeesAmount) {
        this.employeesAmount = employeesAmount;
    }

    @Override
    public double calculateTax(){

        double taxToPay = 0;
        double annualIncome = super.getAnnualIncome();

        if (employeesAmount < 10) {
            taxToPay += annualIncome * 0.16;
        } else {
            taxToPay += annualIncome * 0.14;
        }

        return taxToPay;
    }
}
