import { Injectable } from '@angular/core';

@Injectable()
export class ServicecounterService {

  constructor() { this.counter = 0; }
  counter: number;

  loginnedIn(): boolean {
    return false;
  }
}
