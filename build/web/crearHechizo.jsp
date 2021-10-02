<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crear hechizo</title>
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
                        <img src="./assets/img/hechizoAtaque.jpeg" class="card-img-top w-75 mx-auto" >
                        <div class="card-header border-dark fs-6" id="card-header">Hechizo Ataque</div>
                        <div class="card-body">
                            <p class="card-text fs-6">
                                gran poder acomulado sera lanzado al enemigo.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md">
                    <div class="card text-white border-dark mb-3 mt-2 mx-auto w-50 " id="card" style="max-width: 18rem;">
                        <img src="./assets/img/sacrificio.jpeg" class="card-img-top w-75 mx-auto" >
                        <div class="card-header border-dark fs-6" id="card-header">Hechizo Sacrificio</div>
                        <div class="card-body">
                            <p class="card-text fs-6">
                                toma tu propia vida para hacer una gran cantidad de daño al enemigo.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md">
                    <div class="card text-white border-dark mb-3 mt-2 mx-auto w-50 " id="card" style="max-width: 18rem;">
                        <img src="./assets/img/curacion.jpeg" class="card-img-top w-75 mx-auto" >
                        <div class="card-header border-dark fs-6" id="card-header">Hechizo curación</div>
                        <div class="card-body">
                            <p class="card-text fs-6">
                                usa la magia celestial para revitalizate. 
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <form action="CrearHechizo" method="POST">
                <div class="row">
                    <div class="col-sm ml-5">
                        <label class="rad " >
                            <input type="radio" name="tipo" value="ataque" checked required hidden>
                            <img class="w-50 rounded" src="assets/img/hechizoAtaque.jpeg" id="Imagen1">
                        </label>
                    </div>
                    <div class="col-sm ">  
                        <label class="rad " >
                            <input type="radio" name="tipo" value="curacion" checked required hidden>
                            <img class="w-50 rounded"  src="assets/img/curacion.jpeg" id="Imagen1">
                        </label>
                    </div>
                    <div class="col-sm" >
                        <label class="rad " >
                            <input type="radio" name="tipo" value="sacrificio" checked required hidden>
                            <img class="w-50 rounded"  src="assets/img/sacrificio.jpeg" id="Imagen1">
                        </label>
                    </div> 
                    <div class="col-sm">  
                        <input class="form-control w-100 p-3 mb-4 me-4" name="nombre"  type="text" placeholder="Nombre" >     
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm">
                        <button type="submit" class="btn btn-outline-light mt-5 mb-3  position-absolute start-50 translate-middle">submit</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>


