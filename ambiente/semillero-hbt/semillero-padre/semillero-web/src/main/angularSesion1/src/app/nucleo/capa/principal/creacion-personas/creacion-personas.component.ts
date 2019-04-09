import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {
  
  public header : string = 'Crear personas';
  public id : number = 1;
  public nombre : string = 'Juan';
  public apellidos : string = 'Perez';
  public tipoIdentificacion : string = 'cedula';
  public formHidden : boolean = false;
  
  constructor() { }

  ngOnInit() {
  }

}
