package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import universidadg6.modelo.Materia;


public class MateriaData {
    
    private Connection con;

    public MateriaData(Connection con) {
        this.con = con;
    }
    
    public void guardarMateria(Materia materia){
        String query = "INSERT INTO materias (nombre,anio,activo) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
            
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null, "Materia Agregada");

            } else {
                JOptionPane.showMessageDialog(null, "Materia No Agregada");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-AgregarMateria");
        }
    }
    
    public void borrarMateria(int id){
        String query = "UPDATE materias SET activo = 0 WHERE id_materia = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la materia");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BorrarMateria");
        }
    }
    
    public Materia buscarMateria(int id){
        Materia m = null;
        String query = "SELECT * FROM materias WHERE id_materia = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-BuscarMateria");
        }
        return m;
    }
    
    public void actualizarMateria(Materia m, int id){
        String query = "UPDATE materias SET nombre=?, anio=?, activo=? WHERE id_materia=?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isActivo());
            ps.setInt(4, id);
            
            if(ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null, "Materia actualizada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar la materia");
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Sentencia SQL errónea-ActualizarMateria");
        }
    }
    
    public ArrayList<Materia> obtenerMateria(){
        ArrayList<Materia> listaMateria = new ArrayList();
        String query = "SELECT * FROM materias WHERE activo=1";
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia m = new Materia();
                m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("activo"));
                listaMateria.add(m);
            }
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las materias");
        }
        return listaMateria;
    }
}
