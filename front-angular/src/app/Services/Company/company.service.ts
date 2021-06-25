import { Injectable } from '@angular/core';
import { BaseServiceService } from '../Base/base-service.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CompanyService extends BaseServiceService{

  private urlCreate = 'company/create';
  private urlListCompanies = 'company/findCompanies';
  private urlUploadFile = 'company/uploadFile';

  constructor(http: HttpClient) { super(http)}

  createCompany(body: any) {
    return this.postServiceObservable(this.urlCreate, body);
  }

  listCompanies(){
    return this.getServiceObservable(this.urlListCompanies);
  }

  uploadFile( body: FormData){
    return this.postServiceFileObservable(this.urlUploadFile, body);
  }
}
