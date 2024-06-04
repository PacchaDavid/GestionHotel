
public class RegistroGlobal {
    public static int nEmpleados;
    public static int habitacionesTotales = 20;
    private int habitacionesDisponibles;
    private int habitacionesOcupadas;
    private int habitacionesReservadas;

    private RegistroHuespedes registroHupespedes;
    private Habitacion[] habitacionList = new Habitacion[19];
    private Reservacion[] reservacionList = new Reservacion[19];

    
    public RegistroGlobal(){
        for(int i = 0; i < 4; i++){
            String codigo =  String.valueOf(i+1);
            codigo += "-0-A";
            this.habitacionList[i] = new Habitacion(codigo,TipoHabitacion.NORMAL);
        }
        for(int i = 4; i<8;i++){
            String codigo =  String.valueOf(i+1);
            codigo += "-1-A";
            this.habitacionList[i] = new Habitacion(codigo,TipoHabitacion.DOBLE);
        }
        for(int i = 8; i<13;i++){
            String codigo =  String.valueOf(i+1);
            codigo += "-2-B";
            this.habitacionList[i] = new Habitacion(codigo,TipoHabitacion.SUITE);
        }
        for(int i = 13; i<17;i++){
            String codigo =  String.valueOf(i+1);
            codigo += "-3-B";
            this.habitacionList[i] = new Habitacion(codigo,TipoHabitacion.NUPCIAL);
        }
        for(int i = 17; i<19;i++){
            String codigo =  String.valueOf(i+1);
            codigo += "-3-C";
            this.habitacionList[i] = new Habitacion(codigo,TipoHabitacion.PRESIDENCIAL);
        }
        for(int i = 0; i<19; i++){
            this.reservacionList[i] = new Reservacion();
        }
    }

    public RegistroGlobal(int nEmpleados){
        this();
        RegistroGlobal.nEmpleados = nEmpleados;
    }

    public void agregarReservacion(Reservacion reservacion){
        for(int i = 0; i<19; i++){
            if(this.reservacionList[i].getExiste() == 0){
                this.reservacionList[i] = reservacion;
                this.reservacionList[i].setExiste(1);
                break;
            }
        }
    }
    public Habitacion verificarHabitacionLibre(TipoHabitacion tipo){
        for(int i = 0; i<19; i++){
            if(this.habitacionList[i].getEstado()==EstadoHabitacion.LIBRE && this.habitacionList[i].getTipo()==tipo){
                this.habitacionList[i].setEstado(EstadoHabitacion.RESERVADA);
                return habitacionList[i];
            }
        }
        return null;
    }

    public Reservacion[] getReservacionList(){
        return this.reservacionList;
    }

    public Habitacion[] getHabitacionList(){
        return this.habitacionList;
    }

    public void imprmirnumeroReservaciones(){
        for(int i = 0; i <19 ; i++){
            if(reservacionList[i].getExiste() != 0){
                System.out.println("Actualmente existen " + (i+1) + "reservaciones");
            }
        }
    }

    @Override
    public String toString(){
        String cadena = new String();
        for(int i = 0; i<19; i++){
            cadena += this.habitacionList[i].toString();
            cadena += "\n";
        }
        return cadena;
    }


}
