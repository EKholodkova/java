public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;
    protected double maxJumpHeight;
    protected double maxRunLength;
    protected double maxSwimLength;


    public Animal(String name, String color, int age, double maxJumpHeight, double maxRunLength, double maxSwimLength) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
    }

    public abstract void printInfo();

    public abstract void run(double length);

    public abstract void swim(double length);

    public abstract void jump(double height);

}
