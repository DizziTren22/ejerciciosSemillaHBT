import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CapaComponent } from './capa/capa.component';
import { EncabezadoComponent } from './capa/encabezado/encabezado.component';
import { PrincipalComponent } from './capa/principal/principal.component';
import { PiePaginaComponent } from './capa/pie-pagina/pie-pagina.component';
import { CreacionPersonasComponent } from './capa/principal/creacion-personas/creacion-personas.component';
import { ApoyoComponent } from './capa/principal/apoyo/apoyo.component';
import { FormsModule } from '@angular/forms';
import { GestionVehiculosComponent } from './capa/principal/gestion-vehiculos/gestion-vehiculos.component';
import { FiltrosComponent } from './capa/principal/gestion-vehiculos/filtros/filtros.component';
import { ResultadosComponent } from './capa/principal/gestion-vehiculos/resultados/resultados.component';
import { ConsultaVehiculosService } from './servicios/consulta-vehiculo-servicio/consulta.vehiculo.service'
import { ConsultaMarcaService } from './servicios/consulta-vehiculo-servicio/consulta.marca.service'
import {  ConsultaLineaService } from './servicios/consulta-vehiculo-servicio/consulta.linea.service';
import { EdicionVehiculosComponent } from './capa/principal/edicion-vehiculos/edicion-vehiculos.component'

//Nucleo representa al modulo que va a contener los componentes que van a orquestar la aplicacion 
//Debe ser importado en el componente principal AppModule
@NgModule({
  declarations: [CapaComponent, EncabezadoComponent, PrincipalComponent, PiePaginaComponent, CreacionPersonasComponent, ApoyoComponent, GestionVehiculosComponent, FiltrosComponent, ResultadosComponent, EdicionVehiculosComponent],
  imports: [
    CommonModule,RouterModule,FormsModule
  ],
  exports: [
  	CapaComponent
  ],
  providers: [
      ConsultaVehiculosService,
      ConsultaLineaService,
      ConsultaMarcaService
  ]
})
export class NucleoModule { }
