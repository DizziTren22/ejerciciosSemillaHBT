import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../apoyo/modelo/personaDTO';
import { TipoIdentificacion } from '../apoyo/modelo/tipoIdentificacion';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {
  
  public header : string = 'Crear personas';
  public persona: PersonaDTO;
  public tipoIdentificacion : TipoIdentificacion;
  public personas: PersonaDTO[];
  constructor() { }

  ngOnInit() {
   
    this.persona = {
      id: '0',
      nombre: '',
      apellido: '',
      tipoIdentificacion: '',
      numeroIdentificacion: 0,
      mayorEdad: false,
      numeroTelefonico : '',
      sexo: ''
    },
      this.personas = [];
      this.tipoIdentificacion = new TipoIdentificacion();
  }

}
