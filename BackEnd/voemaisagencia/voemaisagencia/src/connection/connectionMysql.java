package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionMysql {
    public static Connection createConnectionMysql() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voemaisagenciaDB?user=root&password=mysql2501");

        return connection;
    }

    public static void main(String[] args) throws Exception {

        Connection conn = createConnectionMysql();
        if(conn != null){
            System.out.println(conn + "\nConexao bem sucedida\n");
            conn.close();
        }
    }
}
