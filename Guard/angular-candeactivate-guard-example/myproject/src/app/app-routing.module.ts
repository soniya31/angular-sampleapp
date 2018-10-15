import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { EagerComponent } from './eager/eager/eager.component';
import { LazyModule } from './lazy/lazy.module';
import { ProductModule } from './product/product.module';
import { HeroComponent } from './hero/hero.component';
import { LoginComponent } from './login/login.component';
import { AuthguardService } from './authguard.service';


const routes: Routes = [{ path: 'eager', component: EagerComponent },
{ path: 'lazy', loadChildren: () => LazyModule },
{ path: '', redirectTo: 'eager', pathMatch: 'full' },
{ path: 'details', loadChildren: () => ProductModule },
{ path: 'heroDetails', component: HeroComponent },
{ path: 'login', component: LoginComponent, canActivate: [AuthguardService] }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }


