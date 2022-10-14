
package universidadg6.modelo;

public class Materia {
    private int id_materia;
    private String nombre;
    private int anio;
    private boolean activo;

    public Materia() {
    }

    public Materia(int id_materia, String nombre, int anio, boolean activo) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.anio = anio;
        this.activo = activo;
    }

    public Materia(String nombre, int anio, boolean activo) {
        this.nombre = nombre;
        this.anio = anio;
        this.activo = activo;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
