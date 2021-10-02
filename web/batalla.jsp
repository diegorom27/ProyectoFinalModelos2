<%@page import="modelo.Logica.Batalla"%>
<%@page import="modelo.Logica.Hechizo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Logica.Personaje"%>
<%@page import="modelo.Logica.GestorDAO"%>
<%
    Batalla batalla = Batalla.getBatalla();

    int i = 0;
    int j = 0;

    GestorDAO gestor = new GestorDAO();
    GestorDAO gestor1 = new GestorDAO();

    ArrayList<Hechizo> h = new ArrayList();
    h = gestor.joinHechizo(batalla.getP1().getId());

    ArrayList<Hechizo> h2 = new ArrayList();
    h2 = gestor1.joinHechizo(batalla.getP2().getId());


%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Batalla</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
        <link href="./assets/index.css" type="text/css" rel="stylesheet" />   
    </head>
    <body>
        <audio  controls id="sonido" hidden><source type="audio/mpeg" src="./assets/muerte.mp3"></audio>
        <nav class="navbar navbar-expand-lg navbar-light sticky-sm-top" id="nav">
            <div class="container-fluid">
                <img class="navbar-brand" id="logo" src="./assets/img/logoModelos.png" href="#">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="batalla.jsp">Batalla</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                Personaje
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Nada de huir</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">cobarde >:v</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container" id="contenedor">

            <div class="row">

                <div class="col-md">
                    <div id="conVector" class="overflow-scroll">
                        <div id="personaje">
                        <div class="card text-white border-<%=batalla.getP1().getEstilo()%> mb-3 mt-2 mx-auto w-50 " id="card<%=batalla.getP1().getEstilo()%>" style="max-width: 18rem;">
                            <img src="<%=batalla.getP1().getFoto()%>" class="card-img-top w-75 mx-auto" >
                            <div class="card-header border-dark fs-6" id="card-header"><%=batalla.getP1().getNombre()%> 
                                <%if (batalla.getP1().getVida() > 0 & batalla.getP2().getVida() < 0) {%>
                                WINNER
                                <%}%>
                                <%if (batalla.getP1().getVida() < 0 & batalla.getP2().getVida() > 0) {%>
                                LOSER
                                <%}%>
                                <%if (batalla.getP1().getVida() < 0 & batalla.getP2().getVida() < 0) {%>
                                DRAW
                                <%}%>

                            </div>
                            <div class="card-body">
                                <h5 class="card-title fs-5">ID: <%=batalla.getP1().getId()%> </h5>
                                <p class="card-text fs-6"><img class=" " id="icon" src="./assets/img/heart.svg"> <%=batalla.getP1().getVida()%><br>
                                    <img class=" " id="icon" src="./assets/img/lighting.svg"> <%=batalla.getP1().getMana()%> <br>
                                    <img class=" " id="icon" src="./assets/img/espada.svg"> <%=batalla.getP1().getAtaque()%><br>    
                                </p>
                            </div>
                        </div>
                       </div>
                    </div>
                </div>      
                <%if (batalla.getP1().getVida() < 0 || batalla.getP2().getVida() < 0) {%>
                 <div class="col-sm w-25 p-3">    
                    <img class="w-100 p-3"src="./assets/img/KO.png">
                    <p class="mx-auto text-white text-center">
                        <%if(batalla.getP1().getVida() < 0){%>
                            <%=batalla.getP1().getNombre()%> <br> 
                        <%}else{%>
                            <%=batalla.getP2().getNombre()%>
                        <%}%>
                            has demostrado que tu existencia<br>
                            es inecesaria en este mundo<br>
                            procederas a ser <bold>DESTERRADO</bold>      
                    </p>
                </div>       
                <%}%>
                <div class="col-md">
                    <div id="conVector" class=" overflow-scroll">
                        <div id="personaje1">
                        <div class="card text-white border-<%=batalla.getP2().getEstilo()%> mb-3 mt-2 mx-auto w-50 " id="card<%=batalla.getP2().getEstilo()%>" style="max-width: 18rem;">
                            <img src="<%=batalla.getP2().getFoto()%>" class="card-img-top w-75 mx-auto" >
                            <div class="card-header border-dark fs-6" id="card-header"><%=batalla.getP2().getNombre()%>
                                <%if (batalla.getP1().getVida() < 0 & batalla.getP2().getVida() > 0) {%>
                                WINNER
                                <%}%>
                                <%if (batalla.getP1().getVida() > 0 & batalla.getP2().getVida() < 0) {%>
                                LOSER
                                <%}%>
                                <%if (batalla.getP1().getVida() < 0 & batalla.getP2().getVida() < 0) {%>
                                DRAW
                                <%}%>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title fs-5">ID: <%=batalla.getP2().getId()%> </h5>
                                <p class="card-text fs-6"><img class=" " id="icon" src="./assets/img/heart.svg"> <%=batalla.getP2().getVida()%><br>
                                    <img class=" " id="icon" src="./assets/img/lighting.svg"> <%=batalla.getP2().getMana()%> <br>
                                    <img class=" " id="icon" src="./assets/img/espada.svg"> <%=batalla.getP2().getAtaque()%><br>                                
                                </p>
                            </div>
                        </div>
                        </div>
                    </div>                     
                </div>
            </div>
            <%if (batalla.getP1().getVida() < 0 || batalla.getP2().getVida() < 0) {%>
                <form action="Eliminar" onsubmit="derrota()" method="POST">
                   <%if (batalla.getP1().getVida() < 0) {%> 
                   <input class="form-control float-end w-50 p-3 mt-4 float-md-start"  name="id"   value="<%=batalla.getP1().getId()%>" hidden > 
                   <%}else{%>
                    <input class="form-control float-end w-50 p-3 mt-4 float-md-start"  name="id"   value="<%=batalla.getP2().getId()%>" hidden> 
                   <%}%>
            <%}else{%>
            <form action="BatalllaEnProceso" onsubmit="ataque()" method="POST">
             <%}%>   
                <div class="row">
                    <div class="col-sm " >
                        <%if (batalla.getI() % 2 != 0) {%>
                        <input class="form-control w-50 p-3 mt-4 float-md-end"  name="hechizo1"   placeholder="hechizo" list="hechizos1" autofocus required>
                        <%} else {%>
                        <input class="form-control w-50 p-3 mt-4 float-md-end"  name="hechizo2"   placeholder="hechizo" list="hechizos1" autofocus redondly>
                        <%}%>
                    </div>
                    <div class="col-sm" >
                        <h5 class="mx-auto text-white text-center">
                            Turno :<br>
                            <%=batalla.getI()%>
                            <input id="turno" hidden="" value="<%=batalla.getI()%>">
                        </h5>
                    </div> 
                    <div class="col-sm" >
                        <%if (batalla.getI() % 2 != 0) {%>
                        <input class="form-control float-end w-50 p-3 mt-4 float-md-start"  name="hechizo2"  placeholder="hechizo" list="hechizos2" autofocus redondly>
                        <%} else {%>
                        <input class="form-control float-end w-50 p-3 mt-4 float-md-start"  name="hechizo1"  placeholder="hechizo" list="hechizos2" autofocus required >
                        <%}%>
                    </div>  
                </div>
                <div class="row">
                    <div class="col-sm">
                        <%if (batalla.getP1().getVida() < 0 || batalla.getP2().getVida() < 0) {%>
                        <button type="submit"  class="btn btn-outline-light mt-2 mb-3  position-absolute start-50 translate-middle">Volver</button>     
                        <%}else{%>
                        <button type="submit"  id="pelea" class="btn btn-outline-light mt-2 mb-3  position-absolute start-50 translate-middle">Atacar</button>
                        <%}%>
                    </div> 
                </div>   
            </form>
            <datalist id="hechizos1">
                <option value="0">basico</option>
                <%while (i < h.size()) {%>
                <option value="<%=h.get(i).getId()%>"><%= h.get(i).getNombre()%> - <%= h.get(i).getTipo()%></option>
                <%i++;
                    }%>
            </datalist>

            <datalist id="hechizos2">
                <option value="0">basico</option>
                <%while (j < h2.size()) {%>
                <option value="<%=h2.get(j).getId()%>">
                <%= h2.get(j).getNombre()%> - <%= h2.get(j).getTipo()%></option>
                <%j++;
                    }%>
            </datalist> 
        </div>
    </body>
    <script type="text/javascript" src="./assets/scriptPelea.js"></script>
</html>
