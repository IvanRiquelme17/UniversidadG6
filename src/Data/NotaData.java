package Data;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadg6.modelo.Alumno;
import universidadg6.modelo.Materia;
import universidadg6.modelo.Nota;

public class NotaData {

    private Connection con;
    private AlumnoData aData;
    private MateriaData mData;

    public NotaData() {
        this.con = Conexion.getConexion();
        this.aData = new AlumnoData(con);
        this.mData = new MateriaData(con);
    }


    public void guardarInscripcion(Nota i) {
        String query = "INSERT INTO nota (id_alumno, id_materia, notaAlumno) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, i.getAlumno().getId_alumno());
            ps.setInt(2, i.getMateria().getId_materia());
            ps.setDouble(3, i.getNotaAlumno());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción Agregada");

            } else {
                JOptionPane.showMessageDialog(null, "Inscripción No Agregada");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                i.setId_inscripcion(rs.getInt(1));

            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-AgregarInscripcion | " + e.getMessage());
        }
    }

    public Nota obtenerInscripcion(int idAlumno, int idMateria) {
        Nota i = null;
        String query = "SELECT * FROM nota WHERE id_alumno=? AND id_materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = new Nota();
                i.setId_inscripcion(rs.getInt("id_inscripcion"));
                i.setNotaAlumno(rs.getDouble("notaAlumno"));
                i.setAlumno(aData.buscarAlumno(rs.getInt("id_alumno")));
                i.setMateria(mData.buscarMateria(rs.getInt("id_materia")));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BuscarInscripción");
        }
        return i;
    }

    public void borrarInscripcion(int idAlumno, int idMateria) {
        String query = "DELETE FROM nota WHERE id_alumno=? AND id_materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción Eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la Inscripción");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BorrarInscripcion");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String query = "UPDATE nota SET notaAlumno=? WHERE id_alumno=? AND id_materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar la nota");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-ActualizarInscripcion");
        }
    }

    public ArrayList<Materia> obtenerMateriasInscriptas(int idAlumno) {
        String query = "SELECT m.id_materia, nombre, anio, activo FROM materias AS m, nota AS n WHERE n.id_materia = m.id_materia AND id_alumno = ?;";
        ArrayList<Materia> listaMateriasInscriptas = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("activo"));
                listaMateriasInscriptas.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las inscripciones del alumno");
        }
        return listaMateriasInscriptas;
    }

    public ArrayList<Alumno> obtenerAlumnosInscriptos(int idMateria) {
        String query = "SELECT a.id_alumno, dni, nombre, apellido, fechaNacimiento, activo FROM alumno AS a, nota AS n WHERE n.id_alumno = a.id_alumno AND id_materia = ?";
        ArrayList<Alumno> listaAlumnoInscriptos = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
                listaAlumnoInscriptos.add(a);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las inscripciones a la materia");
        }
        return listaAlumnoInscriptos;
    }

    public ArrayList<Materia> obtenerMateriasNoInscriptas(int idAlumno) {
        String query = "SELECT * FROM `materias` WHERE id_materia NOT IN (SELECT n.id_materia FROM nota AS n, materias AS m WHERE n.id_materia = m.id_materia AND id_alumno = ?) AND materias.activo = true;";
        ArrayList<Materia> listaMateriasNoInscriptas = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("activo"));
                listaMateriasNoInscriptas.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las inscripciones");
        }
        return listaMateriasNoInscriptas;
    }
}
