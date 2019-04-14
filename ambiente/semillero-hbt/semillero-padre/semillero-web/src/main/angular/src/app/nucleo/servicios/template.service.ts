import { Injector } from "@angular/core";
import { Response, RequestOptionsArgs, Headers, RequestOptions, Http } from "@angular/http";
import { Observable } from "rxjs";
import { HttpClient, HttpParams } from "@angular/common/http"
import { ServiciosObject } from "./object.template";


/**
* Clase que permite gestionar las peticiones a los servicios rest
**/
export class AbstractService extends ServiciosObject {

    private http: HttpClient;
    private headers = { 'Content-Type': 'application/json; charset=UTF-8' };
	
    constructor(injector: Injector) {
        super(injector);
        injector.get(Http);
        this.http = injector.get(HttpClient);
        if (this.isNpmServe()) {
            
        }
    }

    protected buildURL(module: string, path: string): string {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        if (!module.startsWith("/")) {
            module = "/" + module;
        }
        let url = this.getURL() + module + "/rest" + path;
        console.log("Resolviendo url:  Modulo" + module +"- Ruta " + path + " -> {2}" + url);
        return url;
    }

    private getURL() {
        if (this.isNpmServe()) {
            return "http://127.0.0.1:8085";
        }
        
        var url =  location.protocol + '//' + location.hostname;
        if(location.port != "80"){
            url +=  ":" + location.port;
        }
        return url;
    }

    public get<T>(module: string, path: string, params?: { [param: string]: string | string[]; }): Observable<T> {
        let url = this.buildURL(module, path);
        return this.http.get<T>(url, { headers: this.headers, params: params });
    }

    public post<T>(module: string, path: string, body: any, options?: RequestOptionsArgs): Observable<T> {
        let url = this.buildURL(module, path);
        return this.http.post<T>(url, body, { headers: this.headers });
    }
	
	
    public put<T>(module: string, path: string, body: any, options?: RequestOptionsArgs): Observable<T> {
        let url = this.buildURL(module, path);
        return this.http.put<T>(url, body, { headers: this.headers });
    }

    public delete<T>(module: string, path: string, options?: RequestOptionsArgs): Observable<T> {
        let url = this.buildURL(module, path);
        return this.http.delete<T>(url, { headers: this.headers });
    }
}
