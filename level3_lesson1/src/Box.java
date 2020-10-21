import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list;

    public Box() {
        list = new ArrayList<T>();
    }

    public void put (T obj) {
            list.add(obj);
    }

    public float getWeight() {
        float weight = list.size() * list.get(0).getWeight();
        return weight;
    }

    public <E extends Fruit> boolean compare(Box<E> anotherBox) {
        boolean c = getWeight() == anotherBox.getWeight();
        System.out.println("The weight of the boxes is the same: " + c);
        return c;
    }

    public void putToAnotherBox (Box<T> anotherBox) {
        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()) {
            T obj = iterator.next();
            anotherBox.list.add(obj);
            iterator.remove();
        }

 /*       for (T obj : list) {
            anotherBox.put(obj);
        }
        list.clear();*/

        System.out.println(list);
        System.out.println(anotherBox.list);
    }
}
