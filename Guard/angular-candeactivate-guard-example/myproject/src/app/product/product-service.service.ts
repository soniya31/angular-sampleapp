import { Injectable } from '@angular/core';

import { Product } from './product';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';

const product: Product[] = [
  new Product(1, 'Product1', 'Here is the Product 1 desc'),
  new Product(2, 'Product2', 'Here is the Product 2 desc'),
  new Product(3, 'Product3', 'Here is the Product 3 desc'),
  new Product(4, 'Product4', 'Here is the Product 4 desc'),
  new Product(5, 'Product5', 'Here is the Product 5 desc'),
  new Product(6, 'Product6', 'Here is the Product 6 desc'),
  new Product(7, 'Product7', 'Here is the Product 7 desc'),
  new Product(8, 'Product8', 'Here is the Product 8 desc'),
  new Product(9, 'Product9', 'Here is the Product 9 desc')];

@Injectable()
export class ProductServiceService {

  constructor() { }

  getProduct(): Observable<Product[]> {
    return Observable.of(product);
  }

  getProd(id): Observable<Product> {
    return Observable.of(product.find(prod => prod.id === id));
  }
}
