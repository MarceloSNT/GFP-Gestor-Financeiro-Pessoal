import { TestBed } from '@angular/core/testing';

import { AçaoService } from './açao-service';

describe('AçaoService', () => {
  let service: AçaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AçaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
