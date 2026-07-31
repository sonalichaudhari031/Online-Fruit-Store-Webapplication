import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private apiUrl = 'http://localhost:8080/api/cart-items'; 

  constructor(private http: HttpClient) { }

  addToCart(userId: number, fruitId: number, quantity: number): Observable<any> {
  // Fix: Use 'apiUrl' instead of 'baseUrl'
  const url = `${this.apiUrl}/add/${userId}/${fruitId}`; // baseUrl ki jagah apiUrl likhein
  
  // Sending null as body because data is in PathVariables and Params
  return this.http.post(url, null, {
    params: { quantity: quantity.toString() }
  });
}


  // ✅ Cart Page ke liye method
  getCartItemsByUserId(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/user/${userId}`);
  }

  // ✅ Checkout Page ke liye method (Fixes error 90)
  clearCart(userId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/clear/${userId}`);
  }

  // ✅ Single Item Delete ke liye
  removeItemFromCart(itemId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${itemId}`);
  }

  
}