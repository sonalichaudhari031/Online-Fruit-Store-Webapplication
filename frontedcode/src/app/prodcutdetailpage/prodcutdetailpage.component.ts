import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FruitService } from '../services/fruit.service';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-prodcutdetailpage',
  templateUrl: './prodcutdetailpage.component.html',
  styleUrls: ['./prodcutdetailpage.component.css']
})
export class ProdcutdetailpageComponent implements OnInit {
  product: any;
  suggestions: any[] = [];
  selectedWeight: number = 1;
  totalPrice: number = 0;
  
  imgUrl = 'http://localhost:8080/uploads/'; 

  constructor(
    private route: ActivatedRoute,
    private fruitService: FruitService,
    private cartService: CartService // Service inject ho gayi
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      this.loadData(id);
    });
  }

  loadData(id: number) {
    this.fruitService.getFruitById(id).subscribe((data) => {
      this.product = data;
      if(this.product && !this.product.img.startsWith('http')) {
        this.product.img = this.imgUrl + this.product.img;
      }
      this.updateTotal();
    });

    this.fruitService.getAllFruits().subscribe((data: any[]) => {
      this.suggestions = data.filter(f => f.id !== id).slice(0, 10).map(f => {
        if(!f.img.startsWith('http')) {
          f.img = this.imgUrl + f.img;
        }
        return f;
      });
    });
  }

  updateTotal() {
    if (this.product) {
      this.totalPrice = this.product.price * this.selectedWeight;
    }
  }

  // ✅ FINAL WORKING ADD TO BASKET
  addToBasket() {
    if (this.product) {
      // LocalStorage se logged-in user ki ID nikalna zaroori hai
      const storedUser = localStorage.getItem('user');
      const userData = storedUser ? JSON.parse(storedUser) : null;
      const userId = userData ? userData.id : 1; // Agar user nahi mila toh default 1

      const fruitId = this.product.id;
      const quantity = this.selectedWeight;

      this.cartService.addToCart(userId, fruitId, quantity).subscribe({
        next: (response) => {
          console.log("Product added to backend:", response);
          alert(this.product.name + ' successfully added to your basket!');
        },
        error: (err) => {
          console.error("Cart Error:", err);
          alert("Error: Could not add to basket. Is backend running?");
        }
      });
    }
  }

  goBack() {
    window.history.back();
  }
}