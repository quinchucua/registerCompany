import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { APP_BASE_HREF } from '@angular/common';
import { LoginComponent } from './Component/login/login.component';
import { CreateCompanyComponent } from './Component/create-company/create-company.component';
import { ShowCompanyComponent } from './Component/show-company/show-company.component';
import { AuthGuardGuard } from './Services/Guard/auth-guard.guard';

const routes = [
  {
    path: '', 
    component: LoginComponent
  }, 
  {
    path: 'create',
    component: CreateCompanyComponent,
    canActivate:[AuthGuardGuard]
  },
  {
    path: 'listCompanies',
    component: ShowCompanyComponent,
    canActivate:[AuthGuardGuard]
  } 
]

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true, enableTracing: true})],
  exports: [RouterModule],
  providers: [{ provide: APP_BASE_HREF, useValue: '/registerCompany'}]
})
export class AppRoutingModule { }
