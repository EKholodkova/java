public class Main2 {
    public static void main(String[] args) {
        DoublyLinkedList names = new DoublyLinkedList();
        names.add("Nick");
        names.add("John");
        names.add("Mary");
        System.out.println(names);
        names.add(3, "Alex");
        names.add(1, "Sam");
        System.out.println(names);
        System.out.println(names.toStringPrev());
        System.out.println("Size: " + names.getSize());

        DoublyLinkedList.ForwardIterator forwardIterator = names.forwardIterator();
        while (forwardIterator.hasNext()) {
            String value = forwardIterator.next();
            System.out.println(value);
        }

        DoublyLinkedList.BackwardIterator backwardIterator = names.backwardIterator();
        while (backwardIterator.hasPrev()) {
            String value = backwardIterator.prev();
            System.out.println(value);
        }
    }
}
