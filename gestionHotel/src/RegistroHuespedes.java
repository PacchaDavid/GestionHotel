public class RegistroHuespedes {
   private int huespedesActuales;
   private int huespedesFuera;
   private int huespedesDentro;

    public RegistroHuespedes(int huespedesActuales){
        this.huespedesActuales = huespedesActuales;
    }
   
    private Huesped[] huespedList = new Huesped[huespedesActuales];
    private String[] estadoHuespedList = new String[huespedesActuales];

    public void agregarHuesped(Huesped huesped){
        for(int i = 0; i<huespedesActuales; i++){
            if(huespedList[i].getNombre()==null) huespedList[i] = huesped;
        }
    }

    public void cambiarEstadoHuesped(int nHuesped, String estado){
        this.estadoHuespedList[nHuesped-1] =  estado;
    }

    
}
