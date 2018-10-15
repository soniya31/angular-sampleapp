import { Component, OnInit, style } from '@angular/core';

@Component({
    selector: 'app-form',
    template: `<div><input #in_val type="text" (keyup.enter)="addHero(in_val.value)"
     (blur)="addHero(in_val.value); in_val.value='' "/>
    <button (click)="addHero(in_val.value)">Click To Add Hero</button>
    <input #box (keyup)="0">
    <p>{{box.value}}</p>
    <ul>
     <li *ngFor='let hero of heroes'>{{hero}}</li>
    </ul>
    </div>`
})
export class FormComponent implements OnInit {

    heroes = ['SRK', 'Salman', 'Ranbir'];
    ngOnInit(): void { }
    addHero(name: string): void {
        this.heroes.push(name);

    }


}
