/**
 * Task class for Task Scheduler System
 * Represents a task with priority level, estimated time, and assignment
 */
public class Task {
    private String taskName;
    private int priorityLevel;      // 1 = High, 2 = Medium, 3 = Low
    private int estimatedMinutes;   // Time to complete
    private String assignedTo;
    
    /**
     * Constructor for Task
     * @param taskName Name of the task
     * @param priorityLevel Priority level (1-3)
     * @param estimatedMinutes Estimated time in minutes
     * @param assignedTo Person assigned to task
     */
    public Task(String taskName, int priorityLevel, int estimatedMinutes, String assignedTo) {
        if (taskName == null || taskName.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty");
        }
        if (priorityLevel < 1 || priorityLevel > 3) {
            throw new IllegalArgumentException("Priority level must be between 1 and 3");
        }
        if (estimatedMinutes <= 0) {
            throw new IllegalArgumentException("Estimated time must be positive");
        }
        this.taskName = taskName;
        this.priorityLevel = priorityLevel;
        this.estimatedMinutes = estimatedMinutes;
        this.assignedTo = assignedTo;
    }
    
    // Getters
    public String getTaskName() {
        return taskName;
    }
    
    public int getPriorityLevel() {
        return priorityLevel;
    }
    
    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }
    
    public String getAssignedTo() {
        return assignedTo;
    }
    
    // Setters
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty");
        }
        this.taskName = taskName;
    }
    
    public void setPriorityLevel(int priorityLevel) {
        if (priorityLevel < 1 || priorityLevel > 3) {
            throw new IllegalArgumentException("Priority level must be between 1 and 3");
        }
        this.priorityLevel = priorityLevel;
    }
    
    public void setEstimatedMinutes(int estimatedMinutes) {
        if (estimatedMinutes <= 0) {
            throw new IllegalArgumentException("Estimated time must be positive");
        }
        this.estimatedMinutes = estimatedMinutes;
    }
    
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    /**
     * Returns priority level as a string description
     */
    public String getPriorityDescription() {
        switch (priorityLevel) {
            case 1: return "High";
            case 2: return "Medium";
            case 3: return "Low";
            default: return "Unknown";
        }
    }
    
    @Override
    public String toString() {
        return taskName + " (Priority: " + priorityLevel + ", Time: " + estimatedMinutes + " min)";
    }
}
