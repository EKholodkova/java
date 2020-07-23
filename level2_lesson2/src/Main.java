public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(printSumArr(createArr()));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    public static String[][] createArr() {
        String[][] arr = {
                {"2", "3", "6", "7"},
                {"4", "5", "8", "9"},
                {"1", "6", "0", "8"},
                {"7", "2", "5", "three"}
        };
        return arr;
    }

    public static int printSumArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }
}
