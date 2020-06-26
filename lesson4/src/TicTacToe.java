import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        playGame();
    } //стартовый метод. Вызывает метод playGame

    static void playGame() { //метод playGame
        System.out.println("Hello, Sir!");
        System.out.println("There is the TicTacToe game!");
        System.out.println("===============");

        int fieldSize = 5;    //  объявление игрового поля и инициализация его размера
        char[][] field;

        Scanner scanner = new Scanner(System.in);
        boolean isProceed;     // оюъявление логической переменной, отвечающей за продолжение игры
        boolean isWin;         // объявление логической переменной, отвечающей за выигрыш
        char playerSign = 'X';
        char computerSign = 'O';  // объявление и инициализация игроков
        char currentPlayer;

        do {
            field = getField(fieldSize); //массиву field присваивается результат метода getField с параметром fieldSize
            drawField(field); //вызов метода

            currentPlayer = playerSign; //присваивание игрока символьной переменной currentPlayer
            boolean isDraw; //объявление логической переменной

            do {
                doMove(field, fieldSize, currentPlayer);
                isWin = checkWin5X5(field, currentPlayer);

                System.out.println("Updating...");
                System.out.println("===============");
                drawField(field);
                if (isWin) break;

                currentPlayer = changePlayer(currentPlayer);
                isDraw = isDraw(field);
            } while (!isDraw);

            String winnerName = currentPlayer == 'X' ? "Player" : "Computer";
            System.out.println(String.format("Congratulations, you [%s] are winner", winnerName));

            System.out.println("Do you to proceed?");
            isProceed = scanner.nextBoolean();
        } while (isProceed);
    }

    static boolean isDraw(char[][] field) { //объявление логического метода isDraw с параметром в виде массива field
        int count = field.length * field[0].length;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != '-') {
                    count--;
                }
            }
        }
        return count == 0;
    }

    static void drawField(char[][] field) { // метод, который распечатывает игровое поле
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.print("\n");
        }
    }

    static char[][] getField(int size) { // метод, устанавливающий размеры поля и прорисовывающий пустые игровые ячейки
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = '-';
            }
        }
        return field;
    }

    static char changePlayer(char sign) { //метод, меняющий игрока после очередного хода
//        if (sign == 'X') {
//            return 'O';
//        } else {
//            return 'X';
//        }
        return sign == 'X' ? 'O' : 'X';
    }

    static void doMove(char[][] field, int fieldSize, char sign) { //метод, осуществляющий ход игроков
        int x, y;
        if (sign == 'X') { //условие для человека
            Scanner scanner = new Scanner(System.in);
            System.out.println(String.format("Please write down X-Axis value from 1 to %s", fieldSize));
            x = scanner.nextInt();
            System.out.println(String.format("Please write down Y-Axis value from 1 to %s", fieldSize));
            y = scanner.nextInt();

            x = checkCoordinate(x, fieldSize); //проверка корректности введенной координаты х
            y = checkCoordinate(y, fieldSize); //проверка корректности введенной координаты у

            putValueByCoordinates(field, x, y, fieldSize, sign); //вызов метода, заполняющего игровую ячейку X или O
        } else { //условие для компьютера
            Random random = new Random();
            x = random.nextInt(fieldSize); //генерация целого случайного числа от 0 до fieldSize
            y = random.nextInt(fieldSize);
            putValueByCoordinates(field, x, y, fieldSize, sign); //вызов метода, заполняющего игровую ячейку X или O
        }
    }

    static boolean checkWin5X5(char[][] field, char sign) {
        for(int i = 0; i <= field.length - 4; i++) {
            for(int j = 0; j <= field[i].length - 4; j++) {
                if(checkWin(field, sign, i, j))
                    return true;
            }
        }
        return false;
    }


    static boolean checkWin(char[][] field, char sign, int x, int y) {//метод, определяющий победу одного из игроков
        int amount = 4;
        for (int i = x; i < amount + x; i++) {
            if (field[i][y] == sign && field[i][y + 1] == sign && field[i][y + 2] == sign && field[i][y + 3] == sign) {
                return true;
            }
        }
        if(field[x][y] == sign && field[x + 1][y + 1] == sign && field[x + 2][y + 2] == sign && field[x + 3][y + 3] == sign ||
                field [x + 3][y] == sign && field[x + 2][y + 1] == sign && field[x + 1][y + 2] == sign && field[x][y + 3] == sign) {
            return true;
        }

        for(int i = y; i < amount + y; i++) {
            if(field[x][i] == sign && field[x + 1][i] == sign && field[x + 2][i] == sign && field[x + 3][i] == sign) {
                return true;
            }
        }
        return false;
    }

    static int checkCoordinate(int coordinate, int fieldSize) { //метод, проверяющий корректность введенных координат
        while (coordinate < 1 || coordinate > fieldSize) {
            System.out.println(String.format("[X|Y]-Axis: %s is incorrect. Correct range from 1 to %s", coordinate, fieldSize));
            coordinate = reInputCoordinate(fieldSize);
        }
        return coordinate;
    }

    static int reInputCoordinate(int fieldSize) { //метод для повторного ввода координат
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Please write down [X|Y]-Axis value from 1 to %s", fieldSize));
        return scanner.nextInt();
    }

    static void putValueByCoordinates(char[][] field, int x, int y, int fieldSize, char sign) {
        if (sign == 'X') {
            putValueAsPlayer(field, x, y, fieldSize);
        } else {
            putValueAsComputer(field, x, y, fieldSize);
        }
    }

    static void putValueAsComputer(char[][] field, int x, int y, int fieldSize) {//метод, устанавливающий символ О в ячейку. Если она занято, повторно запускается генерация случайных чисел
        Random random = new Random();
        while (field[x][y] != '-') {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        }
        System.out.println(String.format("Computer puts value to [x: %s, y:%s]", x, y));
        field[x][y] = 'O';
    }

    static void putValueAsPlayer(char[][] field, int x, int y, int fieldSize) { //метод, устанавливающий символ Х в ячейку. В качестве параметров принимает координаты х,у, введенные пользователем, и проверяет их на занятость
        while (field[x - 1][y - 1] != '-') {
            System.out.println(String.format("X-Axis: %s, Y-Axis: %s already occupied", x, y));
            x = reInputCoordinate(fieldSize);
            x = checkCoordinate(x, fieldSize);

            y = reInputCoordinate(fieldSize);
            y = checkCoordinate(y, fieldSize);
        }
        System.out.println(String.format("Putting value to [x: %s, y:%s]", x, y));
        field[x - 1][y - 1] = 'X';
    }
}
