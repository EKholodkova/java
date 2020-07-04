public class Dog extends Animal {
    private String collar;


    public Dog(String name, String color, int age, double maxJumpHeight, double maxRunLength, double maxSwimLength, String collar) {
        super(name, color, age, maxJumpHeight, maxRunLength, maxSwimLength);
        this.collar = collar;
    }

    @Override
    public void printInfo() {
        System.out.println("Dog.name: " + name + ", color: " + color + ", age: " + age + ", max jump height: " + maxJumpHeight +
                ", max run length: " + maxRunLength + ", max swim length: " + maxSwimLength + ", collar: " + collar);
    }

    @Override
    public void run(double length) {
        System.out.println("Run: " + (length <= maxRunLength));
    }

    @Override
    public void swim(double length) {
        System.out.println("Swim: " + (length <= maxSwimLength));
    }

    @Override
    public void jump(double height) {
        System.out.println("Jump: " + (height <= maxJumpHeight));
    }



}
