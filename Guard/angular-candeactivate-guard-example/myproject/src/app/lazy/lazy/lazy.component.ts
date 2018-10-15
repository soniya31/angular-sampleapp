import { Component, OnInit } from '@angular/core';
import { ServicecounterService } from '../../servicecounter.service';

@Component({
  selector: 'app-lazy',
  templateUrl: './lazy.component.html',
  styleUrls: ['./lazy.component.css']
})
export class LazyComponent implements OnInit {

  constructor(private counterService: ServicecounterService) { }

  incrementCounter() {
    this.counterService.counter += 1;
  }
  ngOnInit() {
  }

}
