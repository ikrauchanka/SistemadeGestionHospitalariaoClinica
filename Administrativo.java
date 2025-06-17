public class Administrativo extends Empleado {
    private Area area;


    public Administrativo(String nombre, int dni, int idEmpleado, double salario, Cargo cargo, String fechaContratacion, Area area) {
        super(nombre, dni, idEmpleado, salario, cargo, fechaContratacion);
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    void mostrarInformacion() {
        System.out.println("Administrativo: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Cargo: " + getCargoEmpleado());
        System.out.println("Area: " + area);
    }
}