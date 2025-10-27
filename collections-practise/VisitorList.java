import java.util.*;

public class VisitorList {
    private static List<String> visitors = new ArrayList<>();

    public static void main(String args[]) {
        printMostFrequent();
    }

    public void addVisitor(String name) {
        visitors.add(name);
    }

    public static void printMostFrequent() {
        Set<String> uniqueVisitorsSet = new HashSet<>(visitors);
        List<String> uniqueVisitors = new ArrayList<>(uniqueVisitorsSet);

        List<String> mostFreqVisitors = new ArrayList<>();
        int maxCount = 0;

        for (String name : uniqueVisitors) {
            int count = Collections.frequency(visitors, name);
            System.out.println(name + " → " + count);

            if (count > maxCount) {
                maxCount = count;
                mostFreqVisitors.clear();
                mostFreqVisitors.add(name);
            } else if (count == maxCount) {
                mostFreqVisitors.add(name);
            }
        }

        System.out.println("Most frequent visitors: " + mostFreqVisitors + " (" + maxCount + " visits)");
    }

}
