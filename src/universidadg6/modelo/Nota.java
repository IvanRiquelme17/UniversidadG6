
package universidadg6.modelo;

public class Nota {
    private int id_inscripcion;
    private Alumno alumno;
    private Materia materia;
    private double notaAlumno;

    public Nota() {
    }

    public Nota(int id_inscripcion, Alumno alumno, Materia materia, double notaAlumno) {
        this.id_inscripcion = id_inscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.notaAlumno = notaAlumno;
    }

    public Nota(Alumno alumno, Materia materia, double notaAlumno) {
        this.alumno = alumno;
        this.materia = materia;
        this.notaAlumno = notaAlumno;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNotaAlumno() {
        return notaAlumno;
    }

    public void setNotaAlumno(double notaAlumno) {
        this.notaAlumno = notaAlumno;
    }

    @Override
    public String toString() {
        return "Nota{" + "id_inscripcion=" + id_inscripcion + ", alumno=" + alumno + ", materia=" + materia + ", notaAlumno=" + notaAlumno + '}';
    }
    
   
}
