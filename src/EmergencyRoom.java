import java.util.*;

public class EmergencyRoom {
    private PriorityQueue<Patient> patientQueue;

    public EmergencyRoom() {
        patientQueue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                int severityComp = Integer.compare(p1.getSeverityLevel(), p2.getSeverityLevel());
                if (severityComp != 0) {
                    return severityComp;
                }else {
                    return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
                }
            }
        });
    }

    public void admitPatient(Patient p) {
        patientQueue.offer(p);
    }

    public Patient treatNextPatient() {
        return patientQueue.poll();
    }

    public int getWaitingPatients() {
        return patientQueue.size();
    }

    public Patient peekNextPatient() {
        return patientQueue.peek();
    }

    public List<Patient> getAllPatientsInOrder() {
        List<Patient> patients = new ArrayList<>();
        PriorityQueue<Patient> tempQueue = new PriorityQueue<>(patientQueue);
        while (!tempQueue.isEmpty()) {
            patients.add(tempQueue.poll());
        }
        return patients;
    }
}
