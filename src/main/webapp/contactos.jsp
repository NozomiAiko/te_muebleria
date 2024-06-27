<!DOCTYPE html>
<html lang="es">

<<<<<<< HEAD
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&B Muebleria - Contactos</title>
    <!-- Enlaces a recursos externos -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;0,500;1,300;1,400&display=swap" rel="stylesheet">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- logo en mi titulo -->
        <link rel="shortcut icon" href="assets/images/logotitulo.png">
    <meta name="description" content="Empresa de muebles de madera con diseños exclusivos y a medida.">
    <meta name="keywords" content="muebles, contactos, preguntas, presupuestos, whatsapp, correo electrónico, madera, diseños, precios">
</head>

<body>
    <!-- Encabezado -->
      <jsp:include page="WEB-INF/menu.jsp"></jsp:include>

    <!-- Contenido principal -->
    <main>
        <section class="contactos-grid">
            <div class="contactos-grid__container">
                <!-- Sección de contacto -->
                <div class="contacto-main">
                    <section class="contacto__texto">
                        <h1 class="white colorverde">Contacto</h1>
                        <p class="white">Escríbenos, déjanos tu consulta.</p>
                        <ul>
                            <li class="contacto__li">
                                <p class="white"><b>Encuéntranos en:</b></p>
                                <p class="white"><a href="http:googlemaps.com" target="_blank"><i class="fas fa-map-marker-alt"></i></a> Bolivia, La Paz</p>
                            </li>
                            <li class="contacto__li">
                                <p class="white"><b>Nuestros números de teléfono:</b></p>
                                <p class="white"><a href="http:whatsapp.com" target="_blank"><i class="fab fa-whatsapp"></i></a> +591 74319582</p>
                                <p class="white"><a href="http:whatsapp.com" target="_blank"><i class="fab fa-whatsapp"></i></a> +591 75840329</p>
                                <p class="white"><a href="http:whatsapp.com" target="_blank"><i class="fab fa-whatsapp"></i></a> +591 78921634</p>
                            </li>
                            <li class="contacto__li">
                                <p class="white"><b>Nuestro Email:</b></p>
                                <p class="white"><a href="mailto:sanjosecon@gmail.com"><i class="fas fa-envelope"></i></a> sanjosecon@gmail.com</p>
                            </li>
                        </ul>
                        <!-- Formulario de contacto -->
                        <form action="mailto:emilianalila@gmail.com" method="post" enctype="text/plain" class="contacto__formulario">
                            <label for="nombre">Nombre</label>
                            <input class="contacto__input" type="text" id="nombre" name="nombre">
                            <br>
                            <label for="email">Email</label>
                            <input class="contacto__input" type="email" id="email" name="email">
                            <br>
                            <label for="telefono">Teléfono</label>
                            <input class="contacto__input" type="tel" id="telefono" name="telefono">
                            <br>
                            <textarea placeholder="Consulta" class="contacto__textarea" name="consulta"></textarea>
                            <br>
                            <!-- Botones de envío y restablecimiento -->
                            <div class="contacto__bottom">
                                <input class="contacto__submit" type="submit" value="Enviar">
                                <input class="contacto__restablecer" type="reset" value="Restablecer">
                            </div>
                        </form>
                    </section>
                </div>
            </div>
            <!-- Carrusel de imágenes -->
            <div class="contactos-grid__container">
                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="img-fluid" src="assets/images/envios6.png" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img class="img-fluid" src="assets/images/envios73.png" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img class="img-fluid" src="assets/images/envios72.png" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Anterior</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Siguiente</span>
                    </button>
                </div>
            </div>
        </section>

       
=======
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>R&B Muebleria - Contactos</title>
        <!-- Enlaces a recursos externos -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;0,500;1,300;1,400&display=swap" rel="stylesheet">
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- logo en mi titulo -->
        <link rel="shortcut icon" href="assets/images/logotitulo.png">
        <meta name="description" content="Empresa de muebles de madera con diseños exclusivos y a medida.">
        <meta name="keywords" content="muebles, contactos, preguntas, presupuestos, whatsapp, correo electrónico, madera, diseños, precios">
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
        <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
    </head>

    <body>
        <!-- Encabezado -->
        <jsp:include page="WEB-INF/menu.jsp"></jsp:include>

        <!-- Contenido principal -->
        <main>
            <section class="contactos-grid">
                <div class="contactos-grid__container">
                    <!-- Sección de contacto -->
                    <div class="contacto-main">
                        <section class="contacto__texto">
                            <h1 class="white colorverde" id="tituloC">Contacto</h1>
                            <p class="white">Escríbenos, déjanos tu consulta.</p>
                            <ul>
                                <li class="contacto__li">
                                    <p class="white"><b>Encuéntranos en:</b></p>
                                    <p class="white"><a href="http:googlemaps.com" target="_blank"><i class="fas fa-map-marker-alt"></i></a> Bolivia, La Paz</p>
                                </li>
                                <li class="contacto__li">
                                    <p class="white"><b>Nuestros números de teléfono:</b></p>
                                    <p class="white"><a href="http:whatsapp.com" target="_blank"><i class="fab fa-whatsapp"></i></a> +591 74319582</p>
                                    <p class="white"><a href="http:whatsapp.com" target="_blank"><i class="fab fa-whatsapp"></i></a> +591 75840329</p>
                                    <p class="white"><a href="http:whatsapp.com" target="_blank"><i class="fab fa-whatsapp"></i></a> +591 78921634</p>
                                </li>
                                <li class="contacto__li">
                                    <p class="white"><b>Nuestro Email:</b></p>
                                    <p class="white"><a href="mailto:sanjosecon@gmail.com"><i class="fas fa-envelope"></i></a> sanjosecon@gmail.com</p>
                                </li>
                            </ul>
                            <!-- Formulario de contacto -->
                            <form action="mailto:emilianalila@gmail.com" method="post" enctype="text/plain" class="contacto__formulario">
                                <div class="divInp">
                                    <label class="white" for="nombre">Nombre</label>
                                <input class="contacto__input" type="text" id="nombre" name="nombre">
                                </div>
                                <div class="divInp">
                                    <label class="white" for="email">Email</label>
                                <input class="contacto__input" type="email" id="email" name="email">
                                </div>
                                <div class="divInp">
                                    <label class="white" for="telefono">Teléfono</label>
                                <input class="contacto__input" type="tel" id="telefono" name="telefono">
                                </div>
  
                                <textarea class="white" placeholder="Consulta" class="contacto__textarea" name="consulta"></textarea>
                                <br>
                                <!-- Botones de envío y restablecimiento -->
                                <div class="contacto__bottom">
                                    <input class="contacto__submit" type="submit" value="Enviar">
                                    <input class="contacto__restablecer" type="reset" value="Restablecer">
                                </div>
                            </form>
                        </section>
                    </div>
                </div>
                <!-- Carrusel de imágenes -->
                <div class="contactos-grid__container">
                    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="img-fluid" src="assets/images/envios6.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid" src="assets/images/envios73.png" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img class="img-fluid" src="assets/images/envios72.png" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Anterior</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Siguiente</span>
                        </button>
                    </div>
                </div>
            </section>

>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909
            <!-- Sección del mapa -->
            <section class="section-mapa">
                
                <div class="divContMapa">
                    <h2 class="tituloh2">Ubicacion</h2>
                    <div id="map" style="width: 500px; height: 300px;"></div>
                </div>
                    
                
                <script>
                    var map = L.map('map').setView([-16.556000, -68.208235], 15);
                    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
                    maxZoom: 19,
                    }).addTo(map);
                    L.marker([-16.55655469418163, -68.20823591777481]).addTo(map)
                            .bindPopup('Muebleria San Jose')
                            .openPopup();
                </script>
<<<<<<< HEAD
    <!-- Pie de página -->
    <footer class="contactos-footer">
        <div class="contactos-footer__container">
            <div>
                <p class="contactos-footer__texto">Derechos Reservados</p>
            </div>
            <!-- Formas de pago -->
            <div class="contactos-footer__targetas">
                <a class="footer__sombra" href="https://visa.com" target="_blank"><i class="fab fa-cc-visa"></i></a>
                <a class="footer__sombra" href="https://mastercard.com" target="_blank"><i class="fab fa-cc-mastercard"></i></a>
            </div>
        </div>
    </footer>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
=======
            </section>
        </main>

        <!-- Pie de página -->
        <footer class="contactos-footer">
            <div class="contactos-footer__container">
                <div>
                    <p class="contactos-footer__texto">Derechos Reservados</p>
                </div>
                <!-- Formas de pago -->
                <div class="contactos-footer__targetas">
                    <a class="footer__sombra" href="https://visa.com" target="_blank"><i class="fab fa-cc-visa"></i></a>
                    <a class="footer__sombra" href="https://mastercard.com" target="_blank"><i class="fab fa-cc-mastercard"></i></a>
                </div>
            </div>
        </footer>

        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://unpkg.co
>>>>>>> 6de98de038e78f12fc33a55da64efc7007d73909


