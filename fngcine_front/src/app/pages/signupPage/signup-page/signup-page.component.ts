import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.scss']
})
export class SignupPageComponent implements OnInit {

  signupForm: FormGroup;
  pwdPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"

  constructor(private router: Router) {
    this.signupForm = new FormGroup({});
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.signupForm = new FormGroup({
      lastname: new FormControl('', [Validators.required]),
      firstname: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(8), Validators.pattern(this.pwdPattern)])
    })

  }

  onSubmit() {

  }

}
