package universidadg6;

import java.sql.Connection;

import persistencia.Conexion;
import persistencia.MateriaData;

import universidadg6.modelo.Materias;

public class UniversidadG6 {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        
        Materias mat = new Materias("Historia", 1, true);
        Materias mat2 = new Materias("Economia", 2, true);
        Materias mat3 = new Materias("Inglés", 1, false);
        Materias mat4 = new Materias("Naturales", 3, true);
        MateriaData mData = new MateriaData(con);
        mData.guardarMateria(mat);
        mData.guardarMateria(mat2);
        mData.guardarMateria(mat3);
        mData.guardarMateria(mat4);
    }
}
