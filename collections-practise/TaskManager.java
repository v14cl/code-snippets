import java.util.*;

public class TaskManager {
    private PriorityQueue<Task> tasks;

    public TaskManager() {
        tasks = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));
    }

    static class Task {
        private String name;
        private int priority;
        private int duration;

        public Task(String name, int priority, int duration) {
            this.name = name;
            this.priority = priority;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return name + " (priority: " + priority + ", duration: " + duration + " min)";
        }
    }

    public void addTask(String name, int priority, int duration) {
        tasks.add(new Task(name, priority, duration));
    }

    public Task pollTask() {
        return tasks.poll();
    }

    public Task peekTask() {
        return tasks.peek();
    }

    public List<Task> getTasksLongerThan(int minutes) {
        List<Task> result = new ArrayList<>();
        tasks.forEach(task -> {
            if (task.getDuration() > minutes) {
                result.add(task);
            }
        });
        return result;
    }

    public List<Task> sortByDuration() {
        List<Task> result = new ArrayList<>(tasks);
        result.sort(Comparator.comparingInt(Task::getDuration));
        return result;
    }

    public void printTasks() {
        List<Task> tasksCopy = new ArrayList<>(tasks);
        tasksCopy.sort(Comparator.comparingInt(Task::getPriority));
        System.out.println(tasksCopy);
    }
}
