export interface User {
  name: string;
  email: string;
  password?: string; // Optional during checkout
  address: string;
  city?: string;    // Added this
  role: string;
}