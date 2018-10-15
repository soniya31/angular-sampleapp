import { Component, OnInit } from '@angular/core';
import { Heropojo } from './HeroPojo';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {

  powers = ['Strong', 'flirt', 'brave', 'Cool'];
  model = new Heropojo(42, 'SkyDog',
    this.powers[0],
    'Leslie Rollover');

  submitted = false;
  constructor() { }

  ngOnInit() {
  }

  onSubmitAction(): void {
    this.submitted = true;
    console.log();
  }
  get debugger() { return JSON.stringify(this.model); }

}



