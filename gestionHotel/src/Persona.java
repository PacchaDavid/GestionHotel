import java.time.LocalDate;

public abstract class Persona implements GestionReservacion{
    protected String dni;
    protected String nombre;
    protected LocalDate fechaNacimiento;
    protected int edad;
}
