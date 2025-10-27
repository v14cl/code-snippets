import java.util.ArrayList;
import java.util.Collections;

public class ListTasks {
    private ArrayList<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public void insertInMiddle(String item) {
        items.add(items.size() / 2, item);
    }

    public void removeByIndex(int index) {
        items.remove(index);
    }

    public int findItem(String item) {
        return items.indexOf(item);
    }

    public void sortList() {
        Collections.sort(items);
    }

    public void replaceItem(int index, String newItem) {
        items.set(index, newItem);
    }

    public void printAll() {
        System.out.println(items);
    }

    public void removeContaining(String substring) {
        items.removeIf(item -> item.toLowerCase().contains(substring.toLowerCase()));
    }

    public void reverseList() {
        Collections.reverse(items);
    }

    public void mergeWith(ArrayList<String> otherList) {
        items.addAll(otherList);
    }
}
