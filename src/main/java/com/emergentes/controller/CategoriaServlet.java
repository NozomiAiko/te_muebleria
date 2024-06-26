package com.emergentes.controller;

import com.emergentes.bean.BeanCategoria;
import com.emergentes.entidades.Categoria;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            BeanCategoria dao = new BeanCategoria();
            Categoria cat = new Categoria();
            switch (action) {
                case "add":
                    request.setAttribute("categoria", cat);
                    request.getRequestDispatcher("frmCategoria.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cat = dao.buscar(id);
                    request.setAttribute("categoria", cat);
                    request.getRequestDispatcher("frmCategoria.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("CategoriaServlet");
                case "view":
                    List<Categoria> lista = dao.listarTodos();
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("categoria.jsp").forward(request, response);
                    break;
                default:
                    break;

            }

        } catch (Exception ex) {
            System.out.println("ERROR EN Categoria_CONTROLADOR:" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            BeanCategoria dao = new BeanCategoria();
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            String nombreCat = request.getParameter("nombreCat");
            String descripcionCat = request.getParameter("descripcionCat");
            Categoria cat = new Categoria();
            cat.setIdCategoria(idCategoria);
            cat.setNombreCat(nombreCat);
            cat.setDescripcionCat(descripcionCat);
            if (idCategoria == 0) {
                //nuevo registro
                dao.insertar(cat);
            } else if (idCategoria != 0) {
                dao.modificar(cat);
            }
            response.sendRedirect("CategoriaServlet");

    }

}
