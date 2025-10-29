import java.util.*;

/**
 * TaskScheduler class - manages task scheduling using a PriorityQueue
 * STUDENT TODO: Complete the implementation of this class
 */
public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;
    
    /**
     * Constructor - Initialize the PriorityQueue with your custom Comparator
     * STUDENT TODO: Create a Comparator that orders tasks by:
     *   1. Priority level (lower number = higher priority)
     *   2. Estimated time (shorter tasks first if priority is equal)
     *   3. Task name alphabetically (if both priority and time are equal)
     */
    public TaskScheduler() {
        // TODO: Initialize taskQueue with a custom Comparator
        // Hint: You'll need to compare multiple fields in sequence
        
        taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                // TODO: Implement comparison logic here
                // Step 1: Compare priority levels (lower is higher priority)
                // Step 2: If priority is equal, compare estimated minutes (shorter first)
                // Step 3: If both are equal, compare task names alphabetically
                return 0; // REPLACE THIS
            }
        });
    }
    
    /**
     * Adds a task to the scheduler
     * @param t Task to add
     */
    public void addTask(Task t) {
        // TODO: Add the task to the priority queue
    }
    
    /**
     * Gets and removes the next highest priority task
     * @return The next task, or null if queue is empty
     */
    public Task getNextTask() {
        // TODO: Remove and return the highest priority task
        return null; // REPLACE THIS
    }
    
    /**
     * Gets the next n tasks without removing them
     * @param n Number of tasks to retrieve
     * @return List of next n tasks in priority order
     */
    public List<Task> getNextNTasks(int n) {
        // TODO: Return the next n tasks without removing them from the queue
        // Hint: You'll need to create a temporary copy of the queue
        List<Task> tasks = new ArrayList<>();
        
        // Your implementation here
        
        return tasks;
    }
    
    /**
     * Completes (removes) the highest priority task
     */
    public void completeTask() {
        // TODO: Remove the highest priority task
    }
    
    /**
     * Returns the number of remaining tasks
     * @return Number of tasks in queue
     */
    public int getRemainingTasks() {
        // TODO: Return the size of the queue
        return 0; // REPLACE THIS
    }
    
    /**
     * Gets all tasks in priority order (for display purposes)
     * This creates a copy to avoid modifying the original queue
     * @return List of tasks in priority order
     */
    public List<Task> getAllTasksInOrder() {
        List<Task> tasks = new ArrayList<>();
        PriorityQueue<Task> tempQueue = new PriorityQueue<>(taskQueue);
        while (!tempQueue.isEmpty()) {
            tasks.add(tempQueue.poll());
        }
        return tasks;
    }
}
