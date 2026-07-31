import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartItems: any[] = [];
  userId: number | null = null;

  constructor(public router: Router, private cartService: CartService) {}

  ngOnInit(): void {
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      this.userId = userData.id; 
      
      if (this.userId) {
        this.loadCart(this.userId);
      }
    } else {
      this.router.navigate(['/login']);
    }
  }

  // ✅ Load Cart Function Error Fixed
  loadCart(userId: number): void {
    this.cartService.getCartItemsByUserId(userId).subscribe({
      next: (data: any[]) => {
        console.log("Database Response:", data);
        this.cartItems = data;
        // Local storage ko sync rakhein
        localStorage.setItem('cart', JSON.stringify(this.cartItems));
      },
      error: (err) => {
        console.error("Cart fetch failed:", err);
      }
    });
  }

  removeItem(item: any): void {
    const itemName = item.fruit?.name || item.fruitName || 'item';
    
    if (confirm(`Remove ${itemName} from cart?`)) {
      this.cartService.removeItemFromCart(item.id).subscribe({
        next: () => {
          this.cartItems = this.cartItems.filter(i => i.id !== item.id);
          localStorage.setItem('cart', JSON.stringify(this.cartItems));
          alert('Item removed!');
        },
        error: (err: any) => {
          console.error("Delete failed:", err);
        }
      });
    }
  }

  getCartTotal(): number {
    return this.cartItems.reduce((acc, item) => {
      const price = item.fruit?.price || item.price || 0;
      const quantity = item.quantity || 1;
      return acc + (price * quantity);
    }, 0);
  }
}