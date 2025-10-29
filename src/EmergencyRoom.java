import java.util.*;

/**
 * EmergencyRoom class - manages patient triage using a PriorityQueue
 * STUDENT TODO: Complete the implementation of this class
 */
public class EmergencyRoom {
    private PriorityQueue<Patient> patientQueue;
    
    /**
     * Constructor - Initialize the PriorityQueue with your custom Comparator
     * STUDENT TODO: Create a Comparator that orders patients by:
     *   1. Severity level (lower number = higher priority)
     *   2. Arrival time (earlier arrival = higher priority if severity is equal)
     */
    public EmergencyRoom() {
        // TODO: Initialize patientQueue with a custom Comparator
        // Hint: You can use a lambda expression or create a separate Comparator class
        // Example structure: new PriorityQueue<>((p1, p2) -> { /* your comparison logic */ })
        
        patientQueue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                // TODO: Implement comparison logic here
                // Step 1: Compare severity levels (lower is higher priority)
                // Step 2: If severity is equal, compare arrival times (earlier is higher priority)
                return 0; // REPLACE THIS
            }
        });
    }
    
    /**
     * Admits a patient to the emergency room queue
     * @param p Patient to admit
     */
    public void admitPatient(Patient p) {
        // TODO: Add the patient to the priority queue
    }
    
    /**
     * Treats (removes and returns) the next highest priority patient
     * @return The patient to be treated, or null if queue is empty
     */
    public Patient treatNextPatient() {
        // TODO: Remove and return the highest priority patient
        // Hint: What PriorityQueue method removes and returns the head?
        return null; // REPLACE THIS
    }
    
    /**
     * Returns the number of patients currently waiting
     * @return Number of patients in queue
     */
    public int getWaitingPatients() {
        // TODO: Return the size of the queue
        return 0; // REPLACE THIS
    }
    
    /**
     * Returns (without removing) the next patient to be treated
     * @return The next patient, or null if queue is empty
     */
    public Patient peekNextPatient() {
        // TODO: Return the head of the queue without removing it
        // Hint: What PriorityQueue method lets you view the head?
        return null; // REPLACE THIS
    }
    
    /**
     * Gets all patients in priority order (for display purposes)
     * This creates a copy to avoid modifying the original queue
     * @return List of patients in priority order
     */
    public List<Patient> getAllPatientsInOrder() {
        List<Patient> patients = new ArrayList<>();
        PriorityQueue<Patient> tempQueue = new PriorityQueue<>(patientQueue);
        while (!tempQueue.isEmpty()) {
            patients.add(tempQueue.poll());
        }
        return patients;
    }
}
