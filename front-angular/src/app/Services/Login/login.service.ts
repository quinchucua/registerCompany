import { Injectable } from '@angular/core';
import { BaseServiceService } from '../Base/base-service.service';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService extends BaseServiceService {

  private urlLogin = 'Autentication'

  constructor(http: HttpClient) { super(http)}

  public login(user: string, password: string){
    let params: HttpParams = new HttpParams()
    .set('user', user)
    .set('password', password)
    return this.getServiceObservableParams(this.urlLogin, params);
  }


}
