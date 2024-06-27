<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Producto"%>
<%@page import="com.emergentes.entidades.Categoria"%>
<%
    Producto producto = (Producto) request.getAttribute("producto");
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
    <div class="card w-96 bg-white shadow-xl p-6 rounded-lg">
        <h1 class="text-2xl font-bold mb-4">Editar Registro de un Producto</h1>

        <form action="ProductoServlet" method="post" class="space-y-4">
            <div class="form-control">
                <input type="hidden" name="id" value="<%= producto.getIdProducto() %>">
            </div>

            <div class="form-control">
                <label class="label">Nombre del producto:</label>
                <input type="text" value="<%= producto.getNombrePro() %>" name="nombre" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="form-control">
                <label class="label">Descripción del producto:</label>
                <input type="text" value="<%= producto.getDescripcionPro() %>" name="descripcion" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="form-control">
                <label class="label">Precio unitario:</label>
                <input type="number" step="any" value="<%= producto.getPrecioUnitario() %>" name="precio" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="form-control">
                <label class="label">Seleccione una categoría:</label>
                <select name="categoriaId" class="select select-bordered w-full bg-white text-black required">
                    <option>---seleccione---</option>
                    <% for (Categoria item : categorias) { %>
                        <option value="<%= item.getIdCategoria() %>" <%= (item.getIdCategoria() == producto.getIdCategoria().getIdCategoria()) ? "selected" : "" %>><%= item.getNombreCat() %></option>
                    <% } %>
                </select>
            </div>

            <button type="submit" id="btnSave" class="btn btn-success w-full text-white">GUARDAR</button>
        </form>
    </div>

    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
