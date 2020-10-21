import java.util.ArrayList;
import java.util.Arrays;

public class GenMethods {
    public static void main(String[] args) {
        Integer[] ints = {19, 81, 6, 45, 12};
        swapElements(ints, 0, ints.length - 1);
        System.out.println(Arrays.deepToString(ints));

        ArrayList<Integer> list = turnArrayIntoList(ints);
        System.out.println(list);
    }

    public static <T> void swapElements(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /*public static <T> T[] swapElements(T[] array, int a, int b) {  вариант, чтобы разобраться с типом
        T temp = array[a];                                           возвращаемого значения
        array[a] = array[b];
        array[b] = temp;
        return array;
    }*/

    public static <T> ArrayList<T> turnArrayIntoList(T[]array) {
        ArrayList<T> list = new ArrayList<T>();
        for(int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
