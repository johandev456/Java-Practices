import java.util.Optional;

public class Ex3 {
    String user;

    Ex3(String user){
        this.user=user;
    }
    void phoneCheck() throws Exception {
        Optional<String> optionalPhone = Optional.ofNullable(user);
        if(optionalPhone.isPresent()){
            System.out.println(optionalPhone.get());
        }else{

            System.out.println("user not available");
            throw new Exception("Invalidad user");
        }
    }


}

