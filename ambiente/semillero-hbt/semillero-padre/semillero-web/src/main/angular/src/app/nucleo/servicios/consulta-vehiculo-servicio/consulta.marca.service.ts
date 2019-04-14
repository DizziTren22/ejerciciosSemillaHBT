import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from '../template.service';
import { VehiculoDTO } from '../../capa/principal/gestion-vehiculos/modelo/vehiculoDTO';
import { PersonaServicioDTO } from '../../capa/principal/gestion-vehiculos/modelo/personaServicioDTO';
import { MarcaDTO } from '../../capa/principal/gestion-vehiculos/modelo/MarcaDTO'
@Injectable({
    providedIn: 'root'
})

export class ConsultaMarcaService extends AbstractService {

    public marca: MarcaDTO;

    public marcas: MarcaDTO[];

    /**
   * Constructor
   */
    constructor(injector: Injector) {
        super(injector);
    }

    /**
     * Funcion encargada de consultar las marcas
     */
    public consultarMarcas() :  Observable<MarcaDTO[]> {
        return this.get<MarcaDTO[]>("/semillero-servicios", "/ConsultasRest/consultarMarcas");
    }
}