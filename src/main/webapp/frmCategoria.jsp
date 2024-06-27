<%@page import="com.emergentes.entidades.Categoria"%>
<%
    Categoria categoria = (Categoria) request.getAttribute("categoria");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FORMULARIO</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.8/dist/full.min.css" rel="stylesheet" type="text/css" />
</head>
<body class="bg-white">
    <div class="container mx-auto p-8">
        <h1 class="text-3xl font-bold text-center mb-8">REGISTRO DE CATEGORIAS</h1>
        <form action="CategoriaServlet" method="post" class="bg-white p-8 rounded shadow-md max-w-md mx-auto">
            <input type="hidden" name="idCategoria" value="<%= categoria.getIdCategoria()%>">

            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2">Nombre de la categoria:</label>
                <input type="text" name="nombreCat" value="<%= categoria.getNombreCat()%>" class="input input-bordered w-full bg-white text-black" required>
            </div>

            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2">Describe la categoria:</label>
                <textarea class="textarea textarea-bordered w-full bg-white text-black" name="descripcionCat" placeholder="Descripcion" required><%= categoria.getDescripcionCat() %></textarea>
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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMULARIO</title>
    </head>
    <body>
        <br><br><br>
        <h1>REGISTRO DE CATEGORIAS </h1>
        
        <form action="CategoriaServlet" method="post">
            
            <div >
                <input type="hidden" name="idCategoria" value="<%= categoria.getIdCategoria() %>">
            </div>   
            <div  >
                <label  >Nombre de la categoria:</label><br><br>
                <input type="text"  value="<%= categoria.getNombreCat() %>" name="nombreCat">
            </div>
            <div  >
                <label  >Describe la categoria:</label><br><br>
                <input type="text"  value="<%= categoria.getDescripcionCat() %>" name="descripcionCat">
            </div>
            </div><br><br>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>
        
    </body>
</html>

>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
