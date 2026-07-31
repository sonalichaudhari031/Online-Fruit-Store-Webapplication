import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { FruitService } from '../services/fruit.service';
import { Fruit } from '../models/fruit';

@Component({
  selector: 'app-fruit-list',
  templateUrl: './fruit-list.component.html',
  styleUrls: ['./fruit-list.component.css']
})
export class FruitListComponent implements OnInit {
  fruits: Fruit[] = [];
  @ViewChild('fruitContainer') fruitContainer!: ElementRef;

  constructor(private fruitService: FruitService, private router: Router) {}

  ngOnInit(): void {
    this.fruitService.getAllFruits().subscribe({
      next: (data: Fruit[]) => {
        this.fruits = data
          .filter(f => f.available == true || (f as any).available == 1)
          .map(f => ({
            ...f,
            img: f.img.startsWith('http') ? f.img : `http://localhost:8080/uploads/${f.img}`,
            shopName: f.shopName || 'Fresh Mart'
          }));
      },
      error: (err) => console.error('Error fetching fruits:', err)
    });
  }

  // Logic for 2 Rows
  getRows(fruits: Fruit[]): Fruit[][] {
    const half = Math.ceil(fruits.length / 2);
    return [fruits.slice(0, half), fruits.slice(half)];
  }

  // Scroll Logic for Arrows
  scrollLeft() {
    this.fruitContainer.nativeElement.scrollBy({ left: -500, behavior: 'smooth' });
  }

  scrollRight() {
    this.fruitContainer.nativeElement.scrollBy({ left: 500, behavior: 'smooth' });
  }

  viewDetails(id: number) {
    this.router.navigate(['/product-details', id]).then(() => {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });
  }

  trackById(index: number, fruit: Fruit): number {
    return fruit.id;
  }
}