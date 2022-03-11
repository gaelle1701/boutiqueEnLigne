import { Component, OnInit } from '@angular/core';
import { AbstractControl, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/authService/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    console.log(form.value);
    this.authService.login(form.value)
      .subscribe(
        (resp: any) => {
          console.log("connection succeed", resp);
          this.router.navigate(['/admin-home/']);
          console.log(resp.roles)
          const admin = resp.roles;
        },
        error => {
          console.log('error while');
        }
      )
  }

}
