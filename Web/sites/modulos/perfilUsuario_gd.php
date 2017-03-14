<div id="page-wrapper">
    <div class="main-page">

            <div class="row">
                <div class="col-md-12" id="tabs">
                    <ul>
                        <li><a href="#tabs-1">Información Personal</a></li>
                        <li><a href="#tabs-2">Código Identificador</a></li>
                        <li><a href="#tabs-3">Avatar</a></li>

                    </ul>
                    <div id="tabs-1">
                        <form method="post" role="form" id="formularioInfo">
                            <div class="form-group">
                            <label class="control-label">Nombre</label>
                            <input name="nombre" type="text" class="form-control" value="Gimnasio 1"/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Domicilio</label>
                            <input name="domicilio" type="text" class="form-control" value="C/Camino de Ronda Nº21"/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Población</label>
                            <input name="poblacion" type="text" class="form-control" value="Granada"/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Provincia</label>
                            <input name="provincia" type="text" class="form-control" value="Granada"/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Código postal</label>
                            <input name="cpostal" type="text" class="form-control" value="18001"/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Teléfono</label>
                            <input name="tlf" type="text" class="form-control" value="958452174"/>
                            </div>
                           <div class="form-group">
                            <label class="control-label">Email</label>
                            <input name="email" type="text" class="form-control" value="gimnasio@gmail.com"/>
                            </div>
                            <br/>
                            <button type="submit" class="btn hvr-radial-out"> Guardar cambios </button>
                        </form>
                    </div>
                    <div id="tabs-2">
                        <label class="control-label">Código para app</label>
                        <input disabled type="text" class="form-control" value="123"/>
                    </div>
                    <div id="tabs-3">
                        <img src="images/user.png" style="width: 250px; height: 150px"/>
                        <form method="post" action="" role="form" id="formularioLogoActualizar" enctype="multipart/form-data">
                            <div class="fileUpload btn hvr-radial-out">
                                <span>Selecionar Logo</span>
                                <input class="upload" type="file" required/>
                            </div>
                            <br/>
                            <button id="actualizaLogo" type="submit" class="btn hvr-radial-out"> Actualizar logo </button>                                             
                        </form>
                        <br/>
                        <form method="post" action="" id="formularioLogoBorrar" >
                            <button type="submit" class="btn hvr-radial-out"> Eliminar </button>                                                 
                        </form>
                    
                </div>
            </div>
        </div>
    </div>
</div>