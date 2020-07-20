public class Barrier implements Obstacle {
    private int height;

    public Barrier(int height) {
        this.height = height;
    }

    public boolean overcomeObstacle(Participant o) {
        if(o.jump(height)) {
            return true;
        } else {
            return false;
        }
    }
}
