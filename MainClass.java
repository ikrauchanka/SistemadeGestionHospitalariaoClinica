public class MainClass {

    public static void main(String[] args) {
        Empleado empl = new Empleado("illia", 2300100, 001, 100000, Cargo.ADMINISTRADOR, "2025-01-12");

        empl.telefono = "0328271744";
        empl.mostrarInformacion();

    }
}
