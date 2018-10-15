import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LazyComponent } from './lazy/lazy.component';


export const routes = [
  { path: 'lazyy', component: LazyComponent }];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
   exports: [RouterModule],
  declarations: []
})
export class LazyRoutingModule { }
