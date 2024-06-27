
package com.emergentes.controller;
import com.emergentes.bean.BeanProducto;
import com.emergentes.bean.BeanInventario;
import com.emergentes.entidades.Producto;
import com.emergentes.entidades.Inventario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InventarioServlet", urlPatterns = {"/InventarioServlet"})
public class InventarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanInventario dao = new BeanInventario();
            BeanProducto daoPro = new BeanProducto();

            Inventario inv = new Inventario();
            switch (action) {
                case "add":
                    List<Producto> listaC = daoPro.listarTodos();

                    request.setAttribute("inventario", inv);
                    request.setAttribute("productos", listaC);
                    request.getRequestDispatcher("frmInventario.jsp").forward(request, response);
                    break;
                case "edit":
                    listaC = daoPro.listarTodos();
                    request.setAttribute("productos", listaC);
                    id = Integer.parseInt(request.getParameter("id"));
                    inv = dao.buscar(id);
                    request.setAttribute("inventario", inv);
                    request.getRequestDispatcher("frmInventario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("InventarioServlet");
                case "view":
                    List<Inventario> lista = dao.listarTodos();
                    request.setAttribute("inventarios", lista);
                    request.getRequestDispatcher("inventario.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN INVENTARIO_D_GET:" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanInventario dao = new BeanInventario();
        BeanProducto daoPro = new BeanProducto();
        int id = Integer.parseInt(request.getParameter("id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fecha= request.getParameter("fecha");
        int productoId = Integer.parseInt(request.getParameter("productoId"));
        Producto pro = daoPro.buscar(productoId);
        Inventario p = new Inventario();
        p.setIdInventario(id);
        p.setCantidad(cantidad);
        p.setFecha(fecha);
        p.setIdProducto(pro);

        if (id == 0) {
            //nuevo registro
            dao.insertar(p);
        } else if (id != 0) {
            dao.modificar(p);
        }
        response.sendRedirect("InventarioServlet");

    }

    

}
