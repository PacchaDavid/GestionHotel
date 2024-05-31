import java.util.Scanner;
import java.time.LocalDate;

public class Huesped extends Persona{
    private String numeroTelefono;
    private TipoPago metodoPago;


    private Reservacion reservacion;
    private Recepcionista recepcionista;

    //Constructor
    public Huesped(){

    }

    public Huesped(String nombre, String dni, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = LocalDate.now().getYear()- fechaNacimiento.getYear(); 
    }

    public void agendarReservacion(){
        System.out.println("Reservación Agendada");
    }
    
    public void  agendarReservacion(Recepcionista recepcionista){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese A continuación los siguientes datos para agendar su reservacion:");
        System.out.println("Fecha de Inicio en formato yyyy-mm-dd");
        String fechaInicio = scan.nextLine();
        System.out.println("Fecha de Fin en formato yyyy-mm-dd");
        String fechaFin = scan.nextLine();
        int nReservacion = recepcionista.asignarNumeroReservacion();

        Reservacion reservacion = new Reservacion(LocalDate.parse(fechaInicio),LocalDate.parse(fechaFin),nReservacion);
        
        recepcionista.agendarReservacion(reservacion,this);
    }

    public void cancelarReservacion(){
        System.out.println("Reservación Cancelada");
    }
    public void ocuparReservacion(){
        System.out.println("Reservación en curso");
    }

    @Override
    public String toString(){
        return "nombre: " + this.nombre + "\n" + 
        "dni: " + this.dni + "\n" + "Fecha de Nacimiento: " + fechaNacimiento + "\n"
        + "Edad Actual: " + String.valueOf(edad) + " años";
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setTipoPago(TipoPago pago){
        this.metodoPago = pago;
    }
}
