import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsersData {
    private List<DialogueApp.DataItem> list;

    public UsersData() {
        list = new ArrayList<>();
        DialogueApp.DataItem item0 = new DialogueApp.DataItem("John", "l1", "p1");
        DialogueApp.DataItem item1 = new DialogueApp.DataItem("Tom", "l2", "p2");
        DialogueApp.DataItem item2 = new DialogueApp.DataItem("Jerry", "l3", "p3");
        DialogueApp.DataItem item3 = new DialogueApp.DataItem("Sam", "l4", "p4");
        DialogueApp.DataItem item4 = new DialogueApp.DataItem("Sven", "l5", "p5");

        list.add(item0);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
    }

    public DialogueApp.DataItem findData(DialogueApp.Pair<String, String> pair) {
        for(int i = 0; i < list.size(); i++) {
            if(pair.login.equals(list.get(i).login) && pair.password.equals(list.get(i).password)) {
                return list.get(i);
            }
        }
        return null;
    }

    public boolean addData(DialogueApp.DataItem item) {
        if(!list.contains(item)) {
            list.add(item);
            return true;
        }
        return false;
    }

    public void printList() {
        for(DialogueApp.DataItem item : list) {
            System.out.println(item);
        }
    }


}
