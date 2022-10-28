package Data;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import universidadg6.modelo.Alumno;
import universidadg6.modelo.Materia;
import universidadg6.modelo.Nota;

public class NotaData {

    private Connection con;
    private AlumnoData aData;
    private MateriaData mData;

    public NotaData(Connection con) {
        this.con = con;
    }

    
    
    public NotaData(Connection con, AlumnoData aData, MateriaData mData) {
        this.con = con;
        this.aData = aData;
        this.mData = mData;
    }

    

    private Alumno regenerarAlumno(int id) {
        //Permite reestructurar un objeto Alumno desde un id
        AlumnoData aData = new AlumnoData(con);
        return aData.buscarAlumno(id);
    }

    private Materia regenerarMateria(int id) {
        //Permite reestructurar un objeto Alumno desde un id
        MateriaData mData = new MateriaData(con);
        return mData.buscarMateria(id);
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
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-AgregarInscripcion");
        }
    }

    public Nota obtenerInscripcion(int idAlumno, int idMateria) {
        Nota i = null;
        NotaData aux = null;
        String query = "SELECT * FROM nota WHERE id_alumno=? AND id_materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i = new Nota();
                aux = new NotaData(con);
                i.setAlumno(aux.regenerarAlumno(idAlumno));
                i.getAlumno();
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BuscarInscripción");
        }
        return i;
    }

    
}
