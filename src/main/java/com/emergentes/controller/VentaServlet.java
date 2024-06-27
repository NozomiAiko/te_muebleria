
package com.emergentes.controller;

import com.emergentes.bean.BeanCliente;
import com.emergentes.bean.BeanProducto;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.bean.BeanVenta;
import com.emergentes.entidades.Cliente;
import com.emergentes.entidades.Producto;
import com.emergentes.entidades.Usuario;
import com.emergentes.entidades.Venta;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaServlet", urlPatterns = {"/VentaServlet"})
public class VentaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanVenta dao = new BeanVenta();
            BeanCliente daoCli= new BeanCliente();
            BeanUsuario daoUsu= new BeanUsuario();
            BeanProducto daoPro= new BeanProducto();
            
            Venta ven = new Venta();
            switch (action) {
                case "add":
                    List<Cliente> listaCli = daoCli.listarTodos();
                    List<Usuario> listaUsu = daoUsu.listarTodos();
                    List<Producto> listaPro = daoPro.listarTodos();
                  

                    request.setAttribute("venta", ven);
                    request.setAttribute("clientes", listaCli);
                    request.setAttribute("usuarios", listaUsu);
                    request.setAttribute("productos", listaPro);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);
                    break;
                case "edit":
                    listaCli = daoCli.listarTodos();
                    listaUsu= daoUsu.listarTodos();
                    listaPro= daoPro.listarTodos();                    
                    request.setAttribute("categorias", listaCli);
                    request.setAttribute("usuarios", listaUsu);
                    request.setAttribute("productos",listaPro);
                    id = Integer.parseInt(request.getParameter("id"));
                    ven = dao.buscar(id);
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("VentaServlet");
                case "view":
                    List<Venta> lista = dao.listarTodos();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("venta.jsp").forward(request, response);
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
        BeanVenta dao = new BeanVenta();
        BeanCliente daoCli = new BeanCliente();
        BeanUsuario daoUsu = new BeanUsuario();
        BeanProducto daoPro = new BeanProducto();
        int id = Integer.parseInt(request.getParameter("id"));
        int idCliente = Integer.parseInt(request.getParameter("clienteId"));
        int idUsuario = Integer.parseInt(request.getParameter("usuarioId"));
        int idProducto = Integer.parseInt(request.getParameter("productoId"));
        Double total = Double.parseDouble(request.getParameter("total"));
        String fecha = request.getParameter("fecha");
        Cliente cli= daoCli.buscar(idCliente);
        Usuario usu= daoUsu.buscar(idUsuario);
        Producto pro= daoPro.buscar(idProducto);
        Venta v = new Venta();
        v.setIdVenta(id);
        v.setIdCliente(cli);
        v.setIdUsuario(usu);
        v.setTotal(total);
        v.setFechaVenta(fecha);
        v.setCd1Producto(pro);

        if (id == 0) {
            //nuevo registro
            dao.insertar(v);
        } else if (id != 0) {
            dao.modificar(v);
        }
        response.sendRedirect("VentaServlet");
    }

}
