import java.util.Set;

public class PhoneDirectoryApp {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Ivanov", "5552338");
        phoneDirectory.add("Petrov", "4957032");
        phoneDirectory.add("Sidorov","6874321");
        phoneDirectory.add("Petrov", "8710637");

        printRec("Ivanov", phoneDirectory.get("Ivanov"));
        printRec("Petrov", phoneDirectory.get("Petrov"));
    }

    public static void printRec(String k, Set<String> nums) {
        System.out.println(k + " : " + nums);
    }
}
