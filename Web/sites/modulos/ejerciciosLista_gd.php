
<div id="page-wrapper">
    <div class="main-page">
        
        <div class="row">
            <div class="panel panel-widget col-md-12">
                <input class="btn hvr-radial-out anadir" type="button" value="Añadir"/>
                <table id="tablaEjercicios" <?php echo 'class="display '.Peticion::get('gm').'"';?> cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Imagen</th>
                            <th>Nombre</th>
                            <th></th>
                            <th></th>
                            <th class="enlace"></th>
                            <th class="enlace"></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Imagen</th>
                            <th>Nombre</th>
                            <th></th>
                            <th></th>
                            <th class="enlace"></th>
                            <th class="enlace"></th>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>
