<%@page import="com.emergentes.entidades.Categoria"%>
<%
    Categoria categoria = (Categoria) request.getAttribute("categoria");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

