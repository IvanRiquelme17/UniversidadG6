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
import universidadg6.modelo.Alumno;

/**
 *
 * @author Ivan
 */
public class AlumnoData {

    private Connection con;

    public AlumnoData(Connection con) {
        this.con = con;
    }

    public void guardarAlumno(Alumno a) {        // ESTO ES UN INSERT 
        String query = "INSERT INTO alumno(dni,nombre,apellido,fechaNacimiento,activo) VALUES (?,?,?,?,?)";                       // ARMO LA QUERY
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // PREPARO EL STATEMENT
            ps.setLong(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setDate(4, Date.valueOf(a.getFechaNacimiento()));
            ps.setBoolean(5, a.isActivo());
            ps.executeUpdate(); // EJECUTO

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                a.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno agregado: "+a.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo tener ID");
            }
            ps.close(); // CERRAR LA CONEXION 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-AgregarAlumno");
        }
    }

    public Alumno buscarAlumno(int id) {    // ESTO ES UN SELECT DE UN ALUMNO
        Alumno a = null; // DEFINIR UN OBJETO 
        String sql = "SELECT * FROM alumno WHERE id_alumno=?"; // 1.ARMO LA QUERY
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql); // 2.PREPARO EL STATEMENT
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); //3.EJECUTO 
            while (rs.next()) {  // ARMO UN OBJETO
                a = new Alumno(); // 4.INSTANCIAR EL OBJETO
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
            }
            ps.close(); // 5. CERRAR LA CONEXION
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public ArrayList<Alumno> listaAlumnos() {
        ArrayList<Alumno> listaAlum = new ArrayList();
        String sql = "SELECT * FROM alumno WHERE activo=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getLong("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));

                listaAlum.add(a);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener todos los alumnos");
        }
        return listaAlum;
    }

    public void borrarAlumno(int id) {
        //String query = "DELETE FROM alumno WHERE id_alumno = ?";
        String query = "UPDATE alumno SET activo = 0 WHERE id_alumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el alumno");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BorrarAlumno");
        }
    }

    public void actualizarAlumno(Alumno a) {
        String query = "UPDATE alumno set dni=?, nombre=?, apellido=?, fechaNacimiento=? where id_alumno=?";  //1
        try {
            PreparedStatement ps = con.prepareStatement(query);//2
            ps.setLong(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setDate(4, Date.valueOf(a.getFechaNacimiento()));

            ps.setInt(5, a.getId_alumno());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Los  datos del alumno se han actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Los  datos del alumno no se han actualizado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha  podido actualizar al alumno");
        }
    }

}
