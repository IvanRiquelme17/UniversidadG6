
package universidadg6;

import Data.AlumnoData;
import Data.Conexion;
import java.sql.Connection;
import java.time.LocalDate;
import universidadg6.modelo.Alumno;

public class UniversidadG6 {

    public static void main(String[] args) {
        Connection con=Conexion.getConexion();
        Alumno martin = new Alumno(43490178, "Rastrilla", "Martin", LocalDate.now(), true);
        Alumno mariano = new Alumno(43001999, "Gutierrez", "Mariano", LocalDate.now(), true);
        Alumno mariano2 = new Alumno(43001999, "Gutierres", "Mariano", LocalDate.now(), true);
        AlumnoData aData = new AlumnoData(con);
        aData.actualizarAlumno(mariano2);
        
    }
}
