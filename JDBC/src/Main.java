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
            connection.setAutoCommit(false); //The changes will not be saved until we explictly commit them!
            System.out.println("Connected to the database successfully!");

            Statement stmt = connection.createStatement();

            //Create statement
//            String insertQuery = "INSERT INTO tag(id,nombre) values (20,'pruebaJava')";
//            stmt.executeUpdate(insertQuery);

            //Prepared statements CREATE
            String insertSQL = "INSERT INTO tag(id,nombre) values (?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insertSQL);
            pstmt.setInt(1,5);
            pstmt.setString(2,"john");
            pstmt.executeUpdate();
            System.out.println("Read!");

            //Prepared statements READ
            String readSQL = "SELECT * FROM TAG";
            PreparedStatement pstmtSelect = connection.prepareStatement(readSQL);
            ResultSet rs = pstmtSelect.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
            }
            //Prepared statements UPDATE
            String updateSQL = "update tag set nombre=? where id=?";
            PreparedStatement pstmtUpdate = connection.prepareStatement(updateSQL);
            pstmtUpdate.setString(1,"john1");
            pstmtUpdate.setInt(2,1);

            pstmtUpdate.executeUpdate();
            System.out.println("Updated!");

            //Prepared statements DELETED
            String deleteSQL = "delete from tag where id=?";
            PreparedStatement pstmtDelete = connection.prepareStatement(deleteSQL);
            pstmtDelete.setInt(1,20);

            pstmtDelete.executeUpdate();
            System.out.println("deleted");

            //Read statement
//            String readQuery="SELECT * FROM tag";
//            ResultSet rs = stmt.executeQuery(readQuery);

//            while(rs.next()){
//                System.out.println(rs.getString("nombre"));
//            }
//
            //Update statement
//            String updateQuery ="update tag set nombre='javaDameChamba' where id=20";
//            stmt.executeUpdate(updateQuery);


            //Delete statement
//            String deleteQuery ="delete from tag where id=20";
//            stmt.executeUpdate(deleteQuery);
        }catch (SQLException e){
            System.out.println("Connection failed!");
            e.printStackTrace();


        }
    }
}