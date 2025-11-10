import java.util.*;

public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;

    public TaskScheduler() {
        taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {

                int priorityComp = Integer.compare(t1.getPriorityLevel(), t2.getPriorityLevel());
                if (priorityComp != 0) {
                    return priorityComp;
                }

                int timeComp = Integer.compare(t1.getEstimatedMinutes(), t2.getEstimatedMinutes());
                if (timeComp != 0) {
                    return timeComp;
                } else {
                    return t1.getTaskName().compareTo(t2.getTaskName());
                }
            }
        });
    }

    public void addTask(Task t) {
        taskQueue.add(t);
    }

    public Task getNextTask() {
        return taskQueue.poll();
    }

    public List<Task> getNextNTasks(int n) {
        PriorityQueue<Task> copy = new PriorityQueue<>(taskQueue);
        List<Task> tasks = new ArrayList<>(n); // IntelliJ bulk collection suggestion

        for (int i = 0; i < n && !copy.isEmpty(); i++) {
            tasks.add(copy.poll());
        }
        return tasks;
    }

    public void completeTask() {
        taskQueue.poll();
    }

    public int getRemainingTasks() {
        return taskQueue.size();
    }

    public List<Task> getAllTasksInOrder() {
        List<Task> tasks = new ArrayList<>();
        PriorityQueue<Task> tempQueue = new PriorityQueue<>(taskQueue);
        while (!tempQueue.isEmpty()) {
            tasks.add(tempQueue.poll());
        }
        return tasks;
    }
}
