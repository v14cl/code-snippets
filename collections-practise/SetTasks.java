import java.util.HashSet;
import java.util.Set;

public class SetTasks {
    private Set<String> items = new HashSet<>();
    private Set<String> users = new HashSet<>();

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public boolean containsItem(String item) {
        return items.contains(item);
    }

    public int countItems() {
        return items.size();
    }

    public void clearAll() {
        items.clear();
    }

    public void printAll() {
        System.out.println(items);
    }

    public void mergeWith(Set<String> otherSet) {
        items.addAll(otherSet);
    }

    public void removeAllIn(Set<String> otherSet) {
        items.removeAll(otherSet);
    }

    public void retainCommon(Set<String> otherSet) {
        items.retainAll(otherSet);
    }

    public boolean registerUser(String username) {
        if (users.add(username)) {
            return true;
        }
        return false;
    }
}
