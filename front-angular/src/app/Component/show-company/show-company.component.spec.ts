import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AppModule } from 'src/app/app.module';
import {ActivatedRoute} from "@angular/router";

import { ShowCompanyComponent } from './show-company.component';

describe('ShowCompanyComponent', () => {
  let component: ShowCompanyComponent;
  let fixture: ComponentFixture<ShowCompanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [AppModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it("should call searchCompanies after being created", () => {
    spyOn(component, "searchCompanies");
    component.ngOnInit();
    expect(component.searchCompanies).toHaveBeenCalled();
  });
});
