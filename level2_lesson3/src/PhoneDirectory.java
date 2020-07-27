import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneDirectory {
    private Map<String, Set<String>> phoneNumbers;

    public PhoneDirectory() {
        phoneNumbers = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(!phoneNumbers.containsKey(name)) {
            phoneNumbers.put(name, new HashSet<>());
        }
        Set<String> pNumbers = phoneNumbers.get(name);
        pNumbers.add(phoneNumber);

    }

    public Set<String> get(String k) {
        return phoneNumbers.get(k);
    }

    public void print() {
        System.out.println(phoneNumbers);
    }
}
