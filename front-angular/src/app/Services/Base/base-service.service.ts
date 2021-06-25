import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

const httpOptions = {
  heahers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': '*/*'
  })
};

const httpOptions2 = {
  headers: new HttpHeaders({
    'enctype': 'multipart/form-data',
    'Accept': '*/*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BaseServiceService {

  private urlBase = 'http://127.0.0.1:7001/'; 
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

  protected postServiceFileObservable(url: string, body: any) {
    return this.http.post(this.urlBase + this.resources + url, body, { headers: httpOptions2.headers, observe: 'response' });
  }
}
