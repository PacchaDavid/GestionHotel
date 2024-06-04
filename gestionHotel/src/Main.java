import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Huesped huesped = new Huesped("Pedrito","1001340",LocalDate.of(1989,03,15));
        System.out.println(huesped);
        Recepcionista recepcionista = new Recepcionista("Carla","32434","HT09");
        System.out.println(recepcionista);
        huesped.agendarReservacion(recepcionista);
        System.out.println(recepcionista.getRegistro().getReservacionList()[0]);

        System.out.println("Desea obtener más información sobre el estado actual del sistema?");
        

        if(sc.nextLine().equals("si")){
            recepcionista.getRegistro().imprmirnumeroReservaciones();
            System.out.println(recepcionista.getRegistro().getHabitacionList()[0]);
        }

        sc.close();
    }
}