import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

const httpOptions = {
  heahers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': '*/*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BaseServiceService {

  private urlBase = 'http://localhost:8082/';
  private resources = 'registroEmpresasTransporte/resources/'

  constructor(private http: HttpClient) { }

  protected getServiceObservableParams(url: string, params: HttpParams): Observable<any> {
    const httpOptions = { params: params }
    return this.http.get(this.urlBase + this.resources + url, httpOptions);
  }

  protected getServiceObservable(url: string): Observable<any> {
    return this.http.get(this.urlBase + this.resources + url);
  }

  protected postServiceObservable(url: string, body: any) {
    return this.http.post(this.urlBase + this.resources + url, body, { headers: httpOptions.heahers, observe: 'response' });
  }
}
