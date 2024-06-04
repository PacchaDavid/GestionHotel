import java.time.LocalDate;

public class Reservacion {
    private int numero;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int existe;

    private Habitacion habitacion;
    private Huesped huesped;
    private EstadoReservacion estado;

    //Constructor
    public Reservacion(){
        this.existe = 0;
    }
    public Reservacion(LocalDate fechaInicio, LocalDate fechaFin, int numero){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numero = numero;
    }
    
    public void setHuesped(Huesped huesped){
        this.huesped = huesped;
    }
    public void setEstado(EstadoReservacion estado){
        this.estado = estado;
    }
    public void setHabitacion(Habitacion habitacion){
        this.habitacion = habitacion;
    }

    public LocalDate getFechaInicio(){
        return this.fechaInicio;
    }

    public int getExiste(){
        return this.existe;
    }
    public void setExiste(int existe){
        this.existe = existe;
    }


    @Override
    public String toString(){
        return "Reservacion " + String.valueOf(this.numero) + "\n"
        + "Fecha de inicio: " + fechaInicio + "\n" +
        "Fecha de finalizacion: " + fechaFin + "\n"+
        "Estado: " + this.estado + "\n" +
        "Habitacion: " + this.habitacion.getCodigo() + "\n" +
        "Huesped: " + this.huesped.getNombre();
        

    }
}
