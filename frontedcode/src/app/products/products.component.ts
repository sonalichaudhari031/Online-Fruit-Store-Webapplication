// import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';

// import * as bootstrap from 'bootstrap';
// import { ActivatedRoute, Router } from '@angular/router';




// @Component({
//   selector: 'app-products',
//   templateUrl: './products.component.html',
//   styleUrls: ['./products.component.css']
// })
// export class ProductsComponent implements OnInit {




 


// openDetails(id: number) {
//   this.router.navigate(['/product', id]);
// }
  
//  fruits = [
//   { id: 1, name: 'Apple', img: 'assets/images/Apple.png', price: 120 },
//   { id: 2, name: 'Strawberries', img: 'assets/images/Strawberies.png', price: 150 },
//   { id: 3, name: 'Pomegranate', img: 'assets/images/Dadim.JPEG', price: 180 },
//   { id: 4, name: 'Pineapple', img: 'assets/images/Pinaple.png', price: 90 },
//   { id: 5, name: 'Grapes', img: 'assets/images/Grapve.JPEG', price: 60 },
//   { id: 6, name: 'Custard Apple', img: 'assets/images/sitafal.JPEG', price: 200 },
//   { id: 7, name: 'Guava', img: 'assets/images/Guva.png', price: 70 },
//   { id: 8, name: 'Orange', img: 'assets/images/Orange Photo.png', price: 80 },
//   { id: 9, name: 'Banana', img: 'assets/images/banana.png', price: 40 },
//   { id: 10, name: 'Watermelon', img: 'assets/images/Watermelon.JPEG', price: 25 },
//   { id: 11, name: 'Papaya', img: 'assets/images/papi.jpg', price: 50 },
//   { id: 12, name: 'Kiwi', img: 'assets/images/kevi.JPEG', price: 30 }
// ];



//   currentSlide = 0;
//   itemsPerSlide = 6;

//   get totalSlides() {
//     return Math.ceil(this.fruits.length / this.itemsPerSlide);
//   }

//   getVisibleFruits(): any[] {
//     const start = this.currentSlide * this.itemsPerSlide;
//     const end = start + this.itemsPerSlide;
//     return this.fruits.slice(start, end);
//   }

//   nextSlide() {
//     this.currentSlide = (this.currentSlide + 1) % this.totalSlides;
//   }

//   prevSlide() {
//     this.currentSlide = (this.currentSlide - 1 + this.totalSlides) % this.totalSlides;
//   }












  

//   constructor(private route: ActivatedRoute, private router: Router) {}

//  goToDetails(product: any) {
//      this.router.navigate(['/product-details', product.id]);
//    }



//    @ViewChild('fruitDetailModal') fruitDetailModal!: TemplateRef<any>;

//    showModal = false;
//    selectedFruit: any = null;

// fruits = [
//    { id: 1, name: 'Apple', img: 'assets/images/Apple.png', price: 120, desc: 'Fresh and organic apples.' },
//    { id: 2, name: 'Strawberries', img: 'assets/images/Strawberies.png', price: 150, desc: 'Sweet and juicy berries.' },
//    { id: 3, name: 'Pomegranate', img: 'assets/images/Dadim.JPEG', price: 180, desc: 'High in antioxidants.' },
//    { id: 4, name: 'Pineapple', img: 'assets/images/Pinaple.png', price: 90, desc: 'Tangy and refreshing.' },
//    { id: 5, name: 'Grapes', img: 'assets/images/Grapve.JPEG', price: 60, desc: 'Fresh black grapes.' },
//    { id: 6, name: 'Custard Apple', img: 'assets/images/sitafal.JPEG', price: 200, desc: 'Sweet and creamy.' },
//     { id:7,name:'banana',img:'assets/images/banana.png',price:70,desc:'fresh banana.'},
//      { id:8,name:'Papai',img:'assets/images/papai.JPEG',price:70,desc:'fresh banana.'},
//    { id:9,name:'Guva',img:'assets/images/Guva.png',price:70,desc:'fresh banana.'},
//    { id:10,name:'Dadim',img:'assets/images/Dadim.JPEG',price:70,desc:'fresh banana.'},
//     { id:11,name:'Orange',img:'assets/images/Orange Photo.png',price:70,desc:'fresh banana.'},
//     {id:12,name:'Watermelon',img:'assets/images/Watermelon.JPEG',price:60,desc:'fresh watermelon'},
    
//    ];

  
//   openDetails(fruit: any) {
//     this.selectedFruit = fruit;
//     this.showModal = true;  }

  
//   closeModal() {
//     this.showModal = false;
//   }

  
//    currentSlide = 0;
//    itemsPerSlide = 6;

//   get totalSlides() {
//     return Math.ceil(this.fruits.length / this.itemsPerSlide);
//   }

// getVisibleFruits() {
//     const start = this.currentSlide * this.itemsPerSlide;
//     const end = start + this.itemsPerSlide;
//      return this.fruits.slice(start, end);
//   }

//   nextSlide() {
//     this.currentSlide = (this.currentSlide + 1) % this.totalSlides;
//   }

//   prevSlide() {
//     this.currentSlide = (this.currentSlide - 1 + this.totalSlides) % this.totalSlides;
//   }











// }









