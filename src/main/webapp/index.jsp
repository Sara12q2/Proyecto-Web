<%-- 
    Document   : index
    Created on : 15/11/2021, 01:40:44 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel=" stylesheet ">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css2? family = Lobster & display = swap " rel =" stylesheet ">
        <link href = "https: //fonts.googleapis.com/css2? family = Lobster & display = swap " rel =" stylesheet ">
        
        <style>
            
            @import url('https://fonts.googleapis.com/css2?family=Lobster&family=Ubuntu&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=Lobster&display=swap');
            .color2{background:#c5c6c8;}

            body{
                text-align: center;
            }
            h1 { 

                display: inline-block;
                position: relative;
                color:#6F1E51;
                font-family: 'Lobster', cursive;
                padding: 150px;
                font-size: 80px;
            }
            h1::after,h1::before{
                content:'';
                position:absolute;
                width: 120px;
                height: 3px;
                background-color:currentColor;
                /*currentColor;;    */  
                top:2.5em; 
                transform: scale(0);
                transition:all 0.25s ease-in;
            }
            h1:hover::before,h1:hover::after{
                transform:scale(1);
            }
            h1::before{
                right: 540px;
            } 
            h1::after{
                left: 540px;
            } 
            .boton_1{
                margin-left: 17.5%;
                position: absolute;
                top: 50%;
                padding-right:100px;
                text-decoration: none;
                padding: 3px;
                padding-left: 10px;
                padding-right: 10px;
                font-family: 'Ubuntu', sans-serif;
                font-weight: 300;
                font-size: 25px;
                color: #D6A2E8;
                background-color: #6F1E51;
                border-radius: 15px;
                border: 3px double #D6A2E8;
                width:190px;
                height:50px;
            }
            .boton_1:hover{
                opacity: 0.6;
                text-decoration: none;
                color: #D6A2E8;
            }
        </style>
    </head>
    <body>

        <div class="container-fluid">

            <div class="row ">

                <div class="col-6">
                    <h1 class="lines-effect">Bienvenido!</h1>
                </div>
                <div class="col-6 color2 d-flex justify-content-center align-items-center slider">

                    <img src="./images/6269561.jpg" width="800" height="600" />

                </div> 
                <a href="./categorias/usuario.jsp" class="boton_1">Ingresar</a>

            </div> 
        </div>
        
        
    </body>
</html>
