/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import universidadg6.modelo.Alumno;

public class AlumnoData {

    private Connection con;

    public AlumnoData(Connection con) {
        this.con = con;
    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni,apellido,nombre,fechaNacimiento,activo) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isActivo());
//          ps.executeUpdate();INSERT UPDATE DELETE
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alumno Agregado");

            } else {
                JOptionPane.showMessageDialog(null, "Alumno No Agregado");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-AgregarAlumno");
        }
    }

    public Alumno buscarAlumno(int id) {    // ESTO ES UN SELECT DE UN ALUMNO
        Alumno a = null; // DEFINIR UN OBJETO 
        String sql = "SELECT *FROM alumno WHERE id_alumno=?"; // 1.ARMO LA QUERY
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql); // 2.PREPARO EL STATEMENT
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); //3.EJECUTO 
            while (rs.next()) {  // ARMO UN OBJETO
                a = new Alumno(); // 4.INSTANCIAR EL OBJETO
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getLong("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
            }
            ps.close(); // 5. CERRAR LA CONEXION
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BuscarAlumno");
        }
        return a;
    }

    public void actualizarAlumno(Alumno a, int id) {
        String query = "UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaNacimiento=? WHERE id_alumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(a.getFechaNacimiento()));
            ps.setInt(5, id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alumno actualizado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar el alumnno");
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-ActualizarAlumno ");
        }
    }

    public ArrayList<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList();
        String query = "SELECT * FROM alumno WHERE activo=1";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getLong("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));

                listaAlumnos.add(a);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener a los alumnos");
        }
        return listaAlumnos;
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
}
