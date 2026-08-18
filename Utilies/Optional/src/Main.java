import java.util.Optional;

public class Main{
    public static void main(){

        String email = null;
        System.out.println(email);

        Optional<String> optionalEmail = Optional.ofNullable(email);
        if(optionalEmail.isPresent()){
            System.out.println(optionalEmail.get());
        }else{
            System.out.println("Email not available");
        }

    }
}