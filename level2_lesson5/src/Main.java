import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        doMethod1();
        doMethod2();
    }

    public static void doMethod1() {
        float[] arr = new float[size];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long fin = System.currentTimeMillis();
        System.out.println(fin - start);
    }

    public static void doMethod2() {
        float[] arr = new float[size];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long start = System.currentTimeMillis();
        float[]arr1 = new float[h];
        float[]arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Thread t1 = new Thread(new ArrCalculator(arr1, 0));
        Thread t2 = new Thread(new ArrCalculator(arr2, h));
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

            System.arraycopy(arr1, 0, arr, 0, h);
            System.arraycopy(arr2, 0, arr, h, h);

            long fin = System.currentTimeMillis();
            System.out.println(fin - start);

        } catch(InterruptedException e) {
            System.out.println("Что-то пошло не так..");
            e.printStackTrace();
        }


    }
}
