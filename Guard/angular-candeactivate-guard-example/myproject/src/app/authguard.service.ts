import { Injectable } from '@angular/core';
import { ServicecounterService } from './servicecounter.service';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class AuthguardService implements CanActivate {

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
    console.log('In activate Route Module');
    if (!this.service.loginnedIn()) {
      console.log('Not allowed');
      window.alert('Permission Denied Exception');
      this.router.navigateByUrl('/heroDetails');
      return false;

    }
    return true;
  }
  constructor(private service: ServicecounterService , private router: Router) {
   }
}
