import { Component, OnInit } from '@angular/core';
import { CrearPersonaService } from '../../../servicios/consulta-vehiculo-servicio/crear.persona.service';
import { PersonaServicioDTO } from '../gestion-vehiculos/modelo/personaServicioDTO';
import { ConsultaVehiculosService } from '../../../servicios/consulta-vehiculo-servicio/consulta.vehiculo.service';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {

  public header: string = 'Crear personas';
  public id: number = 1;
  public nombre: string = 'Juan';
  public apellidos: string = 'Perez';
  public tipoIdentificacion: string = 'cedula';
  public formHidden: boolean = false;

  /**
   * Declaracion del dto de persona
   */
  public personaDTO: PersonaServicioDTO;

  /**
   * Lista de personas
   */
  public personaDTOs: PersonaServicioDTO[];
  
  /**
   * Constructor
   * @param crearPersonaService 
   * @param vehiculosService 
   */
  constructor(private crearPersonaService: CrearPersonaService,
    private vehiculosService: ConsultaVehiculosService) {
  }

  ngOnInit() {
    this.personaDTO = {
      idPersona: 0,
      nombres: '',
      apellidos: '',
      tipoIdentificacion: '',
      numeroIdentificacion: '',
      edad: 0,
      numeroTelefonico: '',
      comprador: false,
      vendedor: false,
    };
  }

  /**
  * Funcion encargada de crear las personas
  */
  public crearPersona() {
    this.crearPersonaService.crearPersona(this.personaDTO).subscribe(persona => {
      this.personaDTO = persona;
    },
      error => {
        console.log(error);
      })
  }

  /**
   * Funcion encargada de consultar las personas
   */
  public consultarPersonas() {
    let tipoID: string = 'cc';
    let numID: string = '111111';
    this.vehiculosService.consultarPersonas(tipoID, numID).subscribe(
      personas => {
        this.personaDTOs = personas;
      },
      error => {
        console.log(error);
      }
    );
    console.log('resultado servicio.... ' + this.personaDTOs)
  }
}
