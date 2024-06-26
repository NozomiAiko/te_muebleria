<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&B Muebleria - Productos</title>
    <!-- link iconos -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <!-- link font family -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;0,500;1,300;1,400&display=swap" rel="stylesheet">
    <!-- AOS -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <!-- link bootstrap -->
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- css -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- logo en mi titulo -->
    <link rel="shortcut icon" href="assets/images/logo0.png">
    <meta name="description" content="Es una empresa que ofrece muebles de madera para el hogar, tiene dise�os exclusivos y muebles hechos a medida.">
    <meta name="keywords" content="muebles,productos, best sellers, cocina, dormitorio, ba�o, madera, dise�os, hogar, armarios, roperos, estante, mueble de ba�o">
</head>

<body>
<<<<<<< HEAD
   <jsp:include page="WEB-INF/menu_2.jsp"></jsp:include>
=======
    <jsp:include page="WEB-INF/menu.jsp"></jsp:include>
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
    <main>
        <div class="containerproductos">
            <a class="relative" href="#" title="">
                <h1 data-aos="fade-right" class="textoproductos">Best sellers</h1>
            </a>
            <div class="productos2">
                <!-- ......bestsellers -->
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas3.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas4.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble de ba�o</h5>
                        <p class="card-text">2 cajones, color blanco.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class=" productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls1" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/best1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/best2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/best3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls1" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls1" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Estante, 4 insertos</h5>
                        <p class="card-text">Color cali.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls2" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers2-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers2-3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mesa de noche</h5>
                        <p class="card-text">3 cajones, color nature.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls3" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas2-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas2-1.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls3" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls3" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble de ba�o</h5>
                        <p class="card-text">2 cajones, color nature.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
            </div>
        </div>
        <!--........ dormitorio........ -->
        <div class="containerproductos">
            <a name="bestsellers" id="bestsellers" title="">
                <h2 data-aos="fade-right" class="textoproductos">Dormitorio</h2>
            </a>
            <div class="productos2">
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls4" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers1-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers1-3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls4" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls4" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Ropero 4 puertas</h5>
                        <p class="card-text">2 cajones, color blanco.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class=" productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls5" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers3.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers3-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/bestsellers3-3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls5" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls5" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Ropero 6 puertas</h5>
                        <p class="card-text">2 cajones, color cali.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls6" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/dormitorio4.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/dormitorio5.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/dormitorio6.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls6" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls6" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Estante</h5>
                        <p class="card-text">2 puertas, color blanco.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls7" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/dormitorio1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/dormitorio2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/dormitorio3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls7" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls7" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Estante</h5>
                        <p class="card-text">4 cajones, color blanco.</p>
                        <a href="../views/frmcompra.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
            </div>
        </div>
        <!--......... cocina............ -->
        <div class="containerproductos">
            <a name="bestsellers" id="bestsellers" title="">
                <h3 data-aos="fade-right" class="textoproductos">Cocina</h3>
            </a>
            <div class="productos2">
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls8" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls8" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls8" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble 1 puerta</h5>
                        <p class="card-text">2 cajones, color blanco.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class=" productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls9" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina4.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina5.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina6.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls9" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls9" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble 2 puertas</h5>
                        <p class="card-text">4 cajones, color cali.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls10" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina7.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina8.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina9.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls10" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls10" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble 1 puerta</h5>
                        <p class="card-text">3 cajones, color nature.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls11" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina10.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina11.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/cocina12.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls11" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls11" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble</h5>
                        <p class="card-text">2 puertas, color nature.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
            </div>
        </div>
        <!--........ ba�o............... -->
        <div class="containerproductos2">
            <a name="bano" id="bano" title="">
                <h4 data-aos="fade-right" class="textoproductos">Ba�o</h4>
            </a>
            <div class="productos2">
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls12" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas2-1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls12" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls12" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble de ba�o</h5>
                        <p class="card-text">2 cajones, color blanco.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class=" productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls13" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas3.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas2-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas4.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls13" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls13" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble de ba�o</h5>
                        <p class="card-text">2 cajones, color cali.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls14" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas2-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas3.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls14" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls14" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble de ba�o</h5>
                        <p class="card-text">2 cajones, color nature.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="productostargetas text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls15" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas4.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas3.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border producto-imagen" src="assets/images/ofertas2-1.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls15" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls15" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="card-productos">
                        <h5 class="card-title">Mueble de ba�o</h5>
                        <p class="card-text">2 cajones, color gris.</p>
                        <a href="../views/productos.html" class="boton-comprar btn-primary">Comprar</a>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- .......footer....... -->
    <footer class="producto-footer">
        <div class="producto-footer__container">
            <div>
                <p class="producto-footer__texto">Derechos Reservados</p>
            </div>
            <!-- formas de pago -->
            <div class="producto-footer__targetas">
                <a class="footer__sombra" href="https://visa.com" target="_blank"><i class="fab fa-cc-visa"></i></a>
                <a class="footer__sombra" href="https://mastercard.com" target="_blank"><i class="fab fa-cc-mastercard"></i></a>
            </div>
        </div>
    </footer>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <!-- aos -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script>
    AOS.init();
    </script>
</body>

</html>
