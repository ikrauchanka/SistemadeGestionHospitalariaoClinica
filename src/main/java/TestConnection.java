import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Clinica"; // замени на своё
        String user = "root";
        String password = "passw0rd";


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);

            String checkUniqueDNI = "SELECT id, nombre, dni from empleados where dni ='30890123'";
            PreparedStatement sql1 = conn.prepareStatement(checkUniqueDNI);
            ResultSet rs1 = sql1.executeQuery();

            if (rs1.next()) {
                //  is not empty
                System.out.println("DNI exists: " + rs1.getInt("dni") + " (" + rs1.getString("nombre") + ")");
                return;
            }


            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int result = rs.getInt(1);
                System.out.println("Query result: " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}