import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentGradesManager {

    private static Map<String, List<Integer>> students = new HashMap<>();

    public void addStudent(String name) {
        students.putIfAbsent(name, new ArrayList<>());
    }

    public void addGrade(String name, int grade) {
        if (students.containsKey(name)) {
            students.get(name).add(grade);
        } else {
            System.out.println("Student is not found: " + name);
        }
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public void showGrades(String name) {
        List<Integer> grades = students.get(name);
        if (grades != null) {
            System.out.println(name + ": " + grades);
        } else {
            System.out.println("Student is not found: " + name);
        }
    }

    public void showAllStudents() {
        for (String name : students.keySet()) {
            System.out.println(name);
        }
    }

    static Map<String, Double> calculateAverageGrades() {
        return students.entrySet().stream()
                .collect(Collectors.toMap(
                        Entry::getKey,
                        e -> e.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0)));
    }

    public void removeStudentsWithoutGrades() {
        students.entrySet().removeIf(e -> e.getValue().isEmpty());
    }

    static String getTopStudent() {
        return students.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.0)))
                .map(Entry::getKey)
                .orElse("");
    }

    static String getLowestStudent() {
        return students.entrySet().stream()
                .min(Comparator.comparingDouble(e -> e.getValue().stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.0)))
                .map(Entry::getKey)
                .orElse("");
    }

    static List<Entry<String, List<Integer>>> sortStudentsByAverageAsc() {
        return students.entrySet().stream()
                .sorted(Comparator.comparingDouble(e -> e.getValue().stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0)))
                .collect(Collectors.toList());
    }

    static List<Entry<String, List<Integer>>> sortStudentsByAverageDesc() {
        return students.entrySet().stream()
                .sorted(Comparator
                        .comparingDouble((Entry<String, List<Integer>> e) -> e.getValue().stream()
                                .mapToInt(Integer::intValue).average().orElse(0.0))
                        .reversed())
                .collect(Collectors.toList());
    }

    public void printUniqueStudents() {
        students.keySet().stream().distinct().forEach(System.out::println);
    }

    public void printStudentsWithHighAverage() {
        students.entrySet().stream()
                .filter(e -> e.getValue().stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.0) >= 10)
                .forEach(e -> System.out.println(e.getKey() + " → " +
                        e.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0)));
    }
}
