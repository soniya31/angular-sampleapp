import { Component, OnInit } from '@angular/core';
import { ServicecounterService } from '../../servicecounter.service';



@Component({
  selector: 'app-eager',
  templateUrl: './eager.component.html',
  styleUrls: ['./eager.component.css']
})
export class EagerComponent implements OnInit {

  constructor(private servicecounterService: ServicecounterService) { }

  ngOnInit() {

  }

  increaseCounter() {
    this.servicecounterService.counter += 1;
  }

}
