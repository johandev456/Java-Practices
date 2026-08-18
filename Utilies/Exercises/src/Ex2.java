import java.util.Optional;
public class Ex2 {
    String phone;

    Ex2(String phone){
        this.phone=phone;
    }
    void phoneCheck(){
        Optional<String> optionalPhone = Optional.ofNullable(phone);
        if(optionalPhone.isPresent()){
            System.out.println(optionalPhone.get());
        }else{
            System.out.println("Phone not available");
        }
    }


}
