import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from '../template.service';
import { PersonaServicioDTO } from '../../capa/principal/gestion-vehiculos/modelo/personaServicioDTO';

@Injectable({
    providedIn: 'root'
})

export class CrearPersonaService extends AbstractService {

    /**
   * Constructor
   */
    constructor(injector: Injector) {
        super(injector);
    }

    /**
     * Funcion encargada de crear una persona
     * @param personaDTO 
     */
    public crearPersona(personaDTO : PersonaServicioDTO) :  Observable<PersonaServicioDTO> {
        return this.post("/semillero-servicios", "/ConsultasRest/crearPersona",personaDTO);
    }
}