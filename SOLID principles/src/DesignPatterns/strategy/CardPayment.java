package DesignPatterns.strategy;

public class CardPayment implements PaymentStrategy {
    public void pay(){
        System.out.println("Paid using card");
    }
}
