<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crear personaje</title>
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
                            <a class="nav-link active" aria-current="page" href="index.html">Home</a>
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
                    <div class="card text-white border-dark mb-3 mt-2 mx-auto w-50 " id="card" style="max-width: 18rem;">
                        <img src="./assets/img/magoOscuro.jpeg" class="card-img-top w-75 mx-auto" >
                        <div class="card-header border-dark fs-6" id="card-header">Mago Oscuro</div>
                        <div class="card-body">
                            <h5 class="card-title fs-5">Mayor Ataque y menor cantidad de vida </h5>
                            <p class="card-text fs-6">
                                Un hechicero que ha adopato poderes a los que muy pocos se atreven a acercarse. Posee la furia oscura de las estrellas bajo su mando 
                                y busca venganza contra los que una vez llamo compañeros
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md">
                    <div class="card text-white border-dark mb-3 mt-2 mx-auto w-50 " id="card" style="max-width: 18rem;">
                        <img src="./assets/img/magoBlanco.jpeg" class="card-img-top w-75 mx-auto" >
                        <div class="card-header border-dark fs-6" id="card-header">Mago Blanco</div>
                        <div class="card-body">
                            <h5 class="card-title fs5-">Mayor vida y menor cantidad de ataque</h5>
                            <p class="card-text fs-6">
                                El mago blanco es un antiguo archimago con una gran responsabilidad. 
                                Proteger las runas del mundo, que una vez  moldearon lo que vemos a partir de la nada. 
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <form action="CrearPersonaje" method="POST">

                <div class="row">
                    <div class="col-sm ml-5">
                        <div class="form-check w-25 float-end me-2">
                            <input class="form-check-input ml-5" type="radio" name="tipo" id="tipo1" value="mago blanco" checked>
                            <label class="form-check-label text-light" for="tipo1">
                                Mago Blanco
                            </label>
                        </div>
                        <div class="form-check w-25 float-end me-4">
                            <input class="form-check-input ml-5" type="radio" name="tipo" id="tipo2" value="mago oscuro">
                            <label class="form-check-label text-light" for="tipo2">
                                Mago Nigga
                            </label>
                        </div>
                    </div>
                    <div class="col-sm ">  
                        <input class="form-control w-100 p-3 mb-4 me-4" name="nombre"  type="text" placeholder="Nombre" >     
                    </div>
                    <div class="col-sm" >
                        <input class="form-control w-50 p-3 mb-4 me-4"  name="estilo" id="estilo" list="estilos1" placeholder="estilo" autofocus required>
                    </div>                     
                </div>

                <div class="row">
                    <div class="col-sm">
                        <button type="submit" class="btn btn-outline-light mt-2 mb-3  position-absolute start-50 translate-middle">submit</button>
                    </div>
                </div>
            </form>
            <datalist id="estilos1">
                <option value="dark"></option>
                <option value="light"></option>
            </datalist>
        </div>
    </body>
</html>

