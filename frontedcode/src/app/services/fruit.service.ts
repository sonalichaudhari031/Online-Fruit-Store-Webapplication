import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fruit } from '../models/fruit';

@Injectable({
  providedIn: 'root'
})
export class FruitService {
  // 1. Backend URL
  private apiUrl = 'http://localhost:8080/api/fruits'; 

  constructor(private http: HttpClient) {}

  // 2. Single Fruit Detail fetch karne ke liye (Ye line zaroori hai details page ke liye)
  getFruitById(id: number): Observable<Fruit> {
    return this.http.get<Fruit>(`${this.apiUrl}/${id}`);
  }

  // 3. Database se saare fruits lane ke liye
  getAllFruits(): Observable<Fruit[]> {
    return this.http.get<Fruit[]>(this.apiUrl);
  }

  // 4. Shop ID ke hisaab se fruits fetch karne ke liye
  getFruitsByShop(shopId: number): Observable<Fruit[]> {
    return this.http.get<Fruit[]>(`${this.apiUrl}/shop/${shopId}`);
  }

  // 5. Delete karne ke liye
  deleteFruit(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // 6. Naya Fruit add karne ke liye
  addFruit(fruit: any): Observable<any> {
    return this.http.post(this.apiUrl, fruit);
  }

  // 7. Image Upload karne ke liye
  uploadFruitImage(file: File): Observable<string> {
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post(`${this.apiUrl}/upload`, formData, { responseType: 'text' });
  }
}