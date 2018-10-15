import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductServiceService } from '../product-service.service';
import { Product } from '../product';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  product: Product;
  constructor(private productService: ProductServiceService, private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    this.getProduct();
  }


  getProduct(): void {

    const id = +this.activateRoute.snapshot.paramMap.get('id');
    this.productService.getProd(id).subscribe(data => {
      this.product = data;
    });


  }
}

