/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadg6.modelo.Materias;

/**
 *
 * @author Ivan
 */
public class MateriaData {

    private Connection con = null;

    public MateriaData(Conexion conexion) {
        this.con = conexion.getConexion();
    }

    public void guardarMateria(Materias m) {
        String query = "INSERT INTO `materias`(`nombre`, `anio`, `activo`) VALUES(?,?,?)"; //ARMO QUERY
        try {
            PreparedStatement ps = con.prepareStatement(query); //PREPARO STATEMENT
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isActivo());
            ps.executeUpdate(); //EJECUTO

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                m.setId_materia(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo tener ID");
            }
            ps.close(); //CERRAR CONEXION 
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
