package com.company;

public class Main {
    public static void main(String[] args) {
        Clothes []clothes={
                new Pants(Size.XXS,"черные",4500,"Брюки"),
                new Skirt(Size.XS,"голубая",2000,"Юбка"),
                new Tie(Size.S,"бардовый",1500,"Галстук"),
                new TeeShirt(Size.M,"белая",750,"Футболка"),
                new Pants(Size.L,"серо-голубые",1700,"Брюки"),
        };
        for (int i = 0; i< clothes.length; i++) {
            System.out.println(clothes[i].name);
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
    String name;
    int cost;

    public Clothes(Size size,String color,int cost, String name){
        this.size=size;
        this.color=color;
        this.cost=cost;
        this.name=name;
    }
}
class TeeShirt extends Clothes implements Mensclothing,Womensclothing{
    public TeeShirt(Size size, String color,int cost, String name) {
        super(size, color,cost, name);
    }
}
class Pants extends Clothes implements Mensclothing,Womensclothing {
    public Pants(Size size, String color, int cost, String name) {
        super(size, color, cost, name);
    }
}
class Skirt extends Clothes implements  Womensclothing {
    public Skirt(Size size, String color, int cost, String name) {
        super(size, color, cost, name);
    }
}
class Tie extends Clothes implements Mensclothing{
    public Tie(Size size, String color,int cost, String name) {
        super(size, color,cost, name);
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