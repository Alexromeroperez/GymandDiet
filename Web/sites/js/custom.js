$(document).ready(function () {

    $("#tabs").tabs();
    animacion();
    tamaño();
    informacion();
    registroBar();

    if ($('#tablaEjercicios').length) {
        tablaEjercicios();
    }
    if ($('#tablaClientes').length) {
        tablaClientes();
    }
    if ($('#tablaComidas').length) {
        tablaComidas();
    }
    $(function () {
        $('#side-menu').metisMenu();
    });

    function informacion() {

        $('#formularioInfo').formValidation({
            message: 'Valor inválido',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nombre: {
                    validators: {
                        notEmpty: {
                            message: 'El campo nombre es obligatorio'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'El campo email es obligatorio'
                        },
                        emailAddress: {
                            message: 'Dirección de email no válida'
                        }
                    }
                },
                poblacion: {
                    validators: {
                        notEmpty: {
                            message: 'El campo población es obligatorio'
                        }
                    }
                },
                domicilio: {
                    validators: {
                        notEmpty: {
                            message: 'El campo domicilio es obligatorio'
                        }
                    }
                },
                provincia: {
                    validators: {
                        notEmpty: {
                            message: 'El campo provincia es obligatorio'
                        }
                    }
                },
                tlf: {
                    validators: {
                        notEmpty: {
                            message: 'El campo teléfono es obligatorio'
                        }, integer: {
                            message: 'Debe ser un número'
                        },
                        stringLength: {
                            max: 9,
                            message: '9 números máximo'
                        }
                    }
                },
                cpostal: {
                    validators: {
                        notEmpty: {
                            message: 'El campo código postal es obligatorio'
                        }, integer: {
                            message: 'Debe ser un número'
                        },
                        stringLength: {
                            max: 5,
                            message: '5 números máximo'
                        }
                    }
                }
            }
        }).on('success.form.fv', function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: "",
                data: $("#formularioInfo").serialize(),
                success: function (respuesta) {
                    if (respuesta == "ok") {
                        $(".respuestaContacto").append("<div class='alert alert-success' role='alert'><i class='icon-trophy'></i><span><strong>¡Perfecto!</strong> Cambios realizados.</span></div>");
                    } else {
                        $(".respuestaContacto").append("<div class='alert alert-danger' role='alert'><i class='icon-sad'></i><span><strong>¡ohh!</strong> Ha habido algún error, contacte con info@ecope.es.</span></div>");
                    }
                }
            });
            return false;
        });
    }

    function tamaño() {
        $(window).bind("load resize", function () {
            topOffset = 50;
            width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
            if (width < 768) {
                $('div.navbar-collapse').addClass('collapse');
                topOffset = 100; // 2-row-menu
            } else {
                $('div.navbar-collapse').removeClass('collapse');
            }

            height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
            height = height - topOffset;
            if (height < 1)
                height = 1;
            if (height > topOffset) {
                $("#page-wrapper").css("min-height", (height) + "px");
            }
        });

        var url = window.location;
        var element = $('ul.nav a').filter(function () {
            return this.href == url || url.href.indexOf(this.href) == 0;
        }).addClass('active').parent().parent().addClass('in').parent();
        if (element.is('li')) {
            element.addClass('active');
        }
    }

    function animacion() {
        var menuLeft = document.getElementById('cbp-spmenu-s1'),
                showLeftPush = document.getElementById('showLeftPush'),
                body = document.body;

        showLeftPush.onclick = function () {
            classie.toggle(this, 'active');
            classie.toggle(body, 'cbp-spmenu-push-toright');
            classie.toggle(menuLeft, 'cbp-spmenu-open');
            disableOther('showLeftPush');
        };


        function disableOther(button) {
            if (button !== 'showLeftPush') {
                classie.toggle(showLeftPush, 'disabled');
            }
        }
    }

    function registroBar() {
        data = {
            'Enero': 300,
            'Febrero': 270,
            'Marzo': 280,
            'Abril': 300,
            'Mayo': 320,
            'Junio': 350,
            'Julio': 320,
            'Agosto': 330,
            'Septiembre': 300,
            'Octubre': 280,
            'Noviembre': 270,
            'Diciembre': 250
        };
        $("#chart2").faBoChart({
            time: 2500,
            animate: true,
            data: data,
            straight: true,
            labelTextColor: "#C0392B",
        });

    }

    function tablaClientes() {
        var table = $('#tablaClientes').DataTable({
            dom: "lfrtip",
            iDisplayLength: 10,
            processing: true,
            serverSide: true,
            select: true,
            ajax: "../acciones/phpClientes.php",
            columnDefs: [
                {
                    "targets": [0],
                    "visible": false,
                    "searchable": false
                },
                {
                    "targets": [1],
                    "visible": false,
                    "searchable": false
                },
                {
                    targets: [2],
                    render: function (data, type, row) {
                        // Combine the first and last names into a single table field
                        return '<img style="height:100px; width=100%;" src="images/foto/' + row[2] + '">';
                    }
                },
                {
                    targets: [8],
                    render: function (data, type, row) {
                        // Combine the first and last names into a single table field
                        return '<a href="index.php?m=cliente&id=' + row[0] + '">Ver más</a>';
                    }
                }
            ]

        });
    }

    function tablaEjercicios() {
        var table = $('#tablaEjercicios').DataTable({
            dom: "lfrtip",
            iDisplayLength: 10,
            processing: true,
            serverSide: true,
            select: true,
            ajax: "../acciones/phpEjercicios.php?gm=" + $('#tablaEjercicios').attr('class').split(' ')[1],
            columnDefs: [
                {
                    "targets": [0],
                    "visible": false,
                    "searchable": false
                },
                {
                    "targets": [3],
                    "visible": false,
                    "searchable": false
                },
                {
                    "targets": [4],
                    "visible": false,
                    "searchable": false
                },
                {
                    targets: [1],
                    render: function (data, type, row) {
                        // Combine the first and last names into a single table field
                        return '<img style="height:200px; width=100%;" src="images/ejercicios/' + row[1] + '">';
                    }
                },
                {
                    targets: [5],
                    render: function (data, type, row) {
                        // Combine the first and last names into a single table field
                        return '<a href="">Modificar</a>';
                    }
                },
                {
                    targets: [6],
                    render: function (data, type, row) {
                        // Combine the first and last names into a single table field
                        return '<a href="../acciones/phpBorrarEjercicio.php?id=' + row[0] + '&gm=' + $('#tablaEjercicios').attr('class').split(' ')[1] + '">Eliminar</a>';
                    }
                }
            ]

        });
    }

    function tablaComidas() {
        var table = $('#tablaComidas').DataTable({
            dom: "lfrtip",
            iDisplayLength: 10,
            processing: true,
            serverSide: true,
            select: true,
            ajax: "../acciones/phpComidas.php?cat=" + $('#tablaComidas').attr('class').split(' ')[1],
            columnDefs: [
                {
                    "targets": [0],
                    "visible": false,
                    "searchable": false
                },
                {
                    "targets": [2],
                    "visible": false,
                    "searchable": false
                },
                {
                    "targets": [3],
                    "visible": false,
                    "searchable": false
                },
                {
                    targets: [4],
                    render: function (data, type, row) {
                        // Combine the first and last names into a single table field
                        return '<a href="">Modificar</a>';
                    }
                },
                {
                    targets: [5],
                    render: function (data, type, row) {
                        // Combine the first and last names into a single table field
                        return '<a href="../acciones/phpBorrarComida.php?id=' + row[0] + '&cat=' + $('#tablaComidas').attr('class').split(' ')[1] + '">Eliminar</a>';
                    }
                }
            ]

        });
    }
});