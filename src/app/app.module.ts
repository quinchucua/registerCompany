import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './Component/login/login.component';
import { CreateCompanyComponent } from './Component/create-company/create-company.component';
import { ShowCompanyComponent } from './Component/show-company/show-company.component';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthGuardGuard } from './Services/Guard/auth-guard.guard';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateCompanyComponent,
    ShowCompanyComponent
  ],
  imports: [
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    { provide: LocationStrategy, useClass: HashLocationStrategy}, AuthGuardGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
