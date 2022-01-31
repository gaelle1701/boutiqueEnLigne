import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Iusers } from 'src/app/models/iusers';
import { UserService } from 'src/app/services/userService/user.service';
import * as _ from 'underscore';

@Component({
  selector: 'app-admin-customer-page',
  templateUrl: './admin-customer-page.component.html',
  styleUrls: ['./admin-customer-page.component.scss']
})
export class AdminCustomerPageComponent implements OnInit {

  public users!: Iusers[];
  userSub?: Subscription;
  public labels?: string[];

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.onGetUsers();
    this.userService.getUsers();
  }

  onGetUsers() {
    this.userSub = this.userService.userSubject$.subscribe(resp => {
      this.users = resp;
      console.log(this.users);
      for (let index = 0; index < this.users.length; index++) {
        const element = this.users[index];
        this.labels = _.without(_.keys(element), "password", "ordersList");
        console.log(this.labels);
        
      }
    })
  }

  onGetKeys() {

  }

  ngOnDestroy() {
    this.userSub?.unsubscribe();
  }

}
