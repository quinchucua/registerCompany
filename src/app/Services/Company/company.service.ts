import { Injectable } from '@angular/core';
import { BaseServiceService } from '../Base/base-service.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CompanyService extends BaseServiceService{

  private urlCreate = 'company/create';
  private urlListCompanies = 'company/findCompanies';

  constructor(http: HttpClient) { super(http)}

  createCompany(body: any) {
    return this.postServiceObservable(this.urlCreate, body);
  }

  listCompanies(){
    return this.getServiceObservable(this.urlListCompanies);
  }
}
