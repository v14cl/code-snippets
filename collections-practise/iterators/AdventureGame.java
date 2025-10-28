package iterators;

import java.util.*;

public class AdventureGame {

    private List<String> inventory;

    public AdventureGame() {
        inventory = new ArrayList<>();
        inventory.add("Sword");
        inventory.add("Shield");
        inventory.add("Potion");
        inventory.add("Bow");
        inventory.add("Arrow");
        inventory.add("Potion");
        inventory.add("");
        inventory.add("Helmet");
        inventory.add("Spear");
        inventory.add("Armor");
    }

    public void printInventory() {
        Iterator<String> it = inventory.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void printItemsWithA() {
        Iterator<String> it = inventory.iterator();

        while (it.hasNext()) {
            String item = it.next();
            if (item.contains("a")) {
                System.out.println(item);
            }
        }
    }

    public void removeEmptyItems() {
        Iterator<String> it = inventory.iterator();

        while (it.hasNext()) {
            if (it.next().length() == 0) {
                it.remove();
            }
        }
    }

    public int countLongItems() {
        Iterator<String> it = inventory.iterator();
        int count = 0;
        while (it.hasNext()) {
            if (it.next().length() > 5) {
                count++;
            }
        }
        return count;
    }

    public void upgradePotions() {
        ListIterator<String> it = inventory.listIterator();
        while (it.hasNext()) {
            if (it.next().equals("Potion")) {
                it.set("SuperPotion");
            }
        }
    }

    public void printReverse() {
        ListIterator<String> it = inventory.listIterator(inventory.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    public void insertGoldAfterSword() {
        ListIterator<String> it = inventory.listIterator();
        while (it.hasNext()) {
            if (it.next().equals("Sword")) {
                it.add("Gold");
            }
        }
    }

    public void removeBelowAverageLength() {
        if (inventory.isEmpty())
            return;

        int totalLength = 0;
        for (String item : inventory) {
            totalLength += item.length();
        }
        double averageLength = totalLength / (double) inventory.size();

        Iterator<String> it = inventory.iterator();
        while (it.hasNext()) {
            if (it.next().length() < averageLength) {
                it.remove();
            }
        }
    }

    public List<String> uniqueInventory() {
        List<String> uniqueInventory = new ArrayList<>();
        ListIterator<String> it = inventory.listIterator();
        while (it.hasNext()) {
            String item = it.next();
            if (!uniqueInventory.contains(item)) {
                uniqueInventory.add(item);
            }
        }
        return uniqueInventory;
    }

    public void printList(List<String> list) {
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
