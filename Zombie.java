
public class Zombie
{
    private String nombre;
    private int salud;
    private String fechaNacimiento;
    private String tipoSangre;

    public Zombie(String nombre, int salud, String fechaNacimiento, String tipoSangre) {
        this.nombre = nombre;
        this.salud = salud;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }
}
