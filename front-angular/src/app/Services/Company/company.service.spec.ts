import { TestBed } from '@angular/core/testing';
import { AppModule } from 'src/app/app.module';

import { CompanyService } from './company.service';

describe('CompanyService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [ AppModule ]
  }));

  it('should be created', () => {
    const service: CompanyService = TestBed.get(CompanyService);
    expect(service).toBeTruthy();
  });
});
