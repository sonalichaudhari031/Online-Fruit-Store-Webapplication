import { Component, OnInit } from '@angular/core';
import { ShopService } from '../services/shop.service';
import { Router } from '@angular/router';
import { Shop } from '../models/shop';

@Component({
  selector: 'app-admin-shop',
  templateUrl: './admin-shop.component.html',
  styleUrls: ['./admin-shop.component.css']
})
export class AdminShopComponent implements OnInit {
  shops: Shop[] = [];
  adminId: number = 1; // Filhal static, login ke baad dynamic hoga

  constructor(private shopService: ShopService, private router: Router) {}

  ngOnInit(): void {
    this.loadAdminShops();
  }

  loadAdminShops() {
    // Ye method database se shops fetch karega
    this.shopService.getShopsByAdmin(this.adminId).subscribe(res => {
      this.shops = res;
    });
  }

  goToManageFruits(id: number) {
  // Ye aapko routing module ke through '/admin/fruits/:shopId' par le jayega
  this.router.navigate(['/admin/fruits', id]); 
}

  deleteShop(id: number) {
    if(confirm('Are you sure you want to delete this shop?')) {
      this.shopService.deleteShop(id).subscribe(() => this.loadAdminShops());
    }
  }
}