import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LazyModule } from './lazy/lazy.module';
import { EagerModule } from './eager/eager.module';
import { AppRoutingModule } from './app-routing.module';
import { ServicecounterService } from './servicecounter.service';
import { ProductModule } from './product/product.module';
import { ProductModuleModule } from './product/product-module.module';
import { HeroComponent } from './hero/hero.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms' ;
import { AuthguardService } from './authguard.service';



@NgModule({
  declarations: [
    AppComponent,
    HeroComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    EagerModule,
    AppRoutingModule,
    ProductModule,
    ProductModuleModule,
    LazyModule.forRoot(),
    FormsModule,
    ReactiveFormsModule
  ],
  bootstrap: [AppComponent],
  providers: [ServicecounterService, AuthguardService]
})
export class AppModule { }
