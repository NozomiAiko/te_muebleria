<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Muebleria San Jose - Servicios</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;0,500;1,300;1,400&display=swap" rel="stylesheet">
    <!-- AOS -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <!-- link bootstrap -->
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- logo en mi titulo -->
        <link rel="shortcut icon" href="assets/images/logotitulo.png">
    <meta name="description" content="Es una empresa que ofrece muebles de madera para el hogar, tiene dise�os exclusivos y muebles hechos a medida.">
    <meta name="keywords" content="muebles, servicios, envios, instalaciones, madera, dise�os, hogar">
</head>

<body>
      <jsp:include page="WEB-INF/menu.jsp"></jsp:include>
    <main>
        <section class="servicios-grid">
            <div class="servicios-grid__container1">
                <p class="botton">
                    Clasifique, organice y arregle el almacenamiento que deja espacio para todo lo que ama. <br>Encuentre los h�roes del almacenamiento que simplifican la vida cotidiana e insp�rese para comenzar.<br>
                </p>
            </div>
            <div class="servicios-grid__container2">
                <img src="assets/images/naranja2.png" alt="">
                <h1 id="textoservicios">Env�os<br><a class="relative" href="#" title=""><i data-aos="fade-right" data-aos-offset="400" data-aos-easing="ease-in-sine" class="fas fa-truck"></i></a></h1>
            </div>
            <div data-aos="flip-left" data-aos-easing="ease-out-cubic" data-aos-duration="2000" class="servicios-grid__container">
                <img src="assets/images/serviciosimagen.png" alt="">
            </div>
            <div class="servicios-grid__container9">
                <h2 class="titulo9">Recogida en la tienda<i class="fas fa-warehouse"></i></h2>
                <p class="titulo91">El pedido se recoge en el almac�n dentro del intervalo de tiempo reservado y a m�s tardar 24 horas despu�s.</p>
            <img class="img-fluid foto" src="assets/images/entrega.png" width="110" alt="">
            </div>
            <div data-aos="zoom-in-down" class="servicios-grid__container">
                <img src="assets/images/medio.png" alt="">
            </div>
            <div class="servicios-grid__container6">
                <p class="botton">
                    Los paquetes planos son f�ciles de transportar, pero estaremos encantados de ayudarle con la entrega.<br>
                    Ten en cuenta que el precio de env�o var�a y depende, entre otras cosas, de lo que pidas y de d�nde vivas. Cuando ingresa su direcci�n postal al finalizar la compra, siempre obtiene el precio de env�o exacto.<br>
                    <a class="relative" href="#" title=""><i class="fas fa-truck"></i></a></p>
            </div>
            <div data-aos="fade-right" class="servicios-grid__container">
                <img src="assets/images/serviciosimagen.png" alt=""></div>
            <div class="servicios-grid__container8">
                <img class="img-fluid" src="assets/images/imagenenvios.png" alt="...">
                <h3 class="titulo8"><i class="fas fa-people-carry"></i> Entrega a domicilio</h3>
                <p class="titulo82">El pedido se entrega dentro de la casa o departamento, en el lugar que usted especifique.</p>
            </div>
            <div class="servicios-grid__container">
                <video video-fluid data-object-fit="cover" src="https://www.ikea.com/pvid/0767047_fe001078.mp4?imwidth=1280" autoplayloop controls="autoplayloop"></video>
            </div>
        </section>
    </main>
    <footer class="servicio-footer">
        <div class="servicio-footer__container">
            <div>
                <p class="servicio-footer__texto">Derechos Reservados</p>
            </div>
            <!-- formas de pago -->
            <div class="servicio-footer__targetas">
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
