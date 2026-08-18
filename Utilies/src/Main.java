import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main{
    public static void main(String[] args){

        LocalDate today = LocalDate.now();
        System.out.println("Today's date: "+today);

        LocalDate specificDate = LocalDate.of(2025,12,25);
        System.out.println("Specific date: "+specificDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Current time: "+currentTime );

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: "+currentDateTime);

        System.out.println("Year: "+today.getYear());
        System.out.println("Month: "+today.getMonth());
        System.out.println("Day: "+today.getDayOfMonth());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);
        System.out.println(formattedDate);

    }
}