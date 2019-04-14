import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from '../template.service';
import { MarcaDTO } from '../../capa/principal/gestion-vehiculos/modelo/MarcaDTO'
import { LineaDTO } from '../../capa/principal/gestion-vehiculos/modelo/LineaDTO';
@Injectable({
    providedIn: 'root'
})

export class ConsultaLineaService extends AbstractService {

    public linea: LineaDTO;

    public lineas: LineaDTO[];

    /**
   * Constructor
   */
    constructor(injector: Injector) {
        super(injector);
    }

    /**
     * Funcion encargada de consultar las lineas
     * @param idMarca 
     */
    public consultarLineas(idMarca: number) :  Observable<LineaDTO[]> {
        return this.get<LineaDTO[]>("/semillero-servicios", "/ConsultasRest/consultarLineasPorMarca",{
            "idMarca":idMarca.toString()
        });
    }
}