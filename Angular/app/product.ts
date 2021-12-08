export class Product {
    public  productId!: number;
    public  productType!: string ;
    public  productName!: string;
    public  category!: string;
    public  rating!: Map<number,number>;
    public  review!: Map<number,string>;
    public  image!: string;
    public  price!: string;
    public  description!: string;
    public specification!:Map<string,string>;
}
