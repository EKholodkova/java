import java.util.HashSet;
import java.util.Set;

public class BasicAuthService implements AuthService{
    private final Set<Record> records;

    public BasicAuthService() {
        records = new HashSet<>();
        records.add(new Record(1L, "John", "l1", "p1"));
        records.add(new Record(2L, "Tom", "l2", "p2"));
        records.add(new Record(3L, "Jerry", "l3", "p3"));
        records.add(new Record(4L, "Sam", "l4", "p4"));
        records.add(new Record(5L, "Sven", "l5", "p5"));
    }

    @Override
    public Record findRecord(String login, String password) {
        for(Record record : records) {
            if(record.getLogin().equals(login) && record.getPassword().equals(password)) {
                return record;
            }
        }
        return null;
    }


}
