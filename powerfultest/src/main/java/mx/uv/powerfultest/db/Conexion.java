package mx.uv.powerfultest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    /*
    private String url = "jdbc:mysql://localhost/powerfultest";
    private String username = "root";
    private String password = "";
    private String driverName = "com.mysql.jdbc.Driver";
    private Connection conn = null;
    */
    
    private String url = "jdbc:mysql://db4free.net:3306/powerfultestalex?user=horushahc_bd&password=familia1231";

    private Connection conn = null;
    

    public Connection getConnection() {
        try {
            //Class.forName(driverName);
            //conn = DriverManager.getConnection(url, username, password);
            conn = DriverManager.getConnection(url);
            System.out.println("Se estableció la conexión!");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Falló la carga de la clase del JDBC");
        } /*catch (ClassNotFoundException e) {
            System.out.println("Falló la carga de la clase del JDBC");
            e.printStackTrace();
        }*/
        
        return conn;
    }
}
