package en.form;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/formdb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // ← CAMBIA si no es esa

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("✅ CONEXIÓN EXITOSA");

        } catch (Exception e) {
            System.out.println("❌ ERROR DE CONEXIÓN");
            e.printStackTrace();
        }

        return conn;
    }
}