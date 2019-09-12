package test;

import java.io.*;
import java.util.Base64;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Base64;

@WebServlet(name = "t", urlPatterns = { "/tests/*" })
public class TestServlet extends HttpServlet {

    private static final String LOCATION = "C:\\Program Files\\Java\\apache-tomcat-9.0.14\\webapps\\TestServlet\\config.conf";
    private String USERNAME;
    private String PASSWORD;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        boolean success = checkAuth(request);

        if (success) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html><head>");
                out.println("<meta http-eqiuv='Content-Type' content ='text/html; charset= UTF-8'>");
                out.println("<title><Hello World</title></head>");
                out.println("<body>");
                out.println("<Request URI:>" + request.getRequestURI());
                out.println("<Protocol:>" + request.getProtocol());
                out.println("<PathInfo:>" + request.getPathInfo());
                out.println("<Remote Address:>" + request.getRemoteAddr());
                out.println("<p>A random number: <strong>" + Math.random() + "</strong></p>");
                out.println("</body>");
                out.println("</html>");
            } finally {

                out.close();
            }
        } else {
            noAccess(response);

        }
    }

    private boolean checkAuth(HttpServletRequest request) {
        String authValue = request.getHeader("Authorization");
        if (authValue == null) {
            return false;
        } else {
            if (!authValue.toUpperCase().startsWith("BASIC ")) {
                return false;
            } else {
                String userpass = new String(Base64.getDecoder().decode(authValue.substring(6)));
                int counter = userpass.indexOf(":");
                String observedUsername = userpass.substring(0, counter);
                String observedPassword = userpass.substring(counter + 1);
                if (observedPassword.equals(PASSWORD) && observedUsername.equals(USERNAME)) {
                    return true;
                } else {
                    return false;
                }

            }

        }
    }

    private void noAccess(HttpServletResponse response) {
        try {
            response.sendError(401);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public String getServletInfo() {
        return "Ez egy teszt servlet";
    }

    @Override
    public void init() {
        // kornyezeti valtozokent megava az utvonal
        // System.getenv("C:\Program
        // Files\Java\apache-tomcat-9.0.14\webapps\TestServlet\\config.conf");
        try {
            Properties pr = new Properties();
            File conf = new File(LOCATION);
            if (conf.exists() && conf.canRead()) {
                System.out.println("Mondom a fajlbol kiolvasott adatokat");
                pr.load(new FileInputStream(conf));
                USERNAME = pr.getProperty("dbusername");
                PASSWORD = pr.getProperty("dbpassword");

            } else {
                System.out.println("nincs meg a fajl");
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    @Override
    public void destroy() {
        // adatbazis lezarasa
    }

}