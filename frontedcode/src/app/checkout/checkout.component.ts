import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../order.service';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit, OnDestroy {
  fullName: string = '';
  email: string = '';
  phoneNumber: string = '';
  address: string = '';
  city: string = '';
  state: string = 'Maharashtra';
  
  cartItems: any[] = [];
  shippingCost: number = 20;
  userId: number | null = null;
  
  showSuccess: boolean = false;
  orderedCount: number = 0;
  countdown: number = 5; // ✅ Sirf ek baar yahan define kiya hai
  timerInterval: any;

  constructor(
    public router: Router, 
    private orderService: OrderService,
    private cartService: CartService 
  ) {}

  ngOnInit(): void {
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      this.userId = userData.id;
      this.fullName = userData.name || '';
      this.email = userData.email || '';
      this.address = userData.address || '';
      this.city = userData.city || '';
      this.phoneNumber = userData.phone || ''; 
    }
    
    const storedCart = localStorage.getItem('cart');
    if (storedCart) {
      this.cartItems = JSON.parse(storedCart);
    }
  }

  ngOnDestroy(): void {
    if (this.timerInterval) clearInterval(this.timerInterval);
  }

  get subtotal(): number {
    return this.cartItems.reduce((acc, item) => acc + ((item.price || 0) * (item.quantity || 1)), 0);
  }

  get total(): number {
    return this.subtotal + this.shippingCost;
  }

  placeOrder(): void {
    if (!this.userId) return;

    this.orderedCount = this.cartItems.length; 

    const orderPayload = {
      totalAmount: this.total,
      fullName: this.fullName,
      email: this.email,
      phone: this.phoneNumber,
      address: this.address,
      city: this.city,
      state: this.state,
      user: { id: this.userId },
      orderItems: this.cartItems.map(item => ({
        fruit: { id: item.id },
        quantity: item.quantity || 1,
        price: item.price
      }))
    };

    this.orderService.createOrder(orderPayload).subscribe({
      next: (res: any) => {
        this.showSuccess = true; 
        this.startCountdown(); 

        this.cartService.clearCart(this.userId!).subscribe({
          next: () => {
            localStorage.removeItem('cart');
            this.cartItems = [];
          },
          error: (err: any) => console.error("Clear cart error:", err)
        });
      },
      error: (err: any) => alert("Order failed!")
    });
  }

  startCountdown(): void {
    this.timerInterval = setInterval(() => {
      if (this.countdown > 0) {
        this.countdown--;
      } else {
        clearInterval(this.timerInterval);
        this.router.navigate(['/fruitlist']);
      }
    }, 1000);
  }
} 