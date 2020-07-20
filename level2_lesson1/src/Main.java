public class Main {
    public static void main(String[] args) {
        Participant[] participants = {new Man("Человек", 1500, 2),
                                      new Cat("Кот", 2300, 4),
                                      new Robot("Робот", 15000, 9)};
        Obstacle[] obstacles = {new RunningTrack(2000), new Barrier(5)};

        for(int i = 0; i < participants.length; i++) {
            for(int j = 0; j < obstacles.length; j++) {
                if(!obstacles[j].overcomeObstacle(participants[i])) {
                    break;
                }
            }
        }
    }
}
