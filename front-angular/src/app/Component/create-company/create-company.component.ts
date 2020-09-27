import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CompanyService } from 'src/app/Services/Company/company.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-create-company',
  templateUrl: './create-company.component.html',
  styleUrls: ['./create-company.component.css']
})
export class CreateCompanyComponent implements OnInit {

  typeCompany: any[]
  selectedType: any;
  formCreate: FormGroup;
  newCompany: any;

  constructor(private servicio: CompanyService, private router: Router) { }

  ngOnInit() {
    this.typeCompany = [{
      idtype: 1,
      type: 'Grande'
    }, {
      idtype: 2,
      type: 'Mediana'
    }, {
      idtype: 3,
      type: 'Pequena'
    }]

    this.selectedType = {
      idtype: 1,
      type: 'Grande'
    }

    this.formCreate = new FormGroup({
      name: new FormControl('', Validators.required),
      nit: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      country: new FormControl('', Validators.required),
      deparment: new FormControl('', Validators.required),
      typeCompany: new FormControl('', Validators.required)
    });

    this.newCompany = {
      address: '',
      city: '',
      country: '',
      department: '',
      name: '',
      nit: '',
      phone: '',
      type: {
        idType: 0,
        type: ''
      }
    }

  }

  createCompany() {
    if (this.formCreate.valid) {
      this.selectType(this.formCreate)
      this.newCompany.address = this.formCreate.value.address;
      this.newCompany.city = this.formCreate.value.city;
      this.newCompany.country = this.formCreate.value.country;
      this.newCompany.department = this.formCreate.value.deparment;
      this.newCompany.name = this.formCreate.value.name;
      this.newCompany.nit = this.formCreate.value.nit;
      this.newCompany.phone = this.formCreate.value.phone;
      this.newCompany.type = this.selectedType;
      this.servicio.createCompany(this.newCompany).subscribe(resp => {
        this.router.navigateByUrl('listCompanies');
      }, error => {
        Swal.fire(
          'Error',
          'Se Presento un error al crear la empresa',
          'error'
        );
      });
    }

  }

  selectType(item) {
    this.typeCompany.forEach(element => {
      if (element.idtype === +item.value.typeCompany) {
        this.selectedType = element
      }
    });
  }

  goToShow() {
    this.router.navigateByUrl('listCompanies')
  }

  logout(){
    localStorage.setItem('login', 'no');
    this.router.navigateByUrl('');
  }

}
