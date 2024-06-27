<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Inventario"%>
<%@page import="com.emergentes.entidades.Producto"%>
<%
    Inventario inventario = (Inventario) request.getAttribute("inventario");
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
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
        <h1 class="text-2xl font-bold mb-4">Registro de Inventario</h1>

        <form action="InventarioServlet" method="post" class="space-y-4">
            <div class="form-control">
                <label class="label">Seleccione un producto:</label>
                <select name="productoId" class="select select-bordered w-full bg-white text-black" required>
                    <option>---seleccione---</option>
                    <% for (Producto item : productos) { %>
                        <option value="<%= item.getIdProducto()%>" <%= (inventario.getIdProducto() != null && item.getIdProducto() == inventario.getIdProducto().getIdProducto()) ? "selected" : ""%>><%= item.getNombrePro()%></option>
                    <% } %>
                </select>
            </div>

            <div class="form-control">
                <input type="hidden" name="id" value="<%= inventario.getIdInventario()%>" required>
            </div>  

            <div class="form-control">
                <label class="label">Ingrese la cantidad:</label>
                <input type="number" name="cantidad" value="<%= inventario.getCantidad() %>" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="form-control">
                <label class="label">Fecha de inventario:</label>
                <input type="date" name="fecha" value="<%= inventario.getFecha() %>" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <button type="submit" id="btnSave" class="btn btn-success w-full text-white">GUARDAR</button>
        </form>
    </div>
</body>
    <script src="https://cdn.tailwindcss.com"></script>
</html>

