import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
            int number = random.nextInt(10);
            int counter = 0;
            while (counter < 3) {
                System.out.println("Введите число от 0 до 9");
                int user_number = sc.nextInt();

                if (user_number == number) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (user_number < number) {
                    System.out.println("Ваше число меньше");
                } else {
                    System.out.println("Ваше число больше");
                }
                counter++;
            }
            if(counter == 3) {
                System.out.println("Вы проиграли!");
            }
            System.out.println("Повторить игру еще раз? 1 - да/ 0 - нет");
        } while (sc.nextInt() == 1);
    }
}