package DesignPatterns.strategy;

public class UPIPayment implements PaymentStrategy {
    public void pay(){
        System.out.println("Paid using UPI");
    }
}
