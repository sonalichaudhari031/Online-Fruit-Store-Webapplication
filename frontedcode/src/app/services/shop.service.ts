import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Shop } from '../models/shop';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private apiUrl = 'http://localhost:8080/api/shops';

  constructor(private http: HttpClient) {}

  // ✅ Admin ke shops
  getShopsByAdmin(adminId: number): Observable<Shop[]> {
    return this.http.get<Shop[]>(`${this.apiUrl}?adminId=${adminId}`);
  }

  // ✅ Single shop
  getShopById(id: number): Observable<Shop> {
    return this.http.get<Shop>(`${this.apiUrl}/${id}`);
  }

  // ✅ Create shop (admin)
  createShop(shop: Shop): Observable<Shop> {
    return this.http.post<Shop>(this.apiUrl, shop);
  }

  // ✅ Update shop
  updateShop(id: number, shop: Shop): Observable<Shop> {
    return this.http.put<Shop>(`${this.apiUrl}/${id}`, shop);
  }

  // ✅ Delete shop
  deleteShop(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
  
// shop.service.ts mein check karein
getAllShops(): Observable<Shop[]> {
  // Yahan '/all' nahi aayega kyunki controller mein sirf @GetMapping hai
  return this.http.get<Shop[]>("http://localhost:8080/api/shops"); 
}

 

}
