<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
     
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <!-- FontAwesome -->
        <script src="https://kit.fontawesome.com/a4aac60993.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="../include/header.jsp" />
        <jsp:include page="../include/nav_lista.jsp" />
        
        <section id="clientes">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <div class="card">
                            <div class="card-header">
                                <h4>Listado de Clientes</h4>
                            </div>
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Nombre</th>
                                        <th>Saldo</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Iteramos cada elemento de la lista de clientes -->
                                    <c:forEach var="cliente" items="${lista_clientes}" varStatus="status" >
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${cliente.nombre} ${cliente.apellido}</td>
                                            <td> <fmt:formatNumber value="${cliente.saldo}" type="currency"/> </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/clientes/editar?id=${cliente.id}"
                                                   class="btn btn-secondary">
                                                    <i class="fas fa-angle-double-right"></i> Editar
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <!--Inicio Tarjetas para los totales-->
                    <div class="col-md-3">
                        <div class="card text-center bg-danger text-white mb-3">
                            <div class="card-body">
                                <h3>Saldo Total</h3>
                                <h4 class="display-4">
                                    <fmt:formatNumber value="${saldo_total}" type="currency" />
                                </h4>
                            </div>
                        </div>

                        <div class="card text-center bg-success text-white mb-3">
                            <div class="card-body">
                                <h3>Total Clientes</h3>
                                <h4 class="display-4">
                                    <i class="fas fa-users"></i> ${total_clientes}
                                </h4>
                            </div>
                        </div>        
                    </div>
                    <!--Fin Tarjetas para los totales-->
                </div>
            </div>
        </section>
        
        <jsp:include page="insertar_cliente.jsp" />                        
        <jsp:include page="../include/footer.jsp" />
            
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
