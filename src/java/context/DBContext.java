/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author admin
 */
public class DBContext {
        public static Connection makeConnection() throws Exception {
        Connection cn = null;
        String IP = "localhost";
        String instanceName = "KDICHIGO";
        String port = "1433";
        String uid = "sa";
        String pwd = "sa";
        String db = "SWP391_QSP04";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
                + ";databasename=" + db + ";user=" + uid + ";password=" + pwd;
        Class.forName(driver);
        cn = DriverManager.getConnection(url);
        return cn;
    }

    public static void main(String[] args) throws Exception {
        Connection con = DBContext.makeConnection();
        if (con != null) {
            System.out.println("ok");
        } else {
            System.out.println("fail");
        }
    }
}
