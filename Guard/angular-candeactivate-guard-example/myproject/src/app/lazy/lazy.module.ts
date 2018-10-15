import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LazyComponent } from './lazy/lazy.component';
import { LazyRoutingModule } from './lazy-routing.module';
import { ServicecounterService } from '../servicecounter.service';
import { ModuleWithProviders } from '@angular/compiler/src/core';

@NgModule({
  imports: [
    CommonModule,
    LazyRoutingModule
  ],
  declarations: [LazyComponent],
  exports: [LazyComponent]
})
export class LazyModule {

  static forRoot(): ModuleWithProviders {
    return {
      ngModule: LazyModule,
      providers: [ServicecounterService]
    };


  }


}
