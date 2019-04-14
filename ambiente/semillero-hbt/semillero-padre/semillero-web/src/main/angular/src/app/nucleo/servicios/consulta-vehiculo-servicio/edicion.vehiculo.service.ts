import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from '../template.service';
import { VehiculoEdicionDTO } from '../../capa/principal/gestion-vehiculos/modelo/VehiculoEdicionDTO';
import { PersonaServicioDTO } from '../../capa/principal/gestion-vehiculos/modelo/personaServicioDTO';

@Injectable({
    providedIn: 'root'
})

export class EdicionVehiculoService extends AbstractService {

    /**
   * Constructor
   */
    constructor(injector: Injector) {
        super(injector);
    }

    /**
     * Funcion encargada de editar una vehiculo
     * @param vehiculoDTO 
     */
    public editarVehiculo(vehiculoDTO : VehiculoEdicionDTO) :  Observable<VehiculoEdicionDTO> {
        return this.put("/semillero-servicios", "/ConsultasRest/editarVehiculo",vehiculoDTO);
    }
}