import { Component, OnInit } from '@angular/core';
import { VehiculoDTO } from './modelo/vehiculoDTO';
@Component({
  selector: 'app-gestion-vehiculos',
  templateUrl: './gestion-vehiculos.component.html'
})
export class GestionVehiculosComponent implements OnInit {

  public vehiculo: VehiculoDTO;

  constructor() { }

  ngOnInit() {
    this.vehiculo = { marca: 'Mandaz', placa: '', linea: '1', modelo: 0, idVehiculo: '2' };
  }
}
