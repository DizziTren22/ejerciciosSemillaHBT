/**
 * Clase que determina el dto de la persona
 */
export interface PersonaDTO {
  id: string;
  nombre: string;
  apellido: string;
  tipoIdentificacion: string;
  numeroIdentificacion: number | string;
  mayorEdad:boolean;
  sexo;
}