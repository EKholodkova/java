import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        OneLinkedList names = new OneLinkedList();

        names.add("Nick");
        names.add("John");
        names.add("Mary");
        System.out.println(names);
        names.add(3, "Alice");
        System.out.println(names);
        names.add(3, "David");
        System.out.println(names);
        System.out.println("Size: " + names.getSize());
//        names.add(6, "Leon");

        OneLinkedList.Iterator iterator = names.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }
    }
}
