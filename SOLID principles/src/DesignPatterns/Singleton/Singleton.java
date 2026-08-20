package DesignPatterns.Singleton;

public class Singleton {
    private static Singleton instace;

    private  Singleton(){} // Esto evita que otras clases creen su propia instancia

    public static Singleton getInstance(){ //Basicamente retorna la instancia, si no existe crea una, esto siempre retornara la misma instancia.
        if(instace==null){
            instace=new Singleton();
        }
        return instace;
    }
}
