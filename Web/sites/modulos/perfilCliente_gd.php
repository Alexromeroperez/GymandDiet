<div id="page-wrapper">
    <div class="main-page">
        <div class="row">
               <div class="col-md-12" id="tabs">
                    <ul>
                        <li><a href="#tabs-1">Información del Cliente</a></li>
                        <li><a href="#tabs-2">Rutina</a></li>
                        <li><a href="#tabs-3">Dieta</a></li>

                    </ul>
                    <div id="tabs-1">
                        <div class="col-md-3">
                        <img src="images/user.png" style="width: 200px; height: 150px"/>
                        <form method="post" action="" role="form" id="formFotoActualizar" enctype="multipart/form-data">
                            <div class="fileUpload btn hvr-radial-out">
                                <span>Selecionar Foto</span>
                                <input class="upload" type="file" required/>
                            </div>
                            <br/>
                            <button id="actualizaLogo" type="submit" class="btn hvr-radial-out"> Actualizar foto </button>                                             
                        </form>
                        <br/>
                        <form method="post" action="" id="formFotoBorrar" >
                            <button type="submit" class="btn hvr-radial-out"> Eliminar foto</button>                                                 
                        </form>
                        </div>
                        <div class="col-md-9">
                        <form method="post" role="form" id="formCliente">
                            <div class="form-group">
                            <label class="control-label">Nombre</label>
                            <input name="nombreC" type="text" class="form-control" value=""/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Email</label>
                            <input name="emailC" type="email" class="form-control" value=""/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Fecha pago</label>
                            <input name="fechaPago" type="date" class="form-control" value=""/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Peso</label>
                            <input name="peso" type="text" class="form-control" value=""/>
                            </div>
                            <div class="form-group">
                            <label class="control-label">Altura</label>
                            <input name="altura" type="text" class="form-control" value=""/>
                            </div>
                           
                            <br/>
                            <button type="submit" class="btn hvr-radial-out"> Guardar cambios </button>
                        </form>
                        </div>
                    </div>
                   
                    <div id="tabs-2">
                        <ul>
                            <a href="index.php?m=rutina">Lunes</a>
                            <li>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                            </li>
                        </ul>
                        <ul>
                            <a href="#">Martes</a>
                            <li>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                               
                            </li>
                        </ul>
                        <ul>
                            <a href="#">Miercoles</a>
                            <li>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                            </li>
                        </ul>
                        <ul>
                            <a href="#">Jueves</a>
                            <li>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                            </li>
                        </ul>
                        <ul>
                            <a href="#">Viernes</a>
                            <li>
                                
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                            </li>
                        </ul>
                        <ul>
                            <a href="#">Sabado</a>
                            <li>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                            </li>
                        </ul>
                        <ul>
                            <a href="#">Domingo</a>
                            <li>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                              
                                <img style="width: 100px" src="images/ejercicios/sinejer.jpg"/> <span> Pecho -></span> <span> 3x10 </span>
                            </li>
                        </ul>
                    </div>
                   
                    <div id="tabs-3">
                        <div class="row">
                            <ul>Lunes<br/>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Desayuno</a>
                                <li>Leche -> 200ml/te</li>
                                <li>Tostada Aceite-> 1</li>
                                
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Media-Mañana</a>
                                <li>Manzana -> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Almuerzo</a>
                                <li>Pollo a la plancha -> 250g</li>
                                <li>Melocotón-> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Merienda</a>
                                <li>Te -> 1 vaso</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Cena</a>
                                <li>Ensalada de pasta -> 250g</li>
                                </li>
                                </div>
                            </ul>
                        </div>
                        <div class="row">
                            <ul>Martes<br/>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Desayuno</a>
                                <li>Leche -> 200ml/te</li>
                                <li>Tostada Aceite-> 1</li>
                                
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Media-Mañana</a>
                                <li>Manzana -> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Almuerzo</a>
                                <li>Pollo a la plancha -> 250g</li>
                                <li>Melocotón-> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Merienda</a>
                                <li>Te -> 1 vaso</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Cena</a>
                                <li>Ensalada de pasta -> 250g</li>
                                </li>
                                </div>
                            </ul>
                        </div>
                        <div class="row">
                            <ul>Miercoles<br/>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Desayuno</a>
                                <li>Leche -> 200ml/te</li>
                                <li>Tostada Aceite-> 1</li>
                                
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Media-Mañana</a>
                                <li>Manzana -> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Almuerzo</a>
                                <li>Pollo a la plancha -> 250g</li>
                                <li>Melocotón-> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Merienda</a>
                                <li>Te -> 1 vaso</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Cena</a>
                                <li>Ensalada de pasta -> 250g</li>
                                </li>
                                </div>
                            </ul>
                        </div>
                        <div class="row">
                            <ul>Jueves<br/>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Desayuno</a>
                                <li>Leche -> 200ml/te</li>
                                <li>Tostada Aceite-> 1</li>
                                
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Media-Mañana</a>
                                <li>Manzana -> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Almuerzo</a>
                                <li>Pollo a la plancha -> 250g</li>
                                <li>Melocotón-> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Merienda</a>
                                <li>Te -> 1 vaso</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Cena</a>
                                <li>Ensalada de pasta -> 250g</li>
                                </li>
                                </div>
                            </ul>
                        </div>
                        <div class="row">
                            <ul>Viernes<br/>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Desayuno</a>
                                <li>Leche -> 200ml/te</li>
                                <li>Tostada Aceite-> 1</li>
                                
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Media-Mañana</a>
                                <li>Manzana -> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Almuerzo</a>
                                <li>Pollo a la plancha -> 250g</li>
                                <li>Melocotón-> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Merienda</a>
                                <li>Te -> 1 vaso</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Cena</a>
                                <li>Ensalada de pasta -> 250g</li>
                                </li>
                                </div>
                            </ul>
                        </div>
                        <div class="row">
                            <ul>Sabado<br/>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Desayuno</a>
                                <li>Leche -> 200ml/te</li>
                                <li>Tostada Aceite-> 1</li>
                                
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Media-Mañana</a>
                                <li>Manzana -> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Almuerzo</a>
                                <li>Pollo a la plancha -> 250g</li>
                                <li>Melocotón-> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Merienda</a>
                                <li>Te -> 1 vaso</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Cena</a>
                                <li>Ensalada de pasta -> 250g</li>
                                </li>
                                </div>
                            </ul>
                        </div>
                        <div class="row">
                            <ul>Domingo<br/>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Desayuno</a>
                                <li>Leche -> 200ml/te</li>
                                <li>Tostada Aceite-> 1</li>
                                
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Media-Mañana</a>
                                <li>Manzana -> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Almuerzo</a>
                                <li>Pollo a la plancha -> 250g</li>
                                <li>Melocotón-> 1</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Merienda</a>
                                <li>Te -> 1 vaso</li>
                                </li>
                                </div>
                                <div class="col-md-2">
                                <li>
                                <a href="#">Cena</a>
                                <li>Ensalada de pasta -> 250g</li>
                                </li>
                                </div>
                            </ul>
                        </
                       
                    </div>
            </div>
            </div>
        </div>
    </div>
</div>
</div>