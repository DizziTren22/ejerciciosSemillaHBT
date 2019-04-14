import { Component, Input, OnInit } from '@angular/core';
import { ConsultaVehiculosService } from '../../../../../nucleo/servicios/consulta-vehiculo-servicio/consulta.vehiculo.service'
import { VehiculoDTO } from '../modelo/vehiculoDTO';
import { PersonaServicioDTO } from '../modelo/personaServicioDTO';
import { MarcaDTO } from '../modelo/MarcaDTO';
import { ConsultaMarcaService } from '../../../../servicios/consulta-vehiculo-servicio/consulta.marca.service';
import { LineaDTO } from '../modelo/LineaDTO';
import { ConsultaLineaService } from '../../../../servicios/consulta-vehiculo-servicio/consulta.linea.service';
@Component({
  selector: 'app-resultados',
  templateUrl: './resultados.component.html'
})
export class ResultadosComponent implements OnInit {

  @Input() public marca: string;
  @Input() public placa: string;

  /**
   * lista de vehiculo
   */
  public listaVehiculoDTO: VehiculoDTO[];

  /**
   * Declaracion del dto de vehiculo
   */
  public vehiculoDTO: VehiculoDTO;

  /**
  * lista de persona
  */
  public listaPersonasDTO: PersonaServicioDTO[];

  /**
 * Declaracion del dto de persona
 */
  public personaDTO: PersonaServicioDTO;

  /**
  * lista de marca
  */
  public listaMarca: MarcaDTO[];

  /**
 * Declaracion del dto de marca
 */
  public marcaDTO: MarcaDTO;

  /**
  * lista de linea
  */
  public listaLinea: LineaDTO[];

  /**
 * Declaracion del dto de linea
 */
  public lineaDTO: LineaDTO;

  /**
   * Id de marca
   */
  private idMarca: number;

  /**
   * constructor
   * @param vehiculosService 
   * @param marcaService 
   * @param lineaService 
   */
  constructor(private vehiculosService: ConsultaVehiculosService,
    private marcaService: ConsultaMarcaService,
    private lineaService: ConsultaLineaService) { }

  ngOnInit() {
    this.consultarMarca();
    this.consultarLinea();
  }

  /**
   * Funcion encargada de consultar las personas
   */
  public consultarPersonas() {
    let tipoID: string = '1';
    let numID: string = '123';
    this.vehiculosService.consultarPersonas(tipoID, numID).subscribe(
      personas => {
        this.listaPersonasDTO = personas;
      },
      error => {
        console.log(error);
      }
    );
    console.log('resultado servicio.... ' + this.listaPersonasDTO)
  }

  /**
   * Funcion encargada de consultar las marcas
   */
  public consultarMarca() {

    this.marcaService.consultarMarcas().subscribe(
      marcas => {
        this.listaMarca = marcas;
      },
      error => {
        console.log(error);
      }
    );
    console.log('resultado servicio.... ' + this.listaMarca)
  }

  /**
   * Funcion encargada de consultar la linea
   */
  public consultarLinea() {
    this.idMarca = 2;
    this.lineaService.consultarLineas(this.idMarca).subscribe(
      linea => {
        this.listaLinea = linea;
        console.log("es la linea" + this.listaLinea);
      },
      error => {
        console.log(error);
      }
    );
  }

  /**
   * Funcion encargada de consultar los vehiculos
   */
  public consultarVehiculos() {
    let idLinea: number = 1;
    this.vehiculosService.consultarVehiculos(idLinea).subscribe(
      vehiculos => {
        this.listaVehiculoDTO = vehiculos;
        console.log("esta es la lista" + this.listaVehiculoDTO);
      },
      error => {
        console.log(error);
      }
    )
  }
}
