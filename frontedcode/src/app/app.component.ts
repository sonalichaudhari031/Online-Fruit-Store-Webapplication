import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


fruits = [
  { name: 'Apple', price: 120, image: 'assets/images/Apple.png' },
  { name: 'Banana', price: 50, image: 'assets/banana.jpg' },
  { name: 'Mango', price: 200, image: 'assets/mango.jpg' },
  { name: 'Orange', price: 80, image: 'assets/orange.jpg' }
];

  }

