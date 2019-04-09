import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApoyoComponent } from '../app/nucleo/capa/principal/apoyo/apoyo.component'
import { CreacionPersonasComponent } from '../app/nucleo/capa/principal/creacion-personas/creacion-personas.component'
import { GestionPersonaComponent } from '../app/nucleo/capa/principal/gestion-persona/gestion-persona.component'
import { ModificacionPersonaComponent } from '../app/nucleo/capa/principal/modificacion-persona/modificacion-persona.component'
const routes: Routes = [
	{
		path: 'personas-crear',
		component: CreacionPersonasComponent
	},
	{
		path: 'componente-apoyo',
		component: ApoyoComponent
	},
	{
		path: 'personas-gestion',
		component: GestionPersonaComponent
	},
	{
		path: 'personas-edicion',
		component: ModificacionPersonaComponent
	},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
