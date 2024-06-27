<%@page import="com.emergentes.entidades.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if (usuario == null) {
        usuario = new Usuario(); 
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
    <div class="card w-96 bg-white shadow-xl p-6 rounded-lg">
        <h1 class="text-2xl font-bold mb-4">Registro de Usuario</h1>
        <form action="RegistroController" method="post" class="space-y-4">
            <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
            <div>
                <label for="nombre" class="block text-gray-700 text-sm font-bold mb-2">Nombre:</label>
                <input type="text" id="nombre" name="nombre" value="<%= usuario.getNombreUsu() %>" required class="input input-bordered w-full bg-white text-black">
            </div>
            <div>
                <label for="contraseña" class="block text-gray-700 text-sm font-bold mb-2">Contraseña:</label>
                <input type="password" id="contraseña" name="contraseña" value="<%= usuario.getContraseña() %>" required class="input input-bordered w-full bg-white text-black">
            </div>
            <div>
                <label for="correo" class="block text-gray-700 text-sm font-bold mb-2">Correo:</label>
                <input type="email" id="correo" name="correo" value="<%= usuario.getCorreo() %>" required class="input input-bordered w-full bg-white text-black">
            </div>
            <div>
                <label for="direccion" class="block text-gray-700 text-sm font-bold mb-2">Dirección:</label>
                <input type="text" id="direccion" name="direccion" value="<%= usuario.getDireccion() %>" required class="input input-bordered w-full bg-white text-black">
            </div>
            <div>
                <label for="telefono" class="block text-gray-700 text-sm font-bold mb-2">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" value="<%= usuario.getTelefonoUsu() %>" required class="input input-bordered w-full bg-white text-black">
            </div>
            <div>
                <button type="submit" class="btn btn-success w-full text-white">Guardar</button>
            </div>
        </form>
    </div>
</body>

    <script src="https://cdn.tailwindcss.com"></script>
</html>
