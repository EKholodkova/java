public class Cat extends Animal {
    private int durationOfNapping;

    public Cat(String name, String color, int age, double maxJumpHeight, double maxRunLength, double maxSwimLength, int durationOfNapping) {
        super(name, color, age, maxJumpHeight, maxRunLength, maxSwimLength);
        this.durationOfNapping = durationOfNapping;
    }

    @Override
    public void printInfo() {
        System.out.println("Cat.name: " + name + ", color: " + color + ", age: " + age + ", max jump height: " + maxJumpHeight +
                ", max run length: " + maxRunLength + ", max swim length: " + maxSwimLength + ", duration of napping: " + durationOfNapping);
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
