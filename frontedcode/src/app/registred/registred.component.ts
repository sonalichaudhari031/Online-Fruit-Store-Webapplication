import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../models/User';

@Component({
  selector: 'app-registred',
  templateUrl: './registred.component.html',
  styleUrls: ['./registred.component.css']
})
export class RegistredComponent {

  user: User = {
    name: '',
    email: '',
    password: '',
    address: '',
    role: 'CUSTOMER'
  };

  confirmPassword: string = '';

  constructor(
    private userService: UserService,
    private router: Router
  ) {}

  register() {
    // ✅ Check password match before sending to server
    if (this.user.password !== this.confirmPassword) {
      alert('Password and Confirm Password do not match!');
      return;
    }

    console.log("Register function call hua!", this.user);

    this.userService.register(this.user).subscribe({
      next: (res) => {
        console.log('Server se response aaya:', res);
        alert('Registration Successful!');
        this.router.navigate(['/login']); // Registration ke baad login page
      },
      error: (err) => {
        console.error('Server ne error diya:', err);
        alert('Registration Fail ho gaya!');
      }
    });
  }
}
