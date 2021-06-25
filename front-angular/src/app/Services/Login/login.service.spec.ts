import { TestBed } from '@angular/core/testing';
import { AppModule } from 'src/app/app.module';

import { LoginService } from './login.service';

describe('LoginService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [ AppModule ]
  }));

  it('should be created', () => {
    const service: LoginService = TestBed.get(LoginService);
    expect(service).toBeTruthy();
  });
});
