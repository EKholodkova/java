public class RunningTrack implements Obstacle {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    public boolean overcomeObstacle(Participant o) {
        if(o.run(length)) {
            return true;
        } else {
            return false;
        }
    }
}
