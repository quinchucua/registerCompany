import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { AppComponent } from 'src/app/app.component';
import { AppModule } from 'src/app/app.module';
import { CreateCompanyComponent } from '../create-company/create-company.component';
import { ShowCompanyComponent } from '../show-company/show-company.component';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ AppModule],      
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('validate user and password case 1', () =>{
    component.user = undefined;
    component.password = '';
    expect(component.validate()).toBeFalsy();
  });

  it('validate user and password case 1', () =>{
    component.user = undefined;
    component.password = 'password';
    expect(component.validate()).toBeFalsy();
  });

  it('validate user and password case 2', () =>{
    component.user = 'user';
    component.password = '';
    expect(component.validate()).toBeFalsy();
  });

  it('validate user and password case 2', () =>{
    component.user = 'user';
    component.password = 'password';
    expect(component.validate()).toBeTruthy();
  });
});
