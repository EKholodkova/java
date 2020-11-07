import java.io.File;
import java.util.Arrays;
import java.util.logging.*;

public class ArrayMethods {
    private static final Logger logger = Logger.getLogger(ArrayMethods.class.getName());


    public static void main(String[] args) throws Throwable {
        Handler handler = new FileHandler("my_log.log");
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        int[] myArray = {1,8,16,90,11,5,8};
        getNewArray(myArray);
    }

    public static int[] getNewArray(int[] array) {
        if(array == null) {
            throw new NullPointerException();
        }
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] == 4) {
                return Arrays.copyOfRange(array, i+1, array.length);
            }
        }
        logger.log(Level.SEVERE, "В массиве нет значения <4>");
        throw new RuntimeException("В массиве нет значения <4>");

    }

    public static boolean checkArrayData1(int[] array) {
        if(array == null) {
            throw new NullPointerException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 4 && array[i] != 1) {
                    return false;
            }
            sum = sum + array[i];
        }
        if(array.length - sum == 0 || 4 * array.length - sum == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkArrayData(int[] array) {
        if(array == null) {
            throw new NullPointerException();
        }
        boolean isOne = false;
        boolean isFour = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 1 && array[i] != 4) {
                return false;
            }
            if(array[i] == 1) {
                isOne = true;
            }
            if(array[i] == 4) {
                isFour = true;
            }
        }
        return isOne && isFour;
    }
}
