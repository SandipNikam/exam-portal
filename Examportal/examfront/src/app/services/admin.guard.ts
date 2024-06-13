import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';


@Injectable({
  providedIn: 'root' // This makes the guard a singleton service
})

export class AdminGuard implements CanActivate{
  constructor(private login:LoginService,private router:Router){

  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if(this.login.isLoggedIn() && this.login.getUserRole()=='ADMIN'){
   return true;
  }
this.router.navigate(['login']);
  return false;
}
}