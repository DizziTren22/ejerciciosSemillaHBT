/**
 * Clase de dto de la persona 
 */
export interface PersonaServicioDTO {  
    //Los datos son iguales que el DTO en Java
  idPersona:number;
  numeroIdentificacion: string;
  tipoIdentificacion: string;
  numeroTelefonico: string;
  nombres: string;
  apellidos: string;
  edad:number;
  comprador:boolean;
  vendedor:boolean;
}