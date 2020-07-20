public class Robot implements Participant {
    private String name;
    private int maxRunLength;
    private int maxJumpHeight;

    public Robot(String name, int maxRunLength, int maxJumpHeight) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }


    public boolean run(int i) {
        if(maxRunLength >= i) {
            System.out.println(name + " пробежал по беговой дорожке.");
            return true;
        } else {
            System.out.println(name + " не смог пробежать дистанцию.");
            System.out.println(name + " не может продолжать соревноваться.");
            return false;
        }
    }

    public boolean jump(int i) {
        if(maxJumpHeight >= i) {
            System.out.println(name + " перепрыгнул через препятствие.");
            return true;
        } else {
            System.out.println(name + " не смог перепрыгнуть через препятствие.");
            System.out.println(name + " не может продолжать соревноваться.");
            return false;
        }
    }
}
