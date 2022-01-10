package mx.uv.powerfultest.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Conexion conexion = new Conexion();

    public String insertarUsuario(Usuario u) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO usuario (nombre, apellido, correo, contraseña) VALUES (?, ?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, u.getNombre());
            prestm.setString(2, u.getApellido());
            prestm.setString(3, u.getCorreo());
            prestm.setString(4, u.getContraseña());
            if (prestm.executeUpdate() >0) 
                msj = "Usuario agregado";
            else
                msj = "No se agregó el usuario";
            
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

    public Usuario verificarUsuario(String correo){
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = conexion.getConnection();
        try{
            String sql = "SELECT * FROM usuarios WHERE correo = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, correo);
            rs = stm.executeQuery();

            while (rs.next()){
                Usuario u = new Usuario(rs.getString("nombre"), rs.getString("apellido"),  rs.getString("correo"), rs.getString("contraseña"));
                System.out.println(u.getNombre());
                return u;

            }
            return null;   
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //---------------------------------------------------------

    public List<Usuario> listadoUsuario() {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Usuario> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuario where email = ?";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Usuario u = new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("contraseña"));
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    stm = null;
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
}
