<%@page import="com.emergentes.entidades.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro de Usuarios</title>
  <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
    <div class="card w-96 bg-white shadow-xl p-6 rounded-lg">
        <h1 class="text-2xl font-bold mb-4">Registro de Usuarios</h1>
        
        <form action="UsuarioServlet" method="post" class="space-y-4">
            <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
            
            <div class="form-control">
                <label class="label">Nombre del usuario:</label>
                <input type="text" value="<%= usuario.getNombreUsu() %>" name="nombre" class="input input-bordered w-full bg-white text-black" required>
            </div>
            
            <div class="form-control">
                <label class="label">Contraseña:</label>
                <input type="password" value="<%= usuario.getContraseña() %>" name="contraseña" class="input input-bordered w-full bg-white text-black" required>
            </div>
            
            <div class="form-control">
                <label class="label">Dirección de correo:</label>
                <input type="email" value="<%= usuario.getCorreo() %>" name="correo" class="input input-bordered w-full bg-white text-black"required>
            </div>
            
            <div class="form-control">
                <label class="label">Dirección de vivienda:</label>
                <input type="text" value="<%= usuario.getDireccion() %>" name="direccion" class="input input-bordered w-full bg-white text-black" required>
            </div>
            
            <div class="form-control">
                <label class="label">Número de celular:</label>
                <input type="number" value="<%= usuario.getTelefonoUsu() %>" name="telefono" class="input input-bordered w-full bg-white text-black" required>
            </div>
            <div class="form-control">
                <label class="label">Role</label><br>
                <input type="checkbox" name="rol" value="rol" <%= (usuario.getRol() == "admin") ? "checked" : ""%>> Admin<br>
                <input type="checkbox" name="rol" value="rol" <%= (usuario.getRol() == "user") ? "checked" : ""%>> User<br>
            </div>

            <button type="submit" id="btnSave" class="btn btn-success w-full text-white">GUARDAR</button>
        </form>
    </div>

    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
=======
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMULARIO</title>
    </head>
    <body>
        <br><br><br>
        <h1>REGISTRO DE USUARIOS</h1>
        
        <form action="UsuarioServlet" method="post">
            
            <div >
                <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
            </div>   
            <div  >
                <label  >Nombre del usuario:</label><br><br>
                <input type="text"  value="<%= usuario.getNombreUsu() %>" name="nombre">
            </div>
            <div  >
                <label  >Contraseña:</label><br><br>
                <input type="password"  value="<%= usuario.getContraseña() %>" name="contraseña">
            </div>
            <div  >
                <label  >Direccion de correo:</label><br><br>
                <input type="email"  value="<%= usuario.getCorreo() %>" name="correo">
            </div>
             <div  >
                <label  >Direccion de vivienda:</label><br><br>
                <input type="text"  value="<%= usuario.getDireccion() %>" name="direccion">
            </div>
            <div  >
             
                <label  >Numero de celular:</label><br><br>
                <input type="number"  value="<%= usuario.getTelefonoUsu() %>" name="telefono">
            </div>
            </div><br><br>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>
        
    </body>
</html>

>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
