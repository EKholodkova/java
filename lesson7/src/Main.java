import javax.xml.catalog.Catalog;

public class Main {
    public static void main(String[] args) {
        /*Cat cat1 = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Vaska", 100);
        Plate plate1 = new Plate(100);
        plate1.printInfo();
        cat1.eat(plate1);
        plate1.printInfo();
        plate1.setFood ( plate1.getFood ()   -  cat1.getAppetite ());
        plate1.printInfo();
        cat2.eat(plate1);
        plate1.printInfo();*/

        Plate commonPlate = new Plate(100);
        Cat[] cats = makeArray();
        feedArray(commonPlate, cats);
        commonPlate.addFood(300);
        feedArray(commonPlate, cats);
    }

    public static Cat[] makeArray() {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Barsik", 5);
        cats[1] = new Cat("Vaska", 20);
        cats[2] = new Cat("Murka", 30);
        cats[3] = new Cat("Tishka", 50);
        cats[4] = new Cat("Mashka",70);
        return cats;
    }

    public static void feedArray(Plate p, Cat[] catsToFeed) {
        for(int i = 0; i < 5; i++) {
            catsToFeed[i].eat(p);
        }
    }
}
