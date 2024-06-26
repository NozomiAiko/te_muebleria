
package com.emergentes.controller;

import com.emergentes.bean.BeanCliente;
import com.emergentes.entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 999ma
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanCliente dao = new BeanCliente();
            Cliente cli = new Cliente();
            switch (action) {
                case "add":
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli = dao.buscar(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("ClienteServlet");
                case "view":
                    List<Cliente> lista = dao.listarTodos();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
        try{
            
            BeanCliente dao = new BeanCliente();
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String direccion = request.getParameter("direccion");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            Cliente c = new Cliente();
            c.setIdCliente(idCliente);
            c.setNombreCli(nombre);
            c.setEmail(email);
            c.setDireccionCli(direccion);
            c.setTelefono(telefono);
            if (idCliente == 0) {
                //nuevo registro
                dao.insertar(c);
            } else if (idCliente != 0) {
                dao.modificar(c);
            }
            response.sendRedirect("ClienteServlet");
        }catch (Exception ex) {
            System.out.println("ERROR EN CLIENTE_CONTROLADOR:POST" + ex.getMessage());
        }
       
    }

}
