<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Venta"%>
<%@page import="com.emergentes.entidades.Cliente"%>
<%@page import="com.emergentes.entidades.Usuario"%>
<%@page import="com.emergentes.entidades.Producto"%>

<%
    Venta venta = (Venta) request.getAttribute("venta");
    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
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
        <h1 class="text-2xl font-bold mb-4">Registro de Venta</h1>

        <form action="VentaServlet" method="post" class="space-y-4">
            <input type="hidden" name="id" value="<%= venta.getIdVenta()%>">

            <div class="form-control">
                <label class="label">Seleccione un cliente:</label>
                <select name="clienteId" class=" select select-bordered w-full bg-white text-black" required>
                    <option>---seleccione---</option>
                    <% if (clientes != null) { %>
                        <% for (Cliente item : clientes) { %>
                            <option value="<%= item.getIdCliente()%>" <%= (venta.getIdCliente() != null && item.getIdCliente() == venta.getIdCliente().getIdCliente()) ? "selected" : ""%>><%= item.getNombreCli()%></option>
                        <% } %>
                    <% } %>
                </select>
            </div>

            <div class="form-control">
                <label class="label">Seleccione un vendedor:</label>
                <select name="usuarioId" class="select select-bordered w-full bg-white text-black required">
                    <option>---seleccione---</option>
                    <% if (usuarios != null) { %>
                        <% for (Usuario item : usuarios) { %>
                            <option value="<%= item.getIdUsuario()%>" <%= (venta.getIdUsuario() != null && item.getIdUsuario() == venta.getIdUsuario().getIdUsuario()) ? "selected" : ""%>><%= item.getNombreUsu()%></option>
                        <% } %>
                    <% } %>
                </select>
            </div>

            <div class="form-control">
                <label class="label">Seleccione un producto:</label>
                <select name="productoId" class="select select-bordered w-full bg-white text-black required">
                    <option>---seleccione---</option>
                    <% if (productos != null) { %>
                        <% for (Producto item : productos) { %>
                            <option value="<%= item.getIdProducto()%>" <%= (venta.getCd1Producto() != null && item.getIdProducto() == venta.getCd1Producto().getIdProducto()) ? "selected" : ""%>><%= item.getNombrePro()%></option>
                        <% } %>
                    <% } %>
                </select>
            </div>

            <div class="form-control">
                <label class="label">Fecha de venta:</label>
                <input type="date" name="fecha" value="<%= (venta.getFechaVenta() != null) ? venta.getFechaVenta() : "" %>" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="form-control">
                <label class="label">Ingrese el total:</label>
                <input type="number" step="any" name="total" value="<%= (venta.getTotal() != null) ? venta.getTotal() : "" %>" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <button type="submit" id="btnSave" class="btn btn-success w-full text-white">GUARDAR</button>
        </form>
    </div>
</body>

    <script src="https://cdn.tailwindcss.com"></script>
</html>
