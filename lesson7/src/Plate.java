public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if(food < n) {
            System.out.println("There is not enough food in the plate");
            return false;
        } else {
            food -= n;
            return true;
        }
    }
    public void printInfo() {
        System.out.println("plate: " + food);
    }
    public void addFood(int amount) {
        food = food + amount;
        printInfo();
    }
    public int getFood() {
        return food;
    }
    public void setFood(int food) {
        this.food = food;
    }
}
