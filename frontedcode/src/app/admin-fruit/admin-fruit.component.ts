import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FruitService } from '../services/fruit.service';
import { ShopService } from '../services/shop.service';
import { Fruit } from '../models/fruit';
import { Shop } from '../models/shop';

@Component({
  selector: 'app-admin-fruit',
  templateUrl: './admin-fruit.component.html',
  styleUrls: ['./admin-fruit.component.css']
})
export class AdminFruitComponent implements OnInit {
  shopId: number = 0;
  shopName: string = 'Select a Shop'; 
  allShops: Shop[] = []; 
  fruits: Fruit[] = [];
  selectedFile: File | null = null;
  
  newFruit: any = {
    name: '', description: '', price: 0, 
    unit: 'kg', img: '', quantity: 10
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fruitService: FruitService,
    private shopService: ShopService 
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('shopId');
    this.shopId = idParam && idParam !== 'undefined' ? Number(idParam) : 0;

    this.shopService.getAllShops().subscribe({
      next: (res: Shop[]) => {
        this.allShops = res;
        this.updateShopName(); 
        if (this.shopId !== 0) {
          this.loadFruits();
        }
      }
    });
  }

  updateShopName(): void {
    const selected = this.allShops.find(s => s.id == this.shopId);
    this.shopName = selected ? selected.shopName : 'Select a Shop';
  }

  onShopChange(): void {
    this.updateShopName(); 
    this.loadFruits(); 
    this.router.navigate(['/admin/fruits', this.shopId]); 
  }

  loadFruits(): void {
    if (this.shopId !== 0) {
      this.fruitService.getFruitsByShop(this.shopId).subscribe(res => {
        this.fruits = res;
      });
    }
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  // Final Correct Save Logic
  saveFruitWithImage() {
    if (!this.selectedFile) {
      alert("Pehle fruit ki photo select karein!");
      return;
    }
    if (this.shopId === 0) {
      alert("Pehle dukan (Shop) select karein!");
      return;
    }

    // 1. Pehle Image Upload karein
    this.fruitService.uploadFruitImage(this.selectedFile).subscribe({
      next: (fileName: string) => {
        // 2. Data format matching Java Entity (Shop link karna zaroori hai)
        const fruitData = {
          name: this.newFruit.name,
          price: this.newFruit.price,
          unit: this.newFruit.unit,
          quantity: this.newFruit.quantity,
          img: fileName,
          description: this.newFruit.description || ('Fresh ' + this.newFruit.name),
          shop: { id: this.shopId } // Foreign Key mapping for MySQL
        };

        // 3. Database mein Save karein
        this.fruitService.addFruit(fruitData).subscribe(() => {
          alert(this.newFruit.name + " added to " + this.shopName + " successfully!");
          this.loadFruits(); // List refresh karein
          this.resetForm();
        });
      },
      error: (err) => alert("Upload failed! Backend check karein.")
    });
  }

  deleteFruit(id: number) {
    if(confirm('Delete this fruit?')) {
      this.fruitService.deleteFruit(id).subscribe(() => {
        alert('Deleted successfully!');
        this.loadFruits();
      });
    }
  }

  resetForm() {
    this.newFruit = { name: '', description: '', price: 0, unit: 'kg', img: '', quantity: 10 };
    this.selectedFile = null;
  }



  viewDetails(fruitId: any) {
  // fruitId ko number mein convert karke bhejna safe hai
  const id = Number(fruitId);
  console.log("Navigating to Fruit ID:", id); 
  this.router.navigate(['/product-details', id]); 
}
}