import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreacionPersonasComponent } from './nucleo/capa/principal/creacion-personas/creacion-personas.component';
import { ApoyoComponent } from './nucleo/capa/principal/apoyo/apoyo.component';
import { GestionVehiculosComponent } from './nucleo/capa/principal/gestion-vehiculos/gestion-vehiculos.component';
import { EdicionVehiculosComponent } from './nucleo/capa/principal/edicion-vehiculos/edicion-vehiculos.component';
const routes: Routes = [
	{   path: 'personas-crear',
	    component: CreacionPersonasComponent
  	},
  	{   path: 'componente-apoyo',
	    component: ApoyoComponent
  	},
  	{   path: 'vehiculos-gestion',
	    component: GestionVehiculosComponent
		},
		{   path: 'vehiculo-edicion',
		component: EdicionVehiculosComponent
	},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
