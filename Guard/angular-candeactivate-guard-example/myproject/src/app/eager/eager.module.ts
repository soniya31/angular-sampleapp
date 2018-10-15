import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EagerComponent } from './eager/eager.component';
import { ServicecounterService } from '../servicecounter.service';
import { FormComponent } from './eager/form.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [EagerComponent, FormComponent],
  exports: [ FormComponent]

})
export class EagerModule { }
