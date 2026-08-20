package DesignPatterns.Singleton;

public class SingletonDemo{
    void main(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1==s2); //Confirma que sigue siendo la misma instancia.
    }
}
