import { TestBed, inject } from '@angular/core/testing';

import { ServicecounterService } from './servicecounter.service';

describe('ServicecounterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicecounterService]
    });
  });

  it('should be created', inject([ServicecounterService], (service: ServicecounterService) => {
    expect(service).toBeTruthy();
  }));
});
