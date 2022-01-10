package mx.uv.powerfultest.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

public class DAOdato {
    private Conexion conexion = new Conexion();

    public String insertarDato(Dato d) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO dato (titulo, descripcion) VALUES (?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, d.getTitulo());
            prestm.setString(2, d.getDescripcion());
            if (prestm.executeUpdate() >0) 
                msj = "Tarea agregada";
            else
                msj = "La tarea no se agregó";
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestm != null){
                try {
                    prestm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msj;
    }
    //---------------------------------------------------------
}
