package DataBaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private String connectionUrl = "jdbc:sqlserver://192.168.0.142:1433;databaseName=PowerStation;user=sa;password=sarnath123!@#";
    private Connection connection = null;
    public ConnectionUtil(){

    }
    public ConnectionUtil(String connectionUrl){
        this.connectionUrl=connectionUrl;
    }
    public void ConnectToDataBase() {
        // Load SQL Server JDBC driver and establish connection.
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
            System.out.println("connection.close()");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public Connection getConnection() {
        return connection;
    }

}
