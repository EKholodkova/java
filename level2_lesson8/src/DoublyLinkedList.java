public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(String val) {
        if(head == null) {
            head = new Node(val);
            tail = head;
            size++;
            return;
        }

        Node newNode = new Node(val);
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        size++;
    }

    public void add(int index, String val) {
        if (index > size) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s is more than real size %s", index, size));
        }

        if (index == 0) {
            if (head == null) {
                head = new DoublyLinkedList.Node(val);
                tail = head;
            } else {
                head.setValue(val);
            }
            return;
        }

        int currentIndex = 1;
        DoublyLinkedList.Node current = head.getNext();

        while (currentIndex != index) {
            current = current.getNext();
            currentIndex++;
        }

        if (current == null) {
            add(val);
        } else {
            current.setValue(val);
        }
    }

    public int getSize() {
        return size;
    }

    public ForwardIterator forwardIterator() {
        return new ForwardIterator(head);
    }

    public BackwardIterator backwardIterator() {
        return new BackwardIterator(tail);
    }


    private void add( String val, Node prev, Node current) {
        if(current == null) {
            Node newNode = new Node(val);
            prev.setNext(newNode);
            tail = newNode;
            return;
        }
        add(val, current, current.getNext());
    }




    private static class Node {
        private String value;
        private Node next;
        private Node prev;

        public Node(String value) {
            this(value, null, null);
        }

        public Node(String value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }

        public String toStringPrev() {
            if (prev != null)
                return "Node{" +
                        "value='" + value + '\'' +
                        ", prev=" + prev.toStringPrev() +
                        '}';
            else
                return "Node{" +
                        "value='" + value + '\'' +
                        ", prev=null }";
        }

    }


    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                '}';
    }

    public String toStringPrev() {
        return "DoublyLinkedList{" +
                "tail=" + tail.toStringPrev() +
                '}';
    }

    public static class ForwardIterator {
        private Node head;
        private Node current;

        private ForwardIterator() {

        }

        private ForwardIterator(Node current) {
            this.head = current;
        }

        public boolean hasNext() {
            if(current == null) {
                if(head != null) {
                    return true;
                } else {
                    return false;
                }
            }
            return current.getNext() != null;
        }

        public String next() {
            if(current == null) {
                current = head;
            } else {
                current = current.getNext();
            }
            return current.getValue();
        }
    }

    public static class BackwardIterator {
        private Node tail;
        private Node current;

        private BackwardIterator() {

        }

        private BackwardIterator(Node current) {
            this.tail = current;
        }

        public boolean hasPrev() {
            if(current == null) {
                if(tail != null) {
                    return true;
                } else {
                    return false;
                }
            }
            return current.getPrev() != null;
        }

        public String prev() {
            if(current == null) {
                current = tail;
            } else {
                current = current.getPrev();
            }
            return current.getValue();
        }
    }

}

