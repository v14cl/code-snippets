import java.util.*;

public class TaskList {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public List<String> findTasks(String keyword) {
        List<String> result = new ArrayList<>();
        tasks.forEach(task -> {
            if (task.contains(keyword)) {
                result.add(task);
            }
        });
        return result;
    }

    public void printTasks() {
        System.out.println(tasks);
    }

    public void sortTasksByLength() {
        tasks.sort((a, b) -> a.length() - b.length());
    }

    public List<String> tasksLongerThan(int length) {
        List<String> result = new ArrayList<>();
        tasks.forEach(task -> {
            if (task.length() > length) {
                result.add(task);
            }
        });
        return result;
    }
}
