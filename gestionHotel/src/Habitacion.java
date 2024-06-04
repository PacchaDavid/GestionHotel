

public class Habitacion{
    private String codigo;
    private TipoHabitacion tipo;
    private EstadoHabitacion estado;

    //Constructor
    public Habitacion(String codigo, TipoHabitacion tipo){
        this.codigo = codigo;
        this.tipo = tipo;
        this.estado = EstadoHabitacion.LIBRE;
    }

    public void setEstado(EstadoHabitacion estado){
        this.estado = estado;
    }

    public EstadoHabitacion getEstado(){
        return this.estado;
    }

    public TipoHabitacion getTipo(){
        return this.tipo;
    }

    public String getCodigo(){
        return this.codigo;
    }

    @Override
    public String toString(){
        return "codigo: " + this.codigo + "\n" +
        "tipo: " + this.tipo;
    }
}