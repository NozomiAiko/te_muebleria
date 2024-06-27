package com.emergentes.controller;

import com.emergentes.bean.BeanUsuario;
import com.emergentes.entidades.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanUsuario dao = new BeanUsuario();
            Usuario usu = new Usuario();
            switch (action) {
                case "add":
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usu = dao.buscar(id);
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("UsuarioServlet");
                    break;
                case "view":
                    List<Usuario> lista = dao.listarTodos();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN CLIENTE_CONTROLADOR_GET:" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BeanUsuario dao = new BeanUsuario();
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nombre = request.getParameter("nombre");
            String contraseña = request.getParameter("contraseña");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String rol = request.getParameter("rol");

            Usuario c = new Usuario();
            c.setIdUsuario(idUsuario);
            c.setNombreUsu(nombre);
            c.setContraseña(contraseña); 
            c.setCorreo(correo);
            c.setDireccion(direccion);
            c.setTelefonoUsu(telefono);
            c.setRol(rol);

            if (idUsuario == 0) {
                dao.insertar(c);
            } else {
                dao.modificar(c);
            }
            response.sendRedirect("UsuarioServlet");
        } catch (Exception ex) {
            System.out.println("ERROR EN CLIENTE_CONTROLADOR_POST:" + ex.getMessage());
        }
    }
}
