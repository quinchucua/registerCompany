import { TestBed } from '@angular/core/testing';
import { AppModule } from 'src/app/app.module';

import { BaseServiceService } from './base-service.service';

describe('BaseServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [ AppModule ]
  }));

  it('should be created', () => {
    const service: BaseServiceService = TestBed.get(BaseServiceService);
    expect(service).toBeTruthy();
  });
});
