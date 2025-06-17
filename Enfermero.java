public class Enfermero extends Empleado {
    private Area area;

    private Turno turno;

    public Enfermero(String nombre, int dni, int idEmpleado, double salario, Cargo cargo, String fechaContratacion, Turno turno) {
        super(nombre, dni, idEmpleado, salario, cargo, fechaContratacion);
        this.turno = turno;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setArea(Turno area) {
        this.turno = turno;
    }

}