import { Idelivery } from "./idelivery";

export interface Iorders {
    id: number;
    orderDate: Date;
    receiver: string;
    deliveryAddress: string;
    totalPrice: number;
    delivery: Idelivery;
}
