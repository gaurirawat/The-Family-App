import { TestBed } from '@angular/core/testing';

import { FamilyAppService } from './family-app.service';

describe('FamilyAppService', () => {
  let service: FamilyAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FamilyAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
