<%@page import="com.emergentes.entidades.Cliente"%>
<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMULARIO</title>
<<<<<<< HEAD
        <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="bg-gray-100">
        <div class="container mx-auto p-8">
            <h1 class="text-3xl font-bold text-center mb-8">REGISTRO DE CLIENTES</h1>
            <form action="ClienteServlet" method="post" class="bg-white p-8 rounded shadow-md max-w-md mx-auto">
                <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente()%>">

                <div class="mb-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2">Nombre del cliente:</label>
                    <input type="text" name="nombre" value="<%= cliente.getNombreCli()%>" class="input input-bordered w-full bg-white text-black" required>
                </div>

                <div class="mb-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2">Correo electrónico:</label>
                    <input type="email" name="email" value="<%= cliente.getEmail()%>" class="input input-bordered w-full bg-white text-black" required>
                </div>

                <div class="mb-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2">Dirección de vivienda:</label>
                    <input type="text" name="direccion" value="<%= cliente.getDireccionCli()%>" class="input input-bordered w-full bg-white text-black" required>
                </div>

                <div class="mb-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2">Número de celular:</label>
                    <input type="tel" name="telefono" value="<%= cliente.getTelefono()%>" class="input input-bordered w-full bg-white text-black" required>
                </div>

                <div class="flex items-center justify-between">
                    <button type="submit" class="btn btn-success text-white">GUARDAR</button>
                </div>
            </form>
        </div>

        <script src="https://cdn.tailwindcss.com"></script>
    </body>
</html>
=======
    </head>
    <body>
        <br><br><br>
        <h1>REGISTRO DE CLIENTES</h1>
        
        <form action="ClienteServlet" method="post">
            
            <div >
                <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente() %>">
            </div>   
            <div  >
                <label  >Nombre del cliente:</label><br><br>
                <input type="text"  value="<%= cliente.getNombreCli() %>" name="nombre">
            </div>
            <div  >
                <label  >Correo electronico:</label><br><br>
                <input type="email"  value="<%= cliente.getEmail() %>" name="email">
            </div>
            <div  >
                <label  >Direccion de vivienda:</label><br><br>
                <input type="text"  value="<%= cliente.getDireccionCli() %>" name="direccion">
            </div>
            <div  >
                <label  >Numero de celular:</label><br><br>
                <input type="number"  value="<%= cliente.getTelefono() %>" name="telefono">
            </div>
            </div><br><br>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>
        
    </body>
</html>

>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
