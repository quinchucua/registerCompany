import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/Services/Login/login.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: string;
  password: string;

  constructor(private loginservice: LoginService, private router: Router) { }

  ngOnInit() {
  }

  login(){
    if(this.validate()){
      this.loginservice.login(this.user, this.password).subscribe( resp => {
        if(resp.message === 'denegado'){
          Swal.fire(
            'Error',
            'Usuario o Contraseña incorrectos',
            'error'
          );
        } else if(resp.message === 'confirmado') {
          localStorage.setItem('login', 'si');
          this.router.navigateByUrl('/create');
        }
      })
    }
  }

  validate(){
    if(this.user === undefined || this.user === ''){
      Swal.fire(
        'Error',
        'Debe ingresar el usuario',
        'error'
      );
      return false;
    } else if(this.password === undefined || this.password === '') {
      Swal.fire(
        'Error',
        'Debe ingresar Contraseña',
        'error'
      );
      return false;
    }
    return true;
  }

}
