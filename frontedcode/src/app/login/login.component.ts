import { Component, ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'], 
  encapsulation: ViewEncapsulation.None // Yeh line CSS ko override karne se rokegi
})
export class LoginComponent {
  constructor(private userService: UserService, private router: Router) {}

  onSubmit(loginForm: NgForm) {
    if (loginForm.invalid) {
      alert("Please enter valid details");
      return;
    }
    const { email, password } = loginForm.value;
    this.userService.login(email, password).subscribe({
      next: (userResponse: any) => {
        localStorage.setItem('user', JSON.stringify(userResponse));
        this.router.navigate(['/fruitlist']); 
      },
      error: (err: any) => alert("Login Failed!")
    });
  }
}