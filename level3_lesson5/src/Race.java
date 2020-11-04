import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private CyclicBarrier startLine;
    private  ArrayList<Stage> stages;
    private Lock finishLine;

    public  ArrayList<Stage>  getStages () {
        return  stages;
    }

    public   Race (int carCount, Stage...stages) {
        this.stages =  new ArrayList<>(Arrays.asList(stages));
        startLine = new CyclicBarrier(carCount, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
        finishLine = new ReentrantLock();
    }

    public CyclicBarrier getStartLine() {
        return startLine;
    }

    public Lock getFinishLine() {
        return finishLine;
    }
}
