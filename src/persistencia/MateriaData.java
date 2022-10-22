/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public MateriaData(Connection conexion) {
        this.con = conexion;
    }

    public void guardarMateria(Materias m) {
        String query = "INSERT INTO materias(nombre, anio, activo) VALUES(?,?,?)"; //ARMO QUERY
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); //PREPARO STATEMENT
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isActivo());
            ps.executeUpdate(); //EJECUTO

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                m.setId_materia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia agregada: "+m.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo tener ID");
            }
            ps.close(); //CERRAR CONEXION 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la materia");
        }
    }

    public Materias buscarMateria(int id) {
        Materias m = null;
        String sql = "SELECT * FROM materias WHERE id_materia=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {  // ARMO UN OBJETO
                m = new Materias(); // 4.INSTANCIAR EL OBJETO
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("activo"));
            }
            ps.close(); // 5. CERRAR LA CONEXION
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la materia");
        }
        return m;
    }

    public ArrayList<Materias> listaMateria() {
        ArrayList<Materias> listaMat = new ArrayList();
        String sql = "SELECT * FROM materias WHERE activo=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materias m = new Materias();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("activo"));

                listaMat.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener todos los alumnos");
        }
        return listaMat;
    }

    public void borrarAlumno(int id) {
        //String query = "DELETE FROM alumno WHERE id_alumno = ?";
        String query = "UPDATE materias SET activo = 0 WHERE id_materia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la materia");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BorrarMateria");
        }
    }

    public void actualizarAlumno(Materias m) {
        String query = "UPDATE materias set nombre=?, anio=? where id_materia=?";  //1
        try {
            PreparedStatement ps = con.prepareStatement(query);//2
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setInt(3, m.getId_materia());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Los  datos de la materia se han actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Los  datos de la materia no se han actualizado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha  podido actualizar la materia");
        }
    }

}
