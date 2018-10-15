import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products = new Array();
  constructor(private ProductService: ProductServiceService) { }

  ngOnInit() {
    this.ProductService.getProduct().subscribe(data => this.products = data);
  }

}
