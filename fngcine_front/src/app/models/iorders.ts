import { Idelivery } from "./idelivery";

export interface Iorders {
    id: number;
    orderDate: Date;
    receiver: string;
    deliveryAddress: string;
    totalPrice: number;
    address: string;
    zipCode: number;
    city: string;
    delivery: Idelivery;
    userId: number;
    orderDetailList: Object;
}
