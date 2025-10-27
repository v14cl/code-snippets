import java.util.HashMap;
import java.util.Map;

public class MapTasks {
    private Map<String, String> items = new HashMap<>();
    private Map<String, String> users = new HashMap<>();

    public void addItem(String key, String value) {
        items.put(key, value);
    }

    public void removeItem(String key) {
        items.remove(key);
    }

    public boolean containsKey(String key) {
        return items.containsKey(key);
    }

    public boolean containsValue(String value) {
        return items.containsValue(value);
    }

    public String getItem(String key) {
        return items.get(key);
    }

    public int countItems() {
        return items.size();
    }

    public void clearAll() {
        items.clear();
    }

    public void printAll() {
        System.out.print(items);
    }

    public void mergeWith(Map<String, String> otherMap) {
        items.putAll(otherMap);
    }

    public void removeAllIn(Map<String, String> otherMap) {
        otherMap.keySet().forEach(items::remove);
    }

    public void retainCommon(Map<String, String> otherMap) {
        items.keySet().retainAll(otherMap.keySet());
    }

    public boolean registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            return true;
        }
        return false;
    }
}
