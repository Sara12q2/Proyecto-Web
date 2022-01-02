<%-- 
    Document   : usuario
    Created on : 31 dic. 2021, 10:52:10
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel=" stylesheet ">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css2? family = Lobster & display = swap " rel =" stylesheet ">
        <link href = "https: //fonts.googleapis.com/css2? family = Lobster & display = swap " rel =" stylesheet ">

    </head>

    <style>

        @import url('https://fonts.googleapis.com/css2?family=Lobster&family=Ubuntu&display=swap');
        @import url('https://fonts.googleapis.com/css2?family=Lobster&display=swap');
        .circulo{
            width:360px;
            height:360px;
            position:relative;
            display:inline-block;
            vertical-align:top;
            overflow:hidden;
            margin:3em auto;
            border-radius: 100%;
            margin-left: 3em;
            margin-right: auto;
            background-color: black;

        } 
        .circulo1{

            width:360px;
            height:360px;
            position:relative;
            display:inline-block;
            vertical-align:top;
            overflow:hidden;
            background-color: black;
            border-radius: 100%;

            margin:3em;
        }
        .circulo2{

            width:360px;
            height:360px;
            position:relative;
            display:inline-block;
            vertical-align:top;
            overflow:hidden;
            background-color: black;
            border-radius: 100%;

            margin:3em;
        }
        .circulo > .imagen{
            width:98%;
            height: 93%;
            border-radius: 100%;

        }
        .circulo1 > .imagen1{
            width:98%;
            height: 100%;
            border-radius: 100%;

        }
        .circulo2 > .imagen2{
            width:98%;
            height: 99%;
            border-radius: 100%;

        }

        .botonp{
            height:auto;
            text-align:center;
            position:relative;
            width:100%;
            display:inline-block;
            padding: 10px 20px;
            outline: 0;
            border: 0;

            max-width: 160px;
        }

    </style>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <form class="form-inline">

                <a  style="height:50px; width:250px;  position:relative;  left:2em "  class="btn btn-outline-warning"  href="">Opcion 1</a>
                <a  style="height:50px; width:300px;  position:relative;  left:5em" class="btn btn-outline-info"  href=""><center>Opcion 2</center></a>
                <a  style="height:50px; width:280px;  position:relative;  left:8em" class="btn btn-outline-light"   href=""><center>Opcion 3</center></a>
                <a  style="height:50px; width:280px;  position:relative;  left:11em" class="btn btn-outline-success"   href=""><center>Opcion 4</center></a>

            </form>  
        </nav>

        <div class="row">
            <div class="col-lg-3 col-md-3  m-1 py-2 position-relative text-center">

                <div class="circulo">
                    <img src="../images/billete.png" class="imagen" />

                </div>
                <a  style="height:50px; width:250px;  position:relative;  left:5em "  class="btn btn-dark"  href="depositar.jsp">Depositar</a>

            </div>
            <div class="col-lg-3 col-md-3 m-1 py-2  text-center">

                <div class="circulo1" style="left:5em">
                    <img src="../images/retirar.png" class="imagen1"/>
                </div>
                <a  style="height:50px; width:250px;  position:relative; left:10em "  class="btn btn-dark"  href="retirar.jsp">Retirar</a>

            </div>

            <div class="col-lg-3 col-md-3 m-1 py-2 position-relative text-center">

                <div class="circulo2" style="left:10em">
                    <img src="../images/deuda.png" alt="alt" class="imagen2"/>

                </div>
                <a  style="height:50px; width:250px;  position:relative;  left:15em "  class="btn btn-dark"  href="#">Adeudos</a>

            </div>
        </div>

        <!-- <div class="circulo">
             <img src="../images/billete.png" class="imagen" />
         </div>
         <div class="botonp"><a class="btn btn-outline-success"   href="productoForm.html"><center>Opcion 4</center></a></div>
         <div class="circulo1">
             <<img src="../images/retirar.png" alt="alt" class="imagen1"/>
 
         </div>
         <div class="circulo2">
             <<img src="../images/billete.png" alt="alt" class="imagen"/>
 
         </div>   -->
    </body>
</html>
