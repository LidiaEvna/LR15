package com.company;

public class Main {
    public static void main(String[] args) {
        Clothes []clothes={
                new Pants(Size.XXS,"бежевые",1500),
                new Skirt(Size.S,"голубая",2000),
                new Tie(Size.L,"черный",350),
                new TeeShirt(Size.M,"белая",750),
                new Pants(Size.XS,"серо-голубые",1700),
        };
        for (int i = 0; i< clothes.length; i++) {
            System.out.println(clothes[i].size);
            System.out.println(clothes[i].color);
            System.out.println(clothes[i].cost);
            System.out.println(" ");
        }
    }
}
enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    Size(int euroSize) {
        EuroSize = euroSize;
    }
    public String getDescription() {
        return "взрослый размер";
    }
    @Override
    public String toString() {
        return name() + "(" + EuroSize + ") " + getDescription();
    }
    private int EuroSize;
}
interface Mensclothing{
    static void DressMens() {
        System.out.println("Одеваем мужчину");
    }
}
interface Womensclothing{
    static void DressWomen(){
        System.out.println("Одеваем женщину");
    }
}
abstract class Clothes{
    Size size;
    String color;
    int cost;

    public Clothes(Size size,String color,int cost){
        this.size=size;
        this.color=color;
        this.cost=cost;
    }
}
class TeeShirt extends Clothes implements Mensclothing,Womensclothing{
    public TeeShirt(Size size, String color,int cost) {
        super(size, color,cost);
    }
}
class Pants extends Clothes implements Mensclothing,Womensclothing {
    public Pants(Size size, String color, int cost) {
        super(size, color, cost);
    }
}
class Skirt extends Clothes implements  Womensclothing {
    public Skirt(Size size, String color, int cost) {
        super(size, color, cost);
    }
}
class Tie extends Clothes implements Mensclothing{
    public Tie(Size size, String color,int cost) {
        super(size, color,cost);
    }
}
class Atelier {
    public void DressMens(Clothes[] clothes){
        System.out.println("Мужская одежда в наличии: ");
        for (Clothes clothes1:clothes){
            if (clothes1 instanceof Mensclothing){
                System.out.println(clothes1);
            }
        }
    }
    public void DressWomen(Clothes[]clothes){
        System.out.println("Женская одежда в наличии: ");
        for (Clothes clothes1 : clothes){
            if (clothes1 instanceof Womensclothing){
                System.out.println(clothes1);
            }
        }
    }
}