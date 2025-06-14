abstract class Persona {
    String nombre;
    int dni;
    String apellido;
    String fechaNacimiento;
    String direccion;
    String telefono;
    String email;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    abstract void mostrarInformacion();
}