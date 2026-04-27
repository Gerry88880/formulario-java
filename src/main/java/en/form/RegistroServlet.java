package en.form;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("🔥 SERVLET EJECUTADO 🔥");

        // Leer datos
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String universidad = request.getParameter("universidad");
        String hub = request.getParameter("hub");

        boolean inscrito = (hub != null);

        try {
            Connection conn = Conexion.getConnection();

            String sql = "INSERT INTO usuarios (nombre_completo, telefono, correo, universidad, inscrito_hub) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, correo);
            ps.setString(4, universidad);
            ps.setBoolean(5, inscrito);

            int filas = ps.executeUpdate();

            System.out.println("✅ INSERT HECHO, filas: " + filas);

        } catch (Exception e) {
            System.out.println("❌ ERROR AL INSERTAR");
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}