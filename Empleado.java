public class Empleado extends Persona{
    private int idEmpleado;
    private double salario;
    private Cargo cargo;
    private String fechaContratacion;

    public Empleado(String nombre, int dni, int idEmpleado, double salario, Cargo cargo, String fechaContratacion) {
        super(nombre, dni);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
    }


    @Override
    void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("ID Empleado: " + idEmpleado);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: $" + salario);
        System.out.println("Fecha de contratación: " + fechaContratacion);
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public Cargo getCargoEmpleado() {
        return cargo;
    }
    public void setIdEmpleado(int idEmpleado) {
        // TODO check for unique
        this.idEmpleado = idEmpleado;
    }

}
