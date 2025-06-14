import java.util.List;

public class Paciente extends Persona {
    // private HistorialMedico historialMedico;
    private List<Alergia> alergias;
    private GrupoSanguineo grupoSanguineo;

    public Paciente(String nombre, int dni, List<Alergia> alergias, GrupoSanguineo grupoSanguineo) {
        super(nombre, dni);
        this.alergias = alergias;
        this.grupoSanguineo = grupoSanguineo;
        //   this.historialMedico = new HistorialMedico();
    }


    @Override
    void mostrarInformacion() {
        System.out.println("Paciente: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Grupo Sanguineo: " + grupoSanguineo);
        System.out.println("Alergias: " + alergias);
    }

//    public HistorialMedico getHistorialMedico() {
//        return historialMedico;
//    }
}