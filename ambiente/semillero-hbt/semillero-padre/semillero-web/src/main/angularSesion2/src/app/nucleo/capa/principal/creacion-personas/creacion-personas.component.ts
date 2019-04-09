import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../apoyo/modelo/personaDTO';
import { TipoIdentificacion } from '../apoyo/modelo/tipoIdentificacion';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {

  public header: string = 'Crear personas';
  public persona: PersonaDTO;
  // public tipoIdentificacion : TipoIdentificacion;
  public personas: PersonaDTO[];
  datos;
  public opcionSeleccionado: string = '0'; // Iniciamos
  public verSeleccion: string = '';
  constructor() { }

  ngOnInit() {

    this.persona = {
      id: '0',
      nombre: '',
      apellido: '',
      tipoIdentificacion: '',
      numeroIdentificacion: 0,
      mayorEdad: false,
      numeroTelefonico: '',
      sexo: ''
    },

    this.personas = [];
    this.datos= ["Cedula", "Tarjeta Identidad"];
  }
  capturar() {
    // Pasamos el valor seleccionado a la variable verSeleccion
    this.verSeleccion = this.opcionSeleccionado;
  }

  public guardar() {
    this.personas.push(this.persona);
    console.log("Esta es la persona creada" + this.persona.nombre);
    console.log("Esta es la persona creada" + this.persona.apellido);
    console.log("Esta es la persona creada" + this.persona.tipoIdentificacion);
    console.log("Esta es la persona creada" + this.persona.numeroTelefonico);
    // console.log("Esta es la persona creada" + this.persona.numeroIdentificacion);
  }


}
