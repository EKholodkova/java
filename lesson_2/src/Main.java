public class Main {

    public static void main(String[] args) {
        changeValue();
        System.out.println();
        fillArray();
        System.out.println();
        doubleValue();
        System.out.println();
        fillTable();

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

}
