<%@page import="modelo.Logica.Hechizo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Logica.Personaje"%>
<%@page import="modelo.Logica.GestorDAO"%>
<%
    GestorDAO gestorP = new GestorDAO();
    GestorDAO gestorH = new GestorDAO();
    ArrayList<Personaje> p = new ArrayList();
    ArrayList<Hechizo> h = new ArrayList();
    p = gestorP.cargarPersonajes();
    h = gestorH.cargarHechizos();
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vincular hechizos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
        <link href="./assets/index.css" type="text/css" rel="stylesheet" />
    </head>

    <body>
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
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ElegirPersonaje.jsp">Batalla</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                Personaje
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="CrearPersonaje.jsp">Crear personaje</a></li>
                                <li><a class="dropdown-item" href="crearHechizo.jsp">Crear hechizo</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="ligarHechizosAPersonaje.jsp">Equipar Hechizos</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container" id="contenedor">

            <div class="row">

                <div class="col-md">
                    <div id="conVector" class=" overflow-scroll">
                        <%while (i < p.size()) {%>
                        <div class="card text-white border-<%=p.get(i).getEstilo()%> mb-3 mt-2 mx-auto w-50 " id="card<%=p.get(i).getEstilo()%>" style="max-width: 18rem;">
                            <img src="<%=p.get(i).getFoto()%>" class="card-img-top w-75 mx-auto" >
                            <div class="card-header border-dark fs-6" id="card-header"><%=p.get(i).getNombre()%></div>
                            <div class="card-body">
                                <h5 class="card-title fs-5">ID: <%=p.get(i).getId()%> </h5>
                                <p class="card-text fs-6"><img class=" " id="icon" src="./assets/img/heart.svg"> <%=p.get(i).getVida()%><br>
                                    <img class=" " id="icon" src="./assets/img/lighting.svg"> <%=p.get(i).getMana()%> <br>
                                    <img class=" " id="icon" src="./assets/img/espada.svg"> <%=p.get(i).getAtaque()%><br>

                                </p>
                            </div>
                        </div>    
                        <% i++;
                            }%>
                    </div>    
                </div>
                <div class="col-md">
                    <div id="conVector" class=" overflow-scroll">
                        <%while (j < h.size()) {%>
                        <div class="card text-white border-dark mb-3 mt-2 mx-auto w-50 " id="card" style="max-width: 18rem;">
                            <img src="<%=h.get(j).getFoto()%>" class="card-img-top w-75 mx-auto" >
                            <div class="card-header border-dark fs-6" id="card-header"><%=h.get(j).getNombre()%></div>
                            <div class="card-body">
                                <h5 class="card-title fs-5">ID: <%=h.get(j).getId()%> </h5>
                                <p class="card-text fs-6">
                                    tipo: <%=h.get(j).getTipo()%> <br>
                                    <%if (h.get(j).getTipo().equals("ataque")) {%>
                                    Gasto Mana: <%=h.get(j).getGastoMana()%><br>
                                    Da�o: <%=h.get(j).getEfecto()%><br>
                                    <%}%>
                                    <%if (h.get(j).getTipo().equals("curacion")) {%>
                                    Gasto Mana: <%=h.get(j).getGastoMana()%><br>
                                    Curacion: <%=h.get(j).getCuracion()%><br>
                                    <%}%>
                                    <%if (h.get(j).getTipo().equals("sacrificio")) {%>
                                    Gasto Mana: <%=h.get(j).getGastoMana()%><br>
                                    Sacrificio: <%=h.get(j).getSacrificio()%><br>
                                    Multiplicador: <%=h.get(j).getEfectoMultiplicador()%><br>
                                    <%}%>       
                                </p>
                            </div>
                        </div>    
                        <% j++;
                            }%>
                    </div> 
                </div>
            </div>
            <form action="AnadirHechizo" method="POST">
                <div class="row">
                    <div class="col-sm " >
                        <input class="form-control float-end w-50 p-3 mt-4"  name="personaje" id="personaje"  placeholder="personaje" list="personajes" autofocus required>
                    </div>  
                    <div class="col-sm">
                        <button type="submit" class="btn btn-outline-light mt-2 mb-3  position-absolute start-50 translate-middle">A�adir</button>
                    </div>
                    <div class="col-sm" >
                        <input class="form-control  float-start w-50 p-3 mt-4 "  name="hechizo" id="hechizo" placeholder="hechizo" list="hechizos" autofocus required>
                    </div>  
                </div>
            </form>
            <datalist id="personajes">
                <% while (k < p.size()) {%>
                <option><%= p.get(k).getId()%> </option>
                <%k++;
                    }%>
            </datalist> 
            <datalist id="hechizos">
                <% while (l < h.size()) {%>
                <option><%= h.get(l).getId()%> </option>
                <%l++;
                    }%>
            </datalist>      
        </div>
    </body>
</html>