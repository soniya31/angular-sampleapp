import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductServiceService } from './product-service.service';
import { ProductModuleModule } from './product-module.module';

@NgModule({
  imports: [
    ProductModuleModule,
    CommonModule
  ],
  declarations: [ProductListComponent, ProductDetailsComponent],
  exports: [ProductListComponent, ProductDetailsComponent],
  providers: [ProductServiceService]
})
export class ProductModule { }
