import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;
  constructor(public formBuilder: FormBuilder) {
    this.createForm();
  }

  createForm() {
    this.loginForm = this.formBuilder.group({
      name: '',
      address : this.formBuilder.group({
        street: '',
        city: '',
        states: [['CV', 'IN'] , Validators.required]
      }),
      power: '',
      sidekick: ''
    });
  }

  ngOnInit() {
  }

  onSubmit(): void {
    this.submitted = true;
    console.log(this.loginForm.value);
  }
}
