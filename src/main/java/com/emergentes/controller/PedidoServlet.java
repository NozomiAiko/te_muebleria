
package com.emergentes.controller;

import com.emergentes.bean.BeanCliente;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.bean.BeanPedido;
import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Usuario;
import com.emergentes.entidades.Pedido;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidoServlet", urlPatterns = {"/PedidoServlet"})
public class PedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanPedido dao = new BeanPedido();
            BeanCliente daoCli= new BeanCliente();
            BeanUsuario daoUsu= new BeanUsuario();
            Pedido pedido = new Pedido();
            switch (action) {
                case "add":
                    List<Cliente> listaCli = daoCli.listarTodos();
                    List<Usuario> listaUsu = daoUsu.listarTodos();
                  

                    request.setAttribute("pedido", pedido);
                    request.setAttribute("clientes", listaCli);
                    request.setAttribute("usuarios", listaUsu);
                    request.getRequestDispatcher("frmPedido.jsp").forward(request, response);
                    break;
                case "edit":
                    listaCli = daoCli.listarTodos();
                    listaUsu= daoUsu.listarTodos();                  
                    request.setAttribute("categorias", listaCli);
                    request.setAttribute("usuarios", listaUsu);
                    id = Integer.parseInt(request.getParameter("id"));
                    pedido = dao.buscar(id);
                    request.setAttribute("pedido", pedido);
                    request.getRequestDispatcher("frmPedido.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("PedidoServlet");
                case "view":
                    List<Pedido> lista = dao.listarTodos();
                    request.setAttribute("pedidos", lista);
                    request.getRequestDispatcher("pedido.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN VENTA_D_GET:" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanPedido dao = new BeanPedido();
        BeanCliente daoCli = new BeanCliente();
        BeanUsuario daoUsu = new BeanUsuario();
        
        int id = Integer.parseInt(request.getParameter("id"));
        int idCliente = Integer.parseInt(request.getParameter("clienteId"));
        int idUsuario = Integer.parseInt(request.getParameter("usuarioId"));
        String fecha = request.getParameter("fecha");
        Double total = Double.parseDouble(request.getParameter("total"));
        int estado= Integer.parseInt(request.getParameter("estado"));
        
        Cliente cli= daoCli.buscar(idCliente);
        Usuario usu= daoUsu.buscar(idUsuario);
        Pedido v = new Pedido();
        v.setIdPedido(id);
        v.setCodCliente(cli);
        v.setCodUsuario(usu);
        v.setFecha(fecha);
        v.setTotal(total);
        v.setEstado(estado);

        if (id == 0) {
            //nuevo registro
            dao.insertar(v);
        } else if (id != 0) {
            dao.modificar(v);
        }
        response.sendRedirect("PedidoServlet");
    }
    

}
