/**
 * Patient class for Emergency Room Triage System
 * Represents a patient with severity level and arrival time
 */
public class Patient {
    private String name;
    private int severityLevel;  // 1 = Critical, 2 = Urgent, 3 = Semi-urgent, 4 = Non-urgent
    private int arrivalTime;    // Time in minutes since ER opened
    
    /**
     * Constructor for Patient
     * @param name Patient's name
     * @param severityLevel Severity level (1-4)
     * @param arrivalTime Arrival time in minutes
     */
    public Patient(String name, int severityLevel, int arrivalTime) {
        if (severityLevel < 1 || severityLevel > 4) {
            throw new IllegalArgumentException("Severity level must be between 1 and 4");
        }
        if (arrivalTime < 0) {
            throw new IllegalArgumentException("Arrival time must be non-negative");
        }
        this.name = name;
        this.severityLevel = severityLevel;
        this.arrivalTime = arrivalTime;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getSeverityLevel() {
        return severityLevel;
    }
    
    public int getArrivalTime() {
        return arrivalTime;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSeverityLevel(int severityLevel) {
        if (severityLevel < 1 || severityLevel > 4) {
            throw new IllegalArgumentException("Severity level must be between 1 and 4");
        }
        this.severityLevel = severityLevel;
    }
    
    public void setArrivalTime(int arrivalTime) {
        if (arrivalTime < 0) {
            throw new IllegalArgumentException("Arrival time must be non-negative");
        }
        this.arrivalTime = arrivalTime;
    }
    
    /**
     * Returns severity level as a string description
     */
    public String getSeverityDescription() {
        switch (severityLevel) {
            case 1: return "Critical";
            case 2: return "Urgent";
            case 3: return "Semi-urgent";
            case 4: return "Non-urgent";
            default: return "Unknown";
        }
    }
    
    @Override
    public String toString()     {
        return name + " (Severity: " + severityLevel + ", Arrival: " + arrivalTime + ")";
    }
}
