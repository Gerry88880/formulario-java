package en.form;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/listar")
public class ListarUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("🔥 LISTAR SERVLET EJECUTADO 🔥");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Lista de Usuarios</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Lista de Usuarios</h2>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Teléfono</th>");
        out.println("<th>Correo</th>");
        out.println("<th>Universidad</th>");
        out.println("<th>Hub</th>");
        out.println("</tr>");

        try {
            Connection conn = Conexion.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("nombre_completo") + "</td>");
                out.println("<td>" + rs.getString("telefono") + "</td>");
                out.println("<td>" + rs.getString("correo") + "</td>");
                out.println("<td>" + rs.getString("universidad") + "</td>");
                out.println("<td>" + rs.getBoolean("inscrito_hub") + "</td>");
                out.println("</tr>");
            }

        } catch (Exception e) {
            e.printStackTrace();

            out.println("</table>");
            out.println("<h3 style='color:red;'>❌ ERROR REAL:</h3>");
            out.println("<pre>");
            out.println(e.toString());
            out.println("</pre>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}