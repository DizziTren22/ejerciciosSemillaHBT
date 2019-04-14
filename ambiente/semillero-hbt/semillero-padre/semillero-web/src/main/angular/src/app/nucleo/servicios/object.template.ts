import { Injector } from "@angular/core";

export class ServiciosObject {

    constructor(protected injector:Injector) {
        if(this.isNpmServe()){
            console.log("Se ha detectado angular local");
        }
    }
  

    protected isNpmServe():boolean{
        return location.port == "4200";
    }

}