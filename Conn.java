
package registrationformproject;

import java.sql.PreparedStatement;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root",
                    "itstudent");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
