import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-apoyo',
  templateUrl: './apoyo.component.html'
})
export class ApoyoComponent implements OnInit {

  public persona: PersonaDTO;
  public personas: PersonaDTO[];
  public mostrarFormulario: boolean;
  constructor() { }

  ngOnInit() {
    this.persona = {
      id: '0',
      nombre: '',
      apellido: '',
      tipoIdentificacion: '',
      numeroIdentificacion: 0,
      numeroTelefonico: '',
      mayorEdad: false,
      sexo: ''
    },

      this.personas = [];

    this.mostrarFormulario = true;
  }

  public mostrar() {

  }

  public ocultar() {

  }

  public guardar() {
    this.personas.push(this.persona);
    console.log("guardar()" + this.persona.nombre);
  }

  private borrar() {

  }
}
