
package com.emergentes.controller;
import com.emergentes.bean.BeanDetallePedido;
import com.emergentes.bean.BeanPedido;
import com.emergentes.bean.BeanProducto;
import com.emergentes.entidades.DetallePedido;
import com.emergentes.entidades.Pedido;
import com.emergentes.entidades.Producto;
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
@WebServlet(name = "DetallePedidoServlet", urlPatterns = {"/DetallePedidoServlet"})
public class DetallePedidoServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanDetallePedido dao = new BeanDetallePedido();
            BeanProducto daoPro = new BeanProducto();
            BeanPedido daoPed = new BeanPedido();
            DetallePedido det = new DetallePedido();
            switch (action) {
                case "add":
                    List<Producto> listaC = daoPro.listarTodos();
                    List<Pedido> listaPed = daoPed.listarTodos();
                    request.setAttribute("detallePedido", det);
                    request.setAttribute("productos", listaC);
                    request.setAttribute("pedidos", listaPed);
                    request.getRequestDispatcher("frmDetallePedido.jsp").forward(request, response);
                    break;
                case "edit":
                    listaC = daoPro.listarTodos();
                    listaPed = daoPed.listarTodos();
                    request.setAttribute("productos", listaC);
                    request.setAttribute("pedidos", listaPed);
                    id = Integer.parseInt(request.getParameter("id"));
                    det = dao.buscar(id);
                    request.setAttribute("detallePedido", det);
                    request.getRequestDispatcher("frmDetallePedido.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("DetallePedidoServlet");
                case "view":
                    List<DetallePedido> lista = dao.listarTodos();
                    request.setAttribute("detallePedidos", lista);
                    request.getRequestDispatcher("detallePedido.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN DETALLE_PEDIDO_D_GET:" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       BeanDetallePedido dao = new BeanDetallePedido();
        BeanProducto daoPro = new BeanProducto();
        BeanPedido daoPed = new BeanPedido();
        int id = Integer.parseInt(request.getParameter("id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int productoId = Integer.parseInt(request.getParameter("productoId"));
        Producto pro = daoPro.buscar(productoId);
        int pedidoId= Integer.parseInt(request.getParameter("pedidoId"));
        Pedido ped = daoPed.buscar(pedidoId);
        DetallePedido p = new DetallePedido();
        p.setIdDetallePedido(id);
        p.setCantidad(cantidad);
        p.setCodProducto(pro);
        p.setIdPedido(ped);

        if (id == 0) {
            //nuevo registro
            dao.insertar(p);
        } else if (id != 0) {
            dao.modificar(p);
        }
        response.sendRedirect("DetallePedidoServlet");

    }

}
