package com.emergentes.controller;

import com.emergentes.bean.BeanDetalleInventario;
import com.emergentes.bean.BeanInventario;
import com.emergentes.bean.BeanProducto;
import com.emergentes.entidades.DetalleInventario;
import com.emergentes.entidades.Inventario;
import com.emergentes.entidades.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetalleInventarioServlet", urlPatterns = {"/DetalleInventarioServlet"})
public class DetalleInventarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanDetalleInventario dao = new BeanDetalleInventario();
            BeanProducto daoPro = new BeanProducto();
            BeanInventario daoPed = new BeanInventario();
            DetalleInventario det = new DetalleInventario();
            switch (action) {
                case "add":
                    List<Producto> listaC = daoPro.listarTodos();
                    List<Inventario> listaPed = daoPed.listarTodos();
                    request.setAttribute("detalleInventario", det);
                    request.setAttribute("productos", listaC);
                    request.setAttribute("Inventarios", listaPed);
                    request.getRequestDispatcher("frmDetalleInventario.jsp").forward(request, response);
                    break;
                case "edit":
                    listaC = daoPro.listarTodos();
                    listaPed = daoPed.listarTodos();
                    request.setAttribute("productos", listaC);
                    request.setAttribute("Inventarios", listaPed);
                    id = Integer.parseInt(request.getParameter("id"));
                    det = dao.buscar(id);
                    request.setAttribute("detalleInventario", det);
                    request.getRequestDispatcher("frmDetalleInventario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("DetalleInventarioServlet");
                case "view":
                    List<DetalleInventario> lista = dao.listarTodos();
                    request.setAttribute("detalleInventarios", lista);
                    request.getRequestDispatcher("detalleInventario.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN DETALLE_INVENTARIO_D_GET:" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanDetalleInventario dao = new BeanDetalleInventario();
        BeanProducto daoPro = new BeanProducto();
        BeanInventario daoPed = new BeanInventario();
        int id = Integer.parseInt(request.getParameter("id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fecha = request.getParameter("fecha");
        int productoId = Integer.parseInt(request.getParameter("productoId"));
        Producto pro = daoPro.buscar(productoId);
        int inventarioId = Integer.parseInt(request.getParameter("inventarioId"));
        Inventario ped = daoPed.buscar(inventarioId);
        
        DetalleInventario p = new DetalleInventario();
        p.setIdDetalle(id);
        p.setCdProducto(pro);
        p.setCantidad(cantidad);
        p.setFechaDet(fecha);
        p.setIdInventario(ped);

        if (id == 0) {
            //nuevo registro
            dao.insertar(p);
        } else if (id != 0) {
            dao.modificar(p);
        }
        response.sendRedirect("DetalleInventarioServlet");

    }

}
