import java.util.Scanner;

public class Recepcionista extends Persona{
    private String id;

    private RegistroGlobal registro = new RegistroGlobal();    


    //Constructor
    public Recepcionista(){
        
    }
    public Recepcionista(String nombre, String dni, String id){
        this.nombre = nombre;
        this.dni = dni;
        this.id = id;
    }

    public void agendarReservacion(){
        System.out.println("Agendando Reservación");
    }
    public int asignarNumeroReservacion(){
        int nReservacion = 0;
        for(int i = 0; i<19; i++){
            if(registro.getReservacionList()[i].getExiste() == 0){
                nReservacion = i+1;
                break;
            }
        }
        System.out.println(this.nombre + " asignó el número " + nReservacion + " para su reservacion");
        return nReservacion;
    }

    public void agendarReservacion(Reservacion reservacion, Huesped huesped){
        reservacion.setEstado(EstadoReservacion.PROGRAMADA);
        reservacion.setHuesped(huesped);
        reservacion.setHabitacion(this.registro.verificarHabitacionLibre(this.obtenerTipoHabitacion()));
        this.registro.agregarReservacion(reservacion);
    }

    public TipoHabitacion obtenerTipoHabitacion(){
        Scanner sca = new Scanner(System.in);
        System.out.println("Ingrese el tipo de Habitacion en MAYUSCULAS");
        System.out.println("Ej:(NORMAL, DOBLE, SUITE, NUPCIAL, PRESIDENCIAL)");
        String tipoH = sca.nextLine();
        
        switch(tipoH){
            case "NORMAL":
                return TipoHabitacion.NORMAL;
            case "DOBLE":
                return TipoHabitacion.DOBLE;
            case "SUITE":
                return TipoHabitacion.SUITE;
            case "NUPCIAL":
                return TipoHabitacion.NUPCIAL;
            case "PRESIDENCIAL":
                return TipoHabitacion.PRESIDENCIAL;
            default:
                System.out.println("Habitación mal ingresada, que pendejo");
                break;
        }
        return null;
    }
    
    public void cancelarReservacion(){
        System.out.println("Cancelar Reservacion");
    }
    public void ocuparReservacion(){
        System.out.println("Reservando");
    }

    public RegistroGlobal getRegistro(){
        return this.registro;
    }

    @Override
    public String toString(){
        return "nombre: " + this.nombre + "\n" +
        "dni: " + this.dni + "\n" +
        "ID de empleado: " + id;
    }
}