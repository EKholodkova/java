public class BoxApp {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box();
        Box<Orange> box2 = new Box();
        Box<Apple> box3 = new Box();

        for(int i = 0; i < 10; i++) {
            box1.put(new Apple());
            box2.put(new Orange());
        }

        for(int i = 0; i < 3; i++) {
            box3.put(new Apple());
        }

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());

        box1.compare(box3);
        box1.compare(box2);

        box1.putToAnotherBox(box3);
    }
}
