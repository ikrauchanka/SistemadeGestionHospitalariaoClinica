# SistemadeGestionHospitalariaoClinica
Sistema de Gestion Hospitalaria/Clínica

```bash
mkdir src/main/java

docker exec -it mysql-container mysql -u root -p <passw0rd>

mvn compile exec:java -Dexec.mainClass=TestConnection

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=passw0rd -p 3306:3306 -d mysql:latest

mvn compile

mvn exec:java

```
// Preguntas

como acer único

horario

excepciones(como)

layer for database

creando los objetos (horario etc...) do I need to run init script to create it ?

```
while (!exit) {
    System.out.println("\n--- Sistema Hospitalario ---");
    System.out.println("1. Crear empleado");
    System.out.println("2. Crear paciente");
    System.out.println("3. Crear administrativo");
    System.out.println("4. Crear enfermero");
    System.out.println("5. Salir");
    System.out.print("Selecciona una opción: ");

```
```bash
CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    dni INT UNIQUE,
    legajo INT,
    sueldo DOUBLE,
    cargo VARCHAR(50),
    fecha_ingreso DATE,
    telefono VARCHAR(20)
);
```
```java
public class BaseDeDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void guardarEmpleado(Empleado empl) {
        String sql = "INSERT INTO empleados (nombre, dni, legajo, sueldo, cargo, fecha_ingreso, telefono) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empl.getNombre());
            stmt.setInt(2, empl.getDni());
            stmt.setInt(3, empl.getLegajo());
            stmt.setDouble(4, empl.getSueldo());
            stmt.setString(5, empl.getCargo().name());
            stmt.setString(6, empl.getFechaIngreso());
            stmt.setString(7, empl.getTelefono());

            int rows = stmt.executeUpdate();
            System.out.println("Empleado guardado (" + rows + " fila(s) afectadas).");

        } catch (Exception e) {
            System.err.println("Error al guardar empleado:");
            e.printStackTrace();
        }
    }
}
```