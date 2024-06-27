<%@page import="java.util.List"%>
<%@page import="com.emergentes.entidades.Pedido"%>
<%@page import="com.emergentes.entidades.Cliente"%>
<%@page import="com.emergentes.entidades.Usuario"%>
<%
    Pedido pedido = (Pedido) request.getAttribute("pedido");
    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
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
        <h1 class="text-2xl font-bold mb-4">Registro de Pedido</h1>

        <form action="PedidoServlet" method="post" class="space-y-4">
            <div class="form-control">
                <input type="hidden" name="id" value="<%= pedido.getIdPedido()%>">
            </div>

            <div class="form-control">
                <label class="label">Seleccione un cliente:</label>
                <select name="clienteId" class="select select-bordered w-full bg-white text-black" required>
                    <option>---seleccione---</option>
                    <% if (clientes != null) { %>
                        <% for (Cliente item : clientes) { %>
                            <option value="<%= item.getIdCliente() %>" <%= (item.getIdCliente() == pedido.getCodCliente().getIdCliente()) ? "selected" : "" %>><%= item.getNombreCli() %></option>
                        <% } %>
                    <% } %>
                </select>
            </div>

            <div class="form-control">
                <label class="label">Seleccione un vendedor:</label>
                <select name="usuarioId" class="select select-bordered w-full bg-white text-black" required>
                    <option>---seleccione---</option>
                    <% for (Usuario item : usuarios) { %>
                        <option value="<%= item.getIdUsuario() %>" <%= (item.getIdUsuario() == pedido.getCodUsuario().getIdUsuario()) ? "selected" : "" %>><%= item.getNombreUsu() %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-control">
                <label class="label">Fecha de pedido:</label>
                <input type="date" name="fecha" value="<%= pedido.getFecha() %>" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="form-control">
                <label class="label">Ingrese el total:</label>
                <input type="number" step="any" name="total" value="<%= pedido.getTotal() %>" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="form-control">
                <label class="cursor-pointer label">Estado:</label><br>
                <input type="checkbox" name="estado" value="0" <%= (pedido.getEstado() == 0) ? "checked" : ""%> class="checkbox checkbox-accent"> PENDIENTE<br>
                <input type="checkbox" name="estado" value="1" <%= (pedido.getEstado() == 1) ? "checked" : ""%>class="checkbox checkbox-accent"> ENTREGADO<br>
            </div>

            <button type="submit" id="btnSave" class="btn btn-success w-full text-white">GUARDAR</button>
        </form>
    </div>

    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
