<%-- 
    Document   : categoriasForm
    Created on : 15/11/2021, 11:28:10 AM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria Form</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
                    <<h1>Datos de la Categoria</h1>
                </div>
                
                <div class="card-body">
                    <form method="post" action="CategoriaController?accion=guardar">
                        <!<!-- Reutilizar el form  -->
                        <div class="form-group row">
                            <label class="col-form-label col-sm-2">Nombre de la Categoria</label>
                            <input type="text" name="txtNombreCategoria"
                                   id="txtNombreCategoria" maxlength="50" 
                                   placeholder="Nombre de la Categoria" 
                                   class="form-control" required="required" 
                                   value="<c:out value="${categoria.entidad.nombreCategoria}"/>" 
                            />
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-form-label col-sm-2 ">Descripcion de la Categoria</label>
                            <input type="text" name="txtDescripcionCategoria" 
                                   id="txtDescripcionCategoria" 
                                   maxlength="100"
                                   placeholder="Descripcion de la Categoria" 
                                   class="form-control" 
                                   required="required" 
                                   
                                   value="<c:out value="${categoria.entidad.descripcionCategoria}"/>"
                              
                            />           
                                   
                            
                                      
                        </div>
                        
                        <div class="mb-3"></div>
                        <div class="form-group row">
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                        
                    </form>
                </div>
                
            </div>

        </div>
    </body>
</html>
