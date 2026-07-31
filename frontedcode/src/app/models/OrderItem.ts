// order-item.model.ts
export interface OrderItem {
  id?: number;
  fruit: { id: number; name?: string; image?: string }; // Backend Fruit Entity mapping
  quantity: number;
  price: number; // Order ke waqt ka price
}