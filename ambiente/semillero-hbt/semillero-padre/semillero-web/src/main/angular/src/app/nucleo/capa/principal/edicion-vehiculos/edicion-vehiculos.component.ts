import { Component, OnInit } from '@angular/core';
import { VehiculoEdicionDTO } from '../gestion-vehiculos/modelo/VehiculoEdicionDTO';
import { EdicionVehiculoService } from '../../../servicios/consulta-vehiculo-servicio/edicion.vehiculo.service'
@Component({
  selector: 'app-edicion-vehiculos',
  templateUrl: './edicion-vehiculos.component.html'
})
export class EdicionVehiculosComponent implements OnInit {

  /**
   * dto de vehiculo
   */
  public vehiculoDTO: VehiculoEdicionDTO;

  /**
   * Constructor
   * @param edicionVehiculoService 
   */
  constructor(private edicionVehiculoService: EdicionVehiculoService) {
  }

  ngOnInit() {
    this.vehiculoDTO = {  placa: '', modelo: 0, idVehiculo: '2' };
  }

  /**
   * Funcion encargada de editar un vehiculo
   */
  public editarVehiculo() {
    this.edicionVehiculoService.editarVehiculo(this.vehiculoDTO).subscribe(data => {
      this.vehiculoDTO = data;
    },
      error => {
        console.log(error);
      })
  }
}
