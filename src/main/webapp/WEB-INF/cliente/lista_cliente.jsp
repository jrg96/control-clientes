<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="cliente" items="${lista_clientes}">
            <h2>${cliente.id}</h2>
            <h2>${cliente.nombre}</h2>
            <h2>${cliente.apellido}</h2>
            <h2>${cliente.email}</h2>
            <h2>${cliente.telefono}</h2>
            <h2>${cliente.saldo}</h2>
            <br />
        </c:forEach>
    </body>
</html>
