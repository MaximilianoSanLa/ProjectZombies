public class Pruebas
{
    public void test01(){
        Principal test=new Principal();
        test.crearZ();
        System.out.println("Prueba 1 pasada.(test01)");
        test.zombieLista();
        System.out.println("Prueba 2 pasada.(test01)");
        test.filtrarSangre();
        System.out.println("Prueba 3 pasada.(test01)");
        test.filtrarFecha();
        System.out.println("Prueba 4 pasada.(test01)");
        test.dividirSalud();
        System.out.println("Prueba 5 pasada.(test01)");
    }
    public void test02(){
        Principal test=new Principal();
        test.crearU();
        System.out.println("Prueba 1 pasada.(test02)");
        test.printUbicaciones();
        System.out.println("Prueba 2 pasada.(test02)");
        test.ubicacionMasSegura();
        System.out.println("Prueba 3 pasada.(test02)");
        test.ubicacionCercana();
        System.out.println("Prueba 4 pasada.(test02)");
        test.fraseRandom();
        System.out.println("Prueba 5 pasada.(test02)");
        test.clear();
        System.out.println("Prueba 6 pasada.(test02)");
    }
}
