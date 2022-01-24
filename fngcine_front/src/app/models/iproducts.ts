export interface Iproducts {
    get(arg0: string): Iproducts;
    
    id: number;
    label: string;
    description: string;
    urlImg: string;
    genre: string;
    unitPrice: number;
    qtyStock: number;
}
