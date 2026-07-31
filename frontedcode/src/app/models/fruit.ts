export interface Fruit {
  id: number;
  name: string;
  description: string;
  price: number;
  unit: string;
  img: string;
  quantity: number;
  available?: boolean | number;
  shop?: {
    shop_id: number;
    shopName: string;
  };
  shopId?: number; 
  shopName?: string;
}