package DesignPatterns.strategy;

public class StrategyDemo {
    public static void main(){
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CardPayment());
        context.executePayment();

        context.setStrategy(new UPIPayment());
        context.executePayment();
    }
}
