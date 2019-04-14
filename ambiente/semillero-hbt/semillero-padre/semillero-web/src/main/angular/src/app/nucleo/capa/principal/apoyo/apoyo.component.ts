import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from './modelo/PersonaDTO'

@Component({
  selector: 'app-apoyo',
  templateUrl: './apoyo.component.html'
})

export class ApoyoComponent implements OnInit {

  /**
   * Boolean para mostrar formulario
   */
  public mostrarFormulario: boolean;

   /**
   * Declaracion del dto de persona
   */
  public persona: PersonaDTO;

    /**
   * Lista de personas
   */
  public personas: PersonaDTO[];

  constructor() { }

  public ngOnInit() {
    this.mostrarFormulario = true;
    this.persona = {
      id: '0',
      nombre: '',
      apellido: '',
      tipoIdentificacion: '',
      numeroIdentificacion: '',
      mayorEdad: false,
      sexo: '',
    };
    this.personas = [];
  }

   /**
 * Funcion encargado de mostrar un formulario
 */
  mostrar() {
    this.mostrarFormulario = true;
  }

   /**
 * Funcion encargado de ocultar un formulario
 */
  ocultar() {
    this.mostrarFormulario = false;
  }

  /**
 * Funcion encargado de crear una persona
 */
  public guardar() {
    console.log('guardando....' + this.persona.nombre);
    this.personas.push(this.persona);
    console.log('cantidad de personas....' + this.personas.length);

  }
  /**
   * Funcion encargado de borrar una persona
   * @param persona 
   */
  public borrar(persona: PersonaDTO) {
    console.log('borrando....');
    this.personas = this.personas.filter(p => p.nombre !== persona.nombre);

  }
}
