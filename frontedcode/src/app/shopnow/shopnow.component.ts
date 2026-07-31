import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // Router import karein

@Component({
  selector: 'app-shopnow',
  templateUrl: './shopnow.component.html',
  styleUrls: ['./shopnow.component.css']
})
export class ShopnowComponent implements OnInit {

  constructor(private router: Router) { } // Router inject karein

  ngOnInit(): void { }

  // Banner image button par click karne ka function
  navigateToFruitList() {
    // Yeh aapko fruit list page par le jayega
    this.router.navigate(['/fruitlist']); 
  }



}