package universidadg6;

import Data.AlumnoData;
import Data.Conexion;
import Data.MateriaData;
import Data.NotaData;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import universidadg6.modelo.Alumno;
import universidadg6.modelo.Materia;
import universidadg6.modelo.Nota;

public class UniversidadG6 {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        MateriaData mData = new MateriaData(con);
        AlumnoData aData = new AlumnoData(con);
        NotaData iData = new NotaData();

        //PRUEBA CLASE ALUMNO DATA
        Alumno x = new Alumno(43333987, "Lopez", "Igor", LocalDate.now(), true);
        Alumno auxA = new Alumno(43124987, "Chavez", "Jorgito", LocalDate.now(), true);
        /*        aData.guardarAlumno(x);
        System.out.println(aData.buscarAlumno(2));
        aData.actualizarAlumno(auxA, 1);
        for (Alumno aux : aData.obtenerAlumnos()) {
            System.out.println(aux.toString());
        }
        aData.borrarAlumno(2);
         */
        //PRUEBA CLASE MATERIA DATA
        Materia m1 = new Materia("Inglés", 1, true);
        /*        Materia auxM = new Materia("Historia", 2, true);
        mData.guardarMateria(m1);
        System.out.println(mData.buscarMateria(2));
        mData.actualizarMateria(auxM, 5);
        for (Materia aux : mData.obtenerMateria()) {
            System.out.println(aux.toString());
        }
        mData.borrarMateria(2);
         */
 /*        //PRUEBA CLASE INSCRIPCION DATA :(
        x=aData.buscarAlumno(17);
        m1=mData.buscarMateria(1);
        Nota notaX = new Nota(x, m1, 0);
        iData.actualizarNota(3, 4, 10);
        for (Materia aux : iData.obtenerMateriasInscriptas(2)) {
            System.out.println(aux.toString());
        }
        System.out.println(iData.obtenerInscripcion(2, 1));
        for (Alumno aux : iData.obtenerAlumnosInscriptos(1)) {
            System.out.println(aux.toString());
        }
         */
    }
}
