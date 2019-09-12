package com.company;

import org.w3c.dom.Node;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.Base64;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

public class Main extends HttpServlet {
    BinaryTree tree;
    String data;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        data = request.getParameter("data");
        for (int i = 0; i < data.length(); i++) {
            tree.addItem(data.charAt(i));
        }
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-eqiuv='Content-Type' content ='text/html; charset= UTF-8'>");
            out.println("<body>");
            tree.writeOut(tree.getRoot(), out);
            out.println("<br></br>");
            out.println("<p>Elemszam atlaga " + tree.getElemszamAtlag() + "</p>");
            out.println("<p>Atlag " + tree.getAtlag() + "</p>");
            out.println("<p>Melyseg " + tree.getMelyseg() + "</p>");
            out.println("<p>Szoras " + tree.getSzoras() + "</p>");
            out.println("</body>");
            out.println("</html>");

        } finally {

            out.close();

        }

    }

    @Override
    public void init() {
        tree = new BinaryTree();
    }

}
