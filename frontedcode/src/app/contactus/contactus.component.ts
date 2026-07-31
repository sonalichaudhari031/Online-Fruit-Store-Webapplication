import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent {

  // Constructor mein Router inject karna zaroori hai
  constructor(private router: Router) {}

  onSubmit() {
    // 1. Alert Message
    alert('Dhanyawad! Humne aapka message receive kar liya hai. Hamari team aapse jald sampark karegi.');
    
    // 2. Redirect to Fruit List
    this.router.navigate(['/fruitlist']);
  }

  
}

