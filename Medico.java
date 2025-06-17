import java.util.Map;

public class Medico extends Empleado {
    private Especialidad especialidad;
    private String numMatricula;
    private Map<String, String> horarioAtencion; // ejemplo: "Lunes" -> "8:00-12:00"


    public Medico(String nombre, int dni, int idEmpleado, double salario, Cargo cargo, String fechaContratacion, Especialidad especialidad, String numMatricula, Map<String, String> horarioAtencion) {
        super(nombre, dni, idEmpleado, salario, cargo, fechaContratacion);
        this.especialidad = especialidad;
        this.numMatricula = numMatricula;
        this.horarioAtencion = horarioAtencion;
    }

    public Map<String, String> getHorarioAtencion() {
        return horarioAtencion;
    }
}