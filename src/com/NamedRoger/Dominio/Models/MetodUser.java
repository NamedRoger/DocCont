package src.com.NamedRoger.Dominio.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MetodUser {

    Pool conexion;

    public MetodUser() {
        conexion = new Pool();
    }

    public ArrayList<Usuario> login(String user, String pass) {
        Connection conectar = null;
        PreparedStatement pst;
        ResultSet rs;
        Usuario usuario;
        ArrayList list = new ArrayList();

        try {
            conectar = conexion.dataSource.getConnection();

            if (conectar!=null){

                String sql = "Select User, Pass Prom usuarios Where User=? And Pass=AES_ENCRYPT(?, 'key')";

                pst = conectar.prepareStatement(sql);
                pst.setString(1, user);
                pst.setString(2, pass);

                rs= pst.executeQuery();

                while (rs.next()) {

                    usuario= new Usuario();
                    usuario.setUserName(rs.getString("User"));
                    usuario.setPassword(rs.getString("Pass"));

                    list.add(usuario);

                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conectar.close();
            } catch (SQLException ex){}
        }

        return list;
    }
}