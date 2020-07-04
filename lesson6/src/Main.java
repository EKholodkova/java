public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "black", 6, 7, 180, 0.2, 19);
        Dog dog = new Dog("Archie", "brown", 4, 0.8,850,230,"leather");
        cat.printInfo();
        dog.printInfo();
        dog.swim(130.6);
        dog.run(1000);
        dog.jump(1.5);
        cat.swim(1);
        cat.run(150);
        cat.jump(5);

    }
}
