import java.time.*;
import java.time.format.DateTimeFormatter;

public class Ex1 {
    LocalDate today;
    String formattedDate;

    Ex1(){
        today= LocalDate.now();
    }

    public void todayDate(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formattedDate= today.format(formatter);
        System.out.println(formattedDate);
    }


}
