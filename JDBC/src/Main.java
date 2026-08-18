import java.sql.Connection; //Connection to the database
import java.sql.DriverManager; //Resposible for establishing that connection
import java.sql.SQLException; //Handles database errors
import java.sql.*;

public class Main {
    public static void main(){

        String url = "jdbc:postgresql://localhost:5432/dominus_db";
        String username="postgres";
        String password="alex01";

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the database successfully!");

            Statement stmt = connection.createStatement();

            //Create statement
//            String insertQuery = "INSERT INTO tag(id,nombre) values (20,'pruebaJava')";
//            stmt.executeUpdate(insertQuery);

            //Read statement
            String readQuery="SELECT * FROM tag";
            ResultSet rs = stmt.executeQuery(readQuery);

            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
//
            //Update statement
//            String updateQuery ="update tag set nombre='javaDameChamba' where id=20";
//            stmt.executeUpdate(updateQuery);


            //Delete statement
            String deleteQuery ="delete from tag where id=20";
            stmt.executeUpdate(deleteQuery);
        }catch (SQLException e){
            System.out.println("Connection failed!");
            e.printStackTrace();


        }
    }
}