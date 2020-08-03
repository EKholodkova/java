public class ArrCalculator implements Runnable{
    float[] arr;
    int index;

    public ArrCalculator(float[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public void run() {
        for(int i = 0; i < arr.length; i ++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (index + i) / 5) * Math.cos(0.2f + (index + i) / 5) * Math.cos(0.4f + (index +i) / 2));
        }
    }
}
