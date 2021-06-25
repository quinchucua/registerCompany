import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/Services/Company/company.service';
import { Location } from '@angular/common'
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-show-company',
  templateUrl: './show-company.component.html',
  styleUrls: ['./show-company.component.css']
})
export class ShowCompanyComponent implements OnInit {

  data: any[];

  constructor( private service: CompanyService, private location: Location) { }

  ngOnInit() {
    this.searchCompanies();
  }

  searchCompanies(){
    this.service.listCompanies().subscribe( data => {
      if(data.length > 0){
        this.data = data;
      } else {
        Swal.fire(
          'No se encontraron empresas',
          'En el momento no hay empresas en el sistema',
          'warning'
        );
      }
      
    }, error => {
      Swal.fire(
        'Error',
        'Se Presento un error al consultar las empresas',
        'error'
      );
    });
  }


  back(){
    this.location.back();
  }

}
