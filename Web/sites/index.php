<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<?php
function autocarga($clase) {
    include '../clases/' . $clase . '.php';
}
spl_autoload_register('autocarga');
$contenido=  Peticion::get("m");
$bd = new BaseDatos();
$gestorGrupomuscular=new GestorGrupo_muscular($bd);
$gestorCategorias=new GestorCategoria($bd);
?>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Gym & Diet</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Baxster Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <link rel="icon" href="favicon.ico" type="image/x-icon" >
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/jqcandlestick.css" />
        <link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
        <link href="css/hover.css" rel="stylesheet" type="text/css" >
        <!--Tabs-->
        <link rel="stylesheet" href="css/jquery-ui.min.css">
        <link rel="stylesheet" href="css/jquery-ui.theme.min.css">
        <!--Tabs-->
        <link href="css/formValidation.min.css" rel="stylesheet" type="text/css">
        <link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
        <link href="css/fabochart.css" rel="stylesheet" type="text/css">
       
        <link href="css/custom.css" rel="stylesheet">
    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <!--left-fixed -navigation-->
            <div class="sidebar" role="navigation">
                <div class="navbar-collapse">
                    <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right dev-page-sidebar mCustomScrollbar _mCS_1 mCS-autoHide mCS_no_scrollbar" id="cbp-spmenu-s1">
                        <div class="scrollbar scrollbar1">
                            <ul class="nav" id="side-menu">
                                <li>
                                    <a href="index.php" class="active"><i class="fa fa-home nav_icon"></i>Menú Principal</a>
                                </li>
                                <li>
                                    <a href="index.php?m=perfilUsuario"><i class="fa fa-user nav_icon"></i>Perfil</a>
                                            <!--<a href="index.php?m=perfilAvatar">Avatar</a>
                                            <a href="index.php?m=perfilCodigo">Código de Identificación</a>
                                    <!-- /nav-second-level -->
                                </li>
                                <li>
                                    <a href="index.php?m=clientes"><i class="fa fa-users nav_icon"></i>Clientes</a>
                                    <!-- /nav-second-level -->
                                </li>
                                <li> <a href=""><i class="fa fa-heart nav_icon"></i>Ejercicios <span class="fa arrow"></span></a> 
                                    <ul class="nav nav-second-level collapse">
                                        <?php 
                                            $musculos=$gestorGrupomuscular->getGrupoMusculares();
                                            foreach ($musculos as $grupo){?>
                                                <li>
                                                    <a href="index.php?m=ejerciciosLista&gm=<?php echo $grupo->getId();?>"><?php echo $grupo->getGrupo_muscular();?></a>
                                                </li>   
                                        <?php
                                            }
                                        ?>
                                    </ul>
                                </li>
                                <li> <a href="#"><i class="fa fa-coffee nav_icon"></i>Comidas <span class="fa arrow"></span></a> 
                                    <ul class="nav nav-second-level collapse">
                                        <?php 
                                            $categorias=$gestorCategorias->getCategorias();
                                            foreach ($categorias as $categoria){?>
                                                <li>
                                                    <a href="index.php?m=comidaLista&cat=<?php echo $categoria->getId();?>"><?php echo $categoria->getCategoria();?></a>
                                                </li>   
                                        <?php
                                            }
                                        ?>
                                    </ul>
                                </li>
                                <li> <a href="index.php?m=contacta"><i class="fa fa-envelope nav_icon"></i> Ponte en contacto</a> </li>
                                <li> <a href="#"><i class="fa fa-sign-out nav_icon"></i> Cerrar Sesión</a> </li>
                            </ul>
                        </div>
                        <!-- //sidebar-collapse -->
                    </nav>
                </div>
            </div>
            <!--left-fixed -navigation-->

            <!-- header-starts -->
            <div class="sticky-header header-section ">
                <div class="header-left">
                    <!--logo -->
                    <div class="logo">
                        <a href="index.php">
                            <ul>	
                                <li><img src="images/logo1.png" alt="" /></li>
                                <li><h1>Gym & Diet</h1></li>
                                <div class="clearfix"> </div>
                            </ul>
                        </a>
                    </div>
                    <!--//logo-->

                </div>
                <div class="header-right">

                    <!--notification menu end -->
                    <div class="profile_details">		
                        <div class="profile_img">	
                            <span class="prfil-img"><img src="images/a.png" alt=""> </span> 
                            <div class="clearfix"></div>	
                        </div>	
                    </div>
                    <!--toggle button start-->
                    <button id="showLeftPush"><i class="fa fa-bars"></i></button>
                    <!--toggle button end-->
                    <div class="clearfix"> </div>				
                </div>
            </div>
            <!-- //header-ends -->
            <!-- main content start-->
            <?php include Constantes::$rutaModulos.Util::contenido($contenido); ?>
            <!-- main content start-->
            <!--footer-->
            <div class="dev-page">

                <!-- page footer -->   
                <!-- dev-page-footer-closed dev-page-footer-fixed -->
                <div class="dev-page-footer dev-page-footer-fixed"> 
                    <!-- container -->
                    <div class="container">
                        <div class="copyright">
                            <p>© 2016 Gym & Diet . All Rights Reserved Alejandro Romero Perez</p> 
                        </div>
                        <!-- page footer buttons -->
                        <ul class="dev-page-footer-buttons">                    
                            <li><a href="#footer_content_3" class="dev-page-footer-container-open"><span class="glyphicon glyphicon-cloud " aria-hidden="true"></span></a></li>
                        </ul>
                        <!-- //page footer buttons -->
                        <!-- page footer container -->
                        <div class="dev-page-footer-container">

                            <!-- loader and close button -->
                            <div class="dev-page-footer-container-layer">
                                <a href="#" class="dev-page-footer-container-layer-button"></a>
                            </div>
                            <!-- //loader and close button -->                    

                            <!-- informers -->

                            <!-- //informers -->

                            <!-- projects -->
                            <div class="dev-page-footer-container-content" id="footer_content_3">                        
                                <div class="social">

                                    <div class="col-md-4 top-comment-grid">
                                        <div class="comments likes">
                                            <div class="comments-icon">
                                                <i class="fa fa-facebook"></i>
                                            </div>
                                            <div class="comments-info likes-info">
                                                <h3>2150</h5>
                                                    <a href="#">Likes</a>
                                            </div>
                                            <div class="clearfix"> </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 top-comment-grid">
                                        <div class="comments tweets">
                                            <div class="comments-icon">
                                                <i class="fa fa-twitter"></i>
                                            </div>
                                            <div class="comments-info tweets-info">
                                                <h3>325</h5>
                                                    <a href="#">Tweets</a>
                                            </div>
                                            <div class="clearfix"> </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 top-comment-grid">
                                        <div class="comments views">
                                            <div class="comments-icon">
                                                <i class="fa fa-google-plus"></i>
                                            </div>
                                            <div class="comments-info views-info">
                                                <h3>471</h5>
                                                    <a href="#">Follows</a>
                                            </div>
                                            <div class="clearfix"> </div>
                                        </div>
                                    </div>
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                            <!-- //projects -->
                        </div>
                        <!-- //page footer container -->

                    </div>
                    <!-- //container -->
                </div>
                <!-- /page footer -->
            </div>
            <!--//footer-->
        </div>
        <script src="js/wow.min.js"></script>
        <script>
            new WOW().init();
        </script>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/modernizr.custom.js"></script>
        <script src="js/metisMenu.min.js"></script>
        <script src="js/Chart.js"></script>
        <script src="js/classie.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/dev-loaders.js"></script>
        <script type="text/javascript" src="js/dev-layout-default.js"></script>
        <script type="text/javascript" src="js/jquery.marquee.js"></script>
        <script type="text/javascript" src="js/jquery.jqcandlestick.min.js"></script>
        <script type="text/javascript" src="js/plugins.js"></script>
        <script src="js/jquery.nicescroll.js"></script>
        <script src="js/scripts.js"></script>
        <script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
        <script language="javascript" type="text/javascript" src="js/jquery.flot.errorbars.js"></script>
        <script language="javascript" type="text/javascript" src="js/jquery.flot.navigate.js"></script>
        <script src="js/formValidation.min.js"></script>
        <script src="js/formValidation.popular.min.js"></script>
        <script src="js/framework/bootstrap.min.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="js/jquery.fn.gantt.js"></script>
        <script src="../plugins/fancybox/source/jquery.fancybox.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/fabochart.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>