import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/authService/auth.service';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.scss']
})
export class SignupPageComponent implements OnInit {

  signupForm: FormGroup;
  submitted = false;
  pwdPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"

  constructor(private router: Router,
    private authService: AuthService) {
    this.signupForm = new FormGroup({});
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.signupForm = new FormGroup({
      lastName: new FormControl('', Validators.required),
      firstName: new FormControl('', [Validators.required]),
      username: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(8), Validators.pattern(this.pwdPattern)])
    })
  }

  get f(): { [key: string]: AbstractControl } {
    return this.signupForm.controls;
  }

  onSubmit() {
    try {
      const user = {
        lastName: this.signupForm.value.lastName,
        firstName: this.signupForm.value.firstName,
        username: this.signupForm.value.username,
        email: this.signupForm.value.email,
        password: this.signupForm.value.password,
      }
      this.authService.signup(user).subscribe((response) => {
        this.router.navigate(["/login"]);
        console.log(response, "Création réussie")
        this.submitted = true;
      });
    } catch {
      console.log("__Error handled gracefully.")
    }

  }

}
