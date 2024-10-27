package extensions;

import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {
    //@Step("Get customer's info and message")
    public static List<String> getCustomerMessage(String query){
        List<String> customerMessage = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            customerMessage.add(rs.getString(1));
            customerMessage.add(rs.getString(2));
            customerMessage.add(rs.getString(3));
            customerMessage.add(rs.getString(4));
        } catch (Exception e) {
            System.out.println("Error occurred while printing table data, see details " +e);
        }
        return customerMessage;

    }
}
