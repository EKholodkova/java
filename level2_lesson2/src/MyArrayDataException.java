public class MyArrayDataException extends Exception{
    public MyArrayDataException(int i, int j, String s) {
        super("Ячейка массива с координатами " + i + ", " + j + " содержит нечисловое значение " + s + ".");
    }
}
