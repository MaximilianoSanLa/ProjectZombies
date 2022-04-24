
public class Ubicacion
{  
    private String nombre;
    private float distanciaA;
    private int cantidadZ;

    public Ubicacion(String nombre, float distanciaA, int cantidadZ) {
        this.nombre = nombre;
        this.distanciaA = distanciaA;
        this.cantidadZ = cantidadZ;
    }

    public String getNombre() {
        return nombre;
    }

    public float getDistanciaA() {
        return distanciaA;
    }

    public int getCantidadZ() {
        return cantidadZ;
    }


}

