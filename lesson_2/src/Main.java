public class Main {

    public static void main(String[] args) {
        changeValue();
        System.out.println();
        fillArray();
        System.out.println();
        doubleValue();
        System.out.println();
        fillTable();
        System.out.println();
        findMinMax();
    }

    public static void changeValue() {

        int[] arr = {1, 0, 0, 1, 1, 0, 0, 0, 1, 0};
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                arr[i] = arr[i] - 1;
            } else {
                arr[i] = arr[i] + 1;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void fillArray() {

        int[] arr = new int[8];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
            System.out.print(arr[i] + " ");
        }
    }

    public static void doubleValue() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) {
                arr[i] = arr[i] * 2;
            } /*else {
                arr[i] = arr[i];
            }*/
            System.out.print(arr[i] + " ");
        }
    }

    public static void fillTable() {
        int [][] table = new int[5][5];
        for(int i = 0; i < 5; i++) {
            table[i][i] = 1;
        }
        printArr(table);
    }

    public static void printArr(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void findMinMax() {
        int[] arr = {666, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int minimum = arr[0];
        int maximum = arr[0];
        for(int i = 0; i < arr.length; i++){
            //System.out.println(minimum + " " + arr[i]);
            minimum = min(minimum, arr[i]);
            maximum = max(maximum, arr[i]);
        }
        System.out.println("Минимальное значение - " + minimum);
        System.out.println("Максимальное значение - " + maximum);
    }

    public static int min(int a, int b) {
        if(a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max(int a, int b) {
        if(a > b) {
            return a;
        } else {
            return b;
        }
    }

}
