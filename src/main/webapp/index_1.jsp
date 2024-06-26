<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>R&B Muebleria - Inicio</title>
        <!-- link iconos -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <!-- link font family -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;1,300;1,400&display=swap" rel="stylesheet">
        <!-- link bootstrap -->
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- AOS -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <!--link para insertar hoja de estilo-->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- logo en mi titulo -->
        <link rel="shortcut icon" href="assets/images/logotitulo.png">
        <meta name="description" content="Es una empresa que ofrece muebles de madera para el hogar, tiene diseños exclusivos y muebles hechos a medida.">
        <meta name="keywords" content="muebles, madera, diseños, hogar, armarios, roperos, alacenas, estantes, ofertas, chile, inicio">
    </head>
    <body class="bodyinicio">
        <jsp:include page="WEB-INF/nav.jsp"></jsp:include>


        <main>
            <section class="main">
                <!-- texto principal -->
                <div class="main__container">
                    <h1 class="main__h1"><b>Muebleria San Jose</b></h1>
                    <h2 class="main__h2">Espacios para todo lo que amas</h2>
                    <p class="main__p">Diseños exclusivos y a medida</p>
                </div>
            </section>
        </main>
        <!--.... los mas vendidos ...-->
        <div class="containervendidos">
            <a name="bestsellers" id="bestsellers" title="">
                <h3 data-aos="fade-right" class="textosellers">Los más Vendidos</h3>
            </a>
            <div class="bestsellers">
                <div class="vendidos text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls13" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers1.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers1-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers1-3.png" class="d-block w-100" alt="...">
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
                    <div class="card-body">
                        <h4 class="card-title">Ropero 4 puertas</h4>
                        <p class="card-text">2 cajones, color blanco.</p>
                        <a href="views/producto.jsp" class="boton btn-primary">Comprar</a>
                    </div>
                </div>
                <div class=" vendidos text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls14" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers3.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers3-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers3-3.png" class="d-block w-100" alt="...">
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
                    <div class="card-body">
                        <h5 class="card-title">Ropero 6 puertas</h5>
                        <p class="card-text">2 cajones, color cali.</p>
                        <a href="views/producto.jsp" class="boton btn-primary">Comprar</a>
                    </div>
                </div>
                <div class="vendidos text-center img-fluid" style="width: 18rem;">
                    <div id="carouselExampleControls15" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers2-2.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid border bestsellers-imagen" src="assets/images/bestsellers2-3.png" class="d-block w-100" alt="...">
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
                    <div class="card-body">
                        <h5 class="card-title">Mesa de noche</h5>
                        <p class="card-text">3 cajones, color nature.</p>
                        <a href="views/producto.jsp" class="boton btn-primary">Comprar</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- .......Ofertas......... -->
        <div class="inicio-grid">
            <div class="inicio-grid__container">
                <img data-aos="flip-left" class="img-fluid" src="assets/images/ofertas1.png" alt="" class="inicio-grid__img">
                <div class="overlay-inicio1">
                    <a href="views/producto.jsp" title="">
                        <h6 class="inicio-overlay__title1">Envio gratis</h6>
                    </a>
                </div>
            </div>
            <div class="inicio-grid__container">
                <img class="img-fluid" src="assets/images/ofertasmedio.png" alt="" class="inicio-grid__img">
                <div class="overlay-inicio2">
                    <h6 class="inicio-overlay__title2">Ofertas</h6>
                </div>
            </div>
            <div class="inicio-grid__container">
                <img data-aos="flip-right" class="img-fluid" src="assets/images/ofertas3.png" alt="" class="inicio-grid__img">
                <div class="overlay-inicio3">
                    <a href="views/producto.jsp" title="">
                        <h6 class="inicio-overlay__title3">Envio gratis</h6>
                    </a>
                </div>
            </div>
        </div>
        <!--......footer.............  -->
        <footer class="footer">
            <div class="footer__container">
                <div>
                    <p class="footer__texto">Derechos Reservados</p>
                </div>
                <div class="footer__redes">
                    <!-- Redes Sociales -->
                    <!-- logo instagram -->
                    <a class="footer__sombra" href="https://instagram.com" target="_blank"><i class="fab fa-instagram-square"></i></a>
                    <!-- logo face -->
                    <a class="footer__sombra" href="https://facebook.com" target="_blank"><i class="fab fa-facebook"></i></a>
                    <!-- logo youtube -->
                    <a class="footer__sombra" href="https://youtube.com" target="_blank"><i class="fab fa-youtube"></i></a>
                </div>
            </div>
        </footer>
        <!-- bootstrap -->
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <!-- aos -->
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <script>
            AOS.init();
        </script>
    </body>


