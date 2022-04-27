import java.util.*;
import java.util.ArrayList;
import java.util.Random;
public class Principal
{
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    ArrayList<Ubicacion> ubicaciones= new ArrayList<Ubicacion>();
    String frases[]= {"Zombie muerto.","Rawr","Me mordió!!","Estampida de zombies corran!","Una pobre mente desperdiciada en un zombie denuevo."};
    Scanner cs = new Scanner(System.in);
    Random random = new Random();
    public static void main(String[]args){
        new Principal().mostrarMenu();
    }
    private void mostrarMenu(){
      while(true){
          System.out.println("\nIngrese un numero de acuerdo a lo que necesita \n0: Detener el programa. \n1: Almacenar Zombie un zombie en la base de datos. \n2: Informacion de los zombies registrados en la base de datos. \n3: Cantidad de zombies registrados. \n4: Informacion de los zombies con sangre O+ o AB+ \n5: Informacion de los zombies que nacieron despues del 2000 \n6: Disminuye a la mitad la salud de todos los zombies \n7: Ingresar una ubicacion. \n8: Revisar todas las ubicaciones en el registro. \n9: Ubicacion mas segura. \n10: Ubicaciones de la mas cercana a la mas lejana. \n11: Frase aleatoria. \n12: Borrar todos los zombies ingresados y todas la ubicaciones ingresadas. \n");
          int opcion= cs.nextInt();
          if(opcion==0){
              break;
          }
          switch(opcion){
            case 1:
            crearZ();
            break;
            
            case 2:
            zombieLista();
            break;
            
            case 3:
            System.out.println(zombies.size());    
            break;
            
            case 4:
            filtrarSangre();
            break;
            
            case 5:
            filtrarFecha();
            break;
            
            case 6:
            dividirSalud();
            break;
            
            case 7:
            crearU();
            break;
            
            case 8:
            printUbicaciones();
            break;
             
            case 9:
            ubicacionMasSegura();
            break;
            
            case 10:
            ubicacionCercana();
            break;
            
            case 11:
            fraseRandom();
            break;
            
            case 12:
            clear();
            break;
          }
      }
    }
    public void printUbicaciones(){
        for(int i=0;i<ubicaciones.size();i++){
            System.out.println("El nombre de la ubicacion es: "+ubicaciones.get(i).getNombre()+" La distancia a Alexandria es: "+ubicaciones.get(i).getDistanciaA()+"m La cantidad de zombies en la ubicacion es: "+ ubicaciones.get(i).getCantidadZ());
            }
    }
    public void crearZ(){
        System.out.println("Ingresa nombre del zombie");
        String nombreZ= cs.next();
        System.out.println("Ingresa salud del zombie.");
        int salud= cs.nextInt();
        System.out.println("Ingresa la fecha de naciemiento del zombie en el siguiente formato (Dia/Mes/Año). Ejemplo 01/02/1920");
        String fechaNacimiento= cs.next();
        System.out.println("Ingresa tipo de sangre.");
        String tipoSangre= cs.next();
        zombies.add(new Zombie(nombreZ,salud,fechaNacimiento,tipoSangre));
    }
    public void crearU(){
        System.out.println("Ingrese nombre de la ubicacion.");
        String nombreU= cs.next();
        System.out.println("Ingrese distancia a Alexandria en metros.");
        float distanciaA= cs.nextFloat();
        System.out.println("Cantidad de zombies en la ubicacion");
        int cantidadZ= cs.nextInt();
        ubicaciones.add(new Ubicacion(nombreU,distanciaA,cantidadZ));    
    }
    public void ubicacionMasSegura(){
        boolean repeticion =false;
        for(int i=0;i<ubicaciones.size();i++){
            for(int j=0;j< ubicaciones.size();i++){
                if(ubicaciones.get(i).getCantidadZ()>ubicaciones.get(i).getCantidadZ()){
                    repeticion=true;
                }
            }
            if(repeticion==false){
                    System.out.println("Una de las ubicaciones mas segura es: \nEl nombre de la ubicacion es: "+ubicaciones.get(i).getNombre()+" La distancia a Alexandria es: "+ubicaciones.get(i).getDistanciaA()+"m La cantidad de zombies en la ubicacion es: "+ ubicaciones.get(i).getCantidadZ());
            }
            repeticion=false;
        }
    }
    public void ubicacionCercana(){
        int p=0;
        Ubicacion []ubicaciones2= new Ubicacion [ubicaciones.size()];
        for(int i=0;i<ubicaciones.size();i++){
            for(int j=0;j<ubicaciones.size();j++){
                if(ubicaciones.get(i).getDistanciaA()>ubicaciones.get(j).getDistanciaA()){
                     p++;   
                }else if((ubicaciones.get(i).getDistanciaA()>=ubicaciones.get(j).getDistanciaA())){
                    if(((ubicaciones.get(i).getCantidadZ())>(ubicaciones.get(j).getCantidadZ() ))){
                    p++;
                }
                }
            }
            ubicaciones2[p]=ubicaciones.get(i);
            p=0;
        }
        System.out.println("Las ubicaciones de la mas cercana a la mas lejana son:");
        for(int i=0;i<ubicaciones.size();i++){
            if(ubicaciones2[i]!=null){
            System.out.println("El nombre de la ubicacion es: "+ubicaciones2[i].getNombre()+" La distancia a Alexandria es: "+ubicaciones2[i].getDistanciaA()+"m La cantidad de zombies en la ubicacion es: "+ ubicaciones2[i].getCantidadZ());
        }
        }
    }
    public void zombieLista(){
        for(int i=0; i<zombies.size();i++){
                System.out.println("Nombre del zombie: "+zombies.get(i).getNombre()+" Salud del zombie: "+zombies.get(i).getSalud()+" La fecha de nacimiento del zombie es: "+zombies.get(i).getFechaNacimiento()+" El tipo de sangre del zombie es: "+zombies.get(i).getTipoSangre());
            }
    }
    public void fraseRandom(){
        System.out.println(frases[random.nextInt(5)]);
    }
    public void clear(){
        for(int i=0; i<ubicaciones.size();i++){
                ubicaciones.remove(ubicaciones.get(i));
            }
        for(int i=0; i<zombies.size();i++){
                zombies.remove(zombies.get(i));
            }    
    }
    public void dividirSalud(){
        for(int i=0;i<zombies.size();i++){
            zombies.get(i).setSalud((zombies.get(i).getSalud())/2);
        }
    }
    public void filtrarFecha(){
        for(int i=0;i<zombies.size();i++){    
            if(2000<Integer.parseInt(zombies.get(i).getFechaNacimiento().substring(6,zombies.get(i).getFechaNacimiento().length()))){
                System.out.println("Nombre del zombie: "+zombies.get(i).getNombre()+" Salud del zombie: "+zombies.get(i).getSalud()+" La fecha de nacimiento del zombie es: "+zombies.get(i).getFechaNacimiento()+" El tipo de sangre del zombie es: "+zombies.get(i).getTipoSangre());
            }
        }
    }
    public void filtrarSangre(){
        for(int i =0;i<zombies.size();i++){
            if((zombies.get(i).getTipoSangre().equals("AB+"))||(zombies.get(i).getTipoSangre().equals("O+"))){
                System.out.println("Nombre del zombie: "+zombies.get(i).getNombre()+" Salud del zombie: "+zombies.get(i).getSalud()+" La fecha de nacimiento del zombie es: "+zombies.get(i).getFechaNacimiento()+" El tipo de sangre del zombie es: "+zombies.get(i).getTipoSangre());    
            }
        }
    }
}
