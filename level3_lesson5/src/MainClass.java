import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int  CARS_COUNT =  4;

    public static void main (String[]args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" );
        Race race =  new  Race(CARS_COUNT, new  Road( 60 ),  new  Tunnel(CARS_COUNT),  new  Road( 40 ));
        Car[] cars =  new  Car[CARS_COUNT];

        for  ( int  i =  0 ; i < cars.length; i++) {
            cars[i] =  new  Car(race,  20  + ( int ) (Math.random() *  10 ), cdl);
        }


        for  ( int  i =  0 ; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        cdl.await();


        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" );
    }
}
