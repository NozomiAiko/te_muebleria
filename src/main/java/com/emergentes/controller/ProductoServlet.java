package com.emergentes.controller;

import com.emergentes.bean.BeanCategoria;
import com.emergentes.bean.BeanProducto;
import com.emergentes.entidades.Categoria;
import com.emergentes.entidades.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanProducto dao = new BeanProducto();
            BeanCategoria daoC = new BeanCategoria();

            Producto pro = new Producto();
            switch (action) {
                case "add":
                    List<Categoria> listaC = daoC.listarTodos();

                    request.setAttribute("producto", pro);
                    request.setAttribute("categorias", listaC);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                    break;
                case "edit":
                    listaC = daoC.listarTodos();
                    request.setAttribute("categorias", listaC);
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.buscar(id);
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("ProductoServlet");
                case "view":
                    List<Producto> lista = dao.listarTodos();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EN PRODUCTO_D_GET:" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanProducto dao = new BeanProducto();
        BeanCategoria daoCat = new BeanCategoria();
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Double precio = Double.parseDouble(request.getParameter("precio"));
        int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));

        Categoria cate = daoCat.buscar(categoriaId);
        Producto p = new Producto();
        p.setIdProducto(id);
        p.setNombrePro(nombre);
        p.setDescripcionPro(descripcion);
        p.setPrecioUnitario(precio);
        p.setIdCategoria(cate);

        if (id == 0) {
            //nuevo registro
            dao.insertar(p);
        } else if (id != 0) {
            dao.modificar(p);
        }
        response.sendRedirect("ProductoServlet");

    }

}
