<%-- 
    Document   : listaDeCategorias
    Created on : 15/11/2021, 07:31:04 AM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de categorias</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="./images/bootstrap-logo.svg" alt="" width="30" height="24">
                    </a>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaController?accion=listaDeCategorias">Lista de Categorias</a>
                            </li>
                            <li class="nav-item">             
                                <a class="nav-link" href="ProductoController?accion=listaDeProductos">Lista de Productos</a>
                            </li>

                        </ul>
                    </div>
                </div>
            </nav>

            <div class="card border-primary">
                <div class="card-header">
                    <hi class="text-center">Lista de Categorias</hi>
                </div>

                <div class="card-body">
                    <h4 class="card-title">
                        <a href="CategoriaController?accion=nuevo" class="btn btn-success">
                            Crear Categoria
                        </a>
                    </h4>
                    
                    
                    <h4 class="card-title">
                        <a href="CategoriaController?accion=graficar" class="btn btn-warning" target="_blank">
                            Graficar
                        </a>
                    </h4>
                    
                    <h4 class="card-title">
                        <a href="CategoriaController?accion=verReporte" class="btn btn-danger" target="_blank">
                            Generar PDF
                        </a>
                    </h4>
                   

                    <c:if test="${mensaje!=null}">
                        <div class="alert alert-success alert-dismisibble fade show" role="alert">
                            <strong>${mensaje}</strong>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Clave Categoria</th>
                                <th>Nombre Categoria</th>
                                <th>Descripcion Categoria</th>
                                <th>Eliminar</th>
                                <th>Actualizar</th>
                                <th>Reporte</th>
                            </tr>
                        </thead>
                        <c:forEach var="dto" items="${listaDeCategorias}">
                            <tbody>
                                <tr>
                                    <td>
                                        <a href="CategoriaController?accion=ver&id=<c:out value="${dto.entidad.idCategoria}"/> " class="btn btn-outline-success">
                                            <c:out value="${dto.entidad.idCategoria}"/> 
                                        </a>

                                    </td>

                                    <td>
                                        <c:out value="${dto.entidad.nombreCategoria}"/> 
                                    </td>

                                    <td>
                                        <c:out value="${dto.entidad.descripcionCategoria}"/> 
                                    </td>



                                    <td>
                                        <a href="CategoriaController?accion=eliminar&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-danger">Eliminar</a>
                                    </td>

                                    <td>
                                        <a href="CategoriaController?accion=actualizar&id=<c:out value="${dto.entidad.idCategoria}"/> " class="btn btn-outline-info">Actualizar</a>
                                    </td>

                                    <td>
                                        <a href="CategoriaController?accion=verReporte&id=<c:out value="${dto.entidad.idCategoria}"/> " class="btn btn-outline-warning">Reporte</a>
                                    </td>
                                </tr>
                            </tbody> 
                        </c:forEach>


                    </table>
                </div>

            </div>

        </div>
    </body>
</html>
