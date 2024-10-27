package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    public static void openConnection(String dbURL, String username, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
        } catch (Exception e){
            System.out.println("Error occurred while connecting to DB, see details " +e);
        }
    }

    public static void closeConnection(){
        try {con.close();
    } catch (Exception e) {
            System.out.println("Error occurred while closing DB connection, see details " +e);
            }
        }

}
