import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * PriorityQueueGUI - Interactive GUI for testing PriorityQueue exercises
 * This GUI allows students to visually test their EmergencyRoom and TaskScheduler implementations
 */
public class PriorityQueueGUI extends JFrame {
    
    // Exercise 1: Emergency Room components
    private EmergencyRoom emergencyRoom;
    private DefaultTableModel patientTableModel;
    private JTable patientTable;
    private JTextField patientNameField;
    private JComboBox<String> severityCombo;
    private JSpinner arrivalTimeSpinner;
    private JLabel waitingCountLabel;
    private JTextArea erOutputArea;
    
    // Exercise 2: Task Scheduler components
    private TaskScheduler taskScheduler;
    private DefaultTableModel taskTableModel;
    private JTable taskTable;
    private JTextField taskNameField;
    private JComboBox<String> priorityCombo;
    private JSpinner estimatedTimeSpinner;
    private JTextField assignedToField;
    private JLabel remainingTasksLabel;
    private JTextArea tsOutputArea;
    
    public PriorityQueueGUI() {
        setTitle("PriorityQueue Exercises - Student Template");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Initialize data structures
        emergencyRoom = new EmergencyRoom();
        taskScheduler = new TaskScheduler();
        
        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Exercise 1: Emergency Room", createEmergencyRoomPanel());
        tabbedPane.addTab("Exercise 2: Task Scheduler", createTaskSchedulerPanel());
        
        add(tabbedPane);
    }
    
    /**
     * Creates the Emergency Room exercise panel
     */
    private JPanel createEmergencyRoomPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Top panel - Input form
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Admit Patient"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Patient Name
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Patient Name:"), gbc);
        gbc.gridx = 1;
        patientNameField = new JTextField(15);
        inputPanel.add(patientNameField, gbc);
        
        // Severity Level
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Severity Level:"), gbc);
        gbc.gridx = 1;
        String[] severityLevels = {"1 - Critical", "2 - Urgent", "3 - Semi-urgent", "4 - Non-urgent"};
        severityCombo = new JComboBox<>(severityLevels);
        inputPanel.add(severityCombo, gbc);
        
        // Arrival Time
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Arrival Time (min):"), gbc);
        gbc.gridx = 1;
        arrivalTimeSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        inputPanel.add(arrivalTimeSpinner, gbc);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton admitButton = new JButton("Admit Patient");
        JButton treatButton = new JButton("Treat Next Patient");
        JButton peekButton = new JButton("Peek Next Patient");
        JButton clearButton = new JButton("Clear All");
        JButton sampleButton = new JButton("Load Sample Data");
        
        buttonPanel.add(admitButton);
        buttonPanel.add(treatButton);
        buttonPanel.add(peekButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(sampleButton);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);
        
        // Center panel - Patient table
        String[] patientColumns = {"Priority", "Name", "Severity", "Description", "Arrival Time"};
        patientTableModel = new DefaultTableModel(patientColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        patientTable = new JTable(patientTableModel);
        patientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        patientTable.setRowHeight(25);
        
        // Color code rows by severity
        patientTable.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    String severity = table.getValueAt(row, 2).toString();
                    switch (severity) {
                        case "1":
                            c.setBackground(new Color(255, 200, 200)); // Light red
                            break;
                        case "2":
                            c.setBackground(new Color(255, 230, 200)); // Light orange
                            break;
                        case "3":
                            c.setBackground(new Color(255, 255, 200)); // Light yellow
                            break;
                        case "4":
                            c.setBackground(new Color(200, 255, 200)); // Light green
                            break;
                        default:
                            c.setBackground(Color.WHITE);
                    }
                }
                return c;
            }
        });
        
        JScrollPane tableScrollPane = new JScrollPane(patientTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Patient Queue (Priority Order)"));
        
        // Bottom panel - Status and output
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        
        waitingCountLabel = new JLabel("Waiting Patients: 0");
        waitingCountLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(waitingCountLabel, BorderLayout.NORTH);
        
        erOutputArea = new JTextArea(8, 50);
        erOutputArea.setEditable(false);
        erOutputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane outputScrollPane = new JScrollPane(erOutputArea);
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("Console Output"));
        bottomPanel.add(outputScrollPane, BorderLayout.CENTER);
        
        // Add all panels to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Event handlers
        admitButton.addActionListener(e -> admitPatient());
        treatButton.addActionListener(e -> treatNextPatient());
        peekButton.addActionListener(e -> peekNextPatient());
        clearButton.addActionListener(e -> clearEmergencyRoom());
        sampleButton.addActionListener(e -> loadSamplePatients());
        
        return mainPanel;
    }
    
    /**
     * Creates the Task Scheduler exercise panel
     */
    private JPanel createTaskSchedulerPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Top panel - Input form
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Task"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Task Name
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Task Name:"), gbc);
        gbc.gridx = 1;
        taskNameField = new JTextField(15);
        inputPanel.add(taskNameField, gbc);
        
        // Priority Level
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Priority Level:"), gbc);
        gbc.gridx = 1;
        String[] priorityLevels = {"1 - High", "2 - Medium", "3 - Low"};
        priorityCombo = new JComboBox<>(priorityLevels);
        inputPanel.add(priorityCombo, gbc);
        
        // Estimated Time
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Estimated Time (min):"), gbc);
        gbc.gridx = 1;
        estimatedTimeSpinner = new JSpinner(new SpinnerNumberModel(30, 1, 500, 5));
        inputPanel.add(estimatedTimeSpinner, gbc);
        
        // Assigned To
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Assigned To:"), gbc);
        gbc.gridx = 1;
        assignedToField = new JTextField(15);
        inputPanel.add(assignedToField, gbc);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Task");
        JButton nextButton = new JButton("Get Next Task");
        JButton completeButton = new JButton("Complete Task");
        JButton clearButton = new JButton("Clear All");
        JButton sampleButton = new JButton("Load Sample Data");
        
        buttonPanel.add(addButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(sampleButton);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);
        
        // Center panel - Task table
        String[] taskColumns = {"Priority", "Task Name", "Priority Level", "Description", "Time (min)", "Assigned To"};
        taskTableModel = new DefaultTableModel(taskColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        taskTable = new JTable(taskTableModel);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskTable.setRowHeight(25);
        
        // Color code rows by priority
        taskTable.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    String priority = table.getValueAt(row, 2).toString();
                    switch (priority) {
                        case "1":
                            c.setBackground(new Color(255, 200, 200)); // Light red
                            break;
                        case "2":
                            c.setBackground(new Color(255, 240, 200)); // Light orange
                            break;
                        case "3":
                            c.setBackground(new Color(200, 255, 200)); // Light green
                            break;
                        default:
                            c.setBackground(Color.WHITE);
                    }
                }
                return c;
            }
        });
        
        JScrollPane tableScrollPane = new JScrollPane(taskTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Task Queue (Priority Order)"));
        
        // Bottom panel - Status and output
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        
        remainingTasksLabel = new JLabel("Remaining Tasks: 0");
        remainingTasksLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(remainingTasksLabel, BorderLayout.NORTH);
        
        tsOutputArea = new JTextArea(8, 50);
        tsOutputArea.setEditable(false);
        tsOutputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane outputScrollPane = new JScrollPane(tsOutputArea);
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("Console Output"));
        bottomPanel.add(outputScrollPane, BorderLayout.CENTER);
        
        // Add all panels to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Event handlers
        addButton.addActionListener(e -> addTask());
        nextButton.addActionListener(e -> getNextTask());
        completeButton.addActionListener(e -> completeTask());
        clearButton.addActionListener(e -> clearTaskScheduler());
        sampleButton.addActionListener(e -> loadSampleTasks());
        
        return mainPanel;
    }
    
    // ========== Emergency Room Methods ==========
    
    private void admitPatient() {
        try {
            String name = patientNameField.getText().trim();
            if (name.isEmpty()) {
                showError("Please enter a patient name.");
                return;
            }
            
            int severity = severityCombo.getSelectedIndex() + 1;
            int arrivalTime = (Integer) arrivalTimeSpinner.getValue();
            
            Patient patient = new Patient(name, severity, arrivalTime);
            emergencyRoom.admitPatient(patient);
            
            erOutputArea.append("✓ Patient admitted: " + patient + "\n");
            patientNameField.setText("");
            updatePatientTable();
            
        } catch (Exception ex) {
            showError("Error admitting patient: " + ex.getMessage());
        }
    }
    
    private void treatNextPatient() {
        try {
            Patient patient = emergencyRoom.treatNextPatient();
            if (patient == null) {
                erOutputArea.append("⚠ No patients waiting.\n");
            } else {
                erOutputArea.append("► Treating patient: " + patient.getName() + 
                                  " (Severity: " + patient.getSeverityLevel() + 
                                  ", Arrival: " + patient.getArrivalTime() + ")\n");
            }
            updatePatientTable();
        } catch (Exception ex) {
            showError("Error treating patient: " + ex.getMessage());
        }
    }
    
    private void peekNextPatient() {
        try {
            Patient patient = emergencyRoom.peekNextPatient();
            if (patient == null) {
                erOutputArea.append("⚠ No patients waiting.\n");
            } else {
                erOutputArea.append("👁 Next patient: " + patient + "\n");
            }
        } catch (Exception ex) {
            showError("Error peeking patient: " + ex.getMessage());
        }
    }
    
    private void clearEmergencyRoom() {
        emergencyRoom = new EmergencyRoom();
        updatePatientTable();
        erOutputArea.append("✓ Emergency room cleared.\n\n");
    }
    
    private void loadSamplePatients() {
        clearEmergencyRoom();
        
        Patient[] samples = {
            new Patient("John Doe", 3, 10),
            new Patient("Sarah Smith", 1, 15),
            new Patient("Mike Johnson", 2, 5),
            new Patient("Emily Davis", 4, 20),
            new Patient("Robert Brown", 1, 25),
            new Patient("Lisa Wilson", 2, 8)
        };
        
        erOutputArea.append("=== Loading Sample Patients ===\n");
        for (Patient p : samples) {
            emergencyRoom.admitPatient(p);
            erOutputArea.append("Admitted: " + p + "\n");
        }
        erOutputArea.append("\n");
        updatePatientTable();
    }
    
    private void updatePatientTable() {
        patientTableModel.setRowCount(0);
        List<Patient> patients = emergencyRoom.getAllPatientsInOrder();
        
        int priority = 1;
        for (Patient p : patients) {
            patientTableModel.addRow(new Object[]{
                priority++,
                p.getName(),
                p.getSeverityLevel(),
                p.getSeverityDescription(),
                p.getArrivalTime()
            });
        }
        
        waitingCountLabel.setText("Waiting Patients: " + emergencyRoom.getWaitingPatients());
    }
    
    // ========== Task Scheduler Methods ==========
    
    private void addTask() {
        try {
            String taskName = taskNameField.getText().trim();
            if (taskName.isEmpty()) {
                showError("Please enter a task name.");
                return;
            }
            
            int priority = priorityCombo.getSelectedIndex() + 1;
            int estimatedTime = (Integer) estimatedTimeSpinner.getValue();
            String assignedTo = assignedToField.getText().trim();
            if (assignedTo.isEmpty()) {
                assignedTo = "Unassigned";
            }
            
            Task task = new Task(taskName, priority, estimatedTime, assignedTo);
            taskScheduler.addTask(task);
            
            tsOutputArea.append("✓ Task added: " + task + " → " + assignedTo + "\n");
            taskNameField.setText("");
            assignedToField.setText("");
            updateTaskTable();
            
        } catch (Exception ex) {
            showError("Error adding task: " + ex.getMessage());
        }
    }
    
    private void getNextTask() {
        try {
            Task task = taskScheduler.getNextTask();
            if (task == null) {
                tsOutputArea.append("⚠ No tasks in queue.\n");
            } else {
                tsOutputArea.append("► Next task: " + task.getTaskName() + 
                                  " (Priority: " + task.getPriorityLevel() + 
                                  ", Time: " + task.getEstimatedMinutes() + " min, " +
                                  "Assigned: " + task.getAssignedTo() + ")\n");
            }
            updateTaskTable();
        } catch (Exception ex) {
            showError("Error getting next task: " + ex.getMessage());
        }
    }
    
    private void completeTask() {
        try {
            Task task = taskScheduler.getNextTask();
            if (task == null) {
                tsOutputArea.append("⚠ No tasks to complete.\n");
            } else {
                tsOutputArea.append("✓ Completed: " + task.getTaskName() + "\n");
                updateTaskTable();
            }
        } catch (Exception ex) {
            showError("Error completing task: " + ex.getMessage());
        }
    }
    
    private void clearTaskScheduler() {
        taskScheduler = new TaskScheduler();
        updateTaskTable();
        tsOutputArea.append("✓ Task scheduler cleared.\n\n");
    }
    
    private void loadSampleTasks() {
        clearTaskScheduler();
        
        Task[] samples = {
            new Task("Fix Login Bug", 1, 30, "Bob"),
            new Task("Update Documentation", 3, 120, "Alice"),
            new Task("Security Patch", 1, 15, "Alice"),
            new Task("Code Review", 2, 45, "Charlie"),
            new Task("Database Optimization", 2, 90, "Bob"),
            new Task("Add Unit Tests", 2, 45, "Alice"),
            new Task("Update README", 3, 20, "Charlie")
        };
        
        tsOutputArea.append("=== Loading Sample Tasks ===\n");
        for (Task t : samples) {
            taskScheduler.addTask(t);
            tsOutputArea.append("Added: " + t + " → " + t.getAssignedTo() + "\n");
        }
        tsOutputArea.append("\n");
        updateTaskTable();
    }
    
    private void updateTaskTable() {
        taskTableModel.setRowCount(0);
        List<Task> tasks = taskScheduler.getAllTasksInOrder();
        
        int priority = 1;
        for (Task t : tasks) {
            taskTableModel.addRow(new Object[]{
                priority++,
                t.getTaskName(),
                t.getPriorityLevel(),
                t.getPriorityDescription(),
                t.getEstimatedMinutes(),
                t.getAssignedTo()
            });
        }
        
        remainingTasksLabel.setText("Remaining Tasks: " + taskScheduler.getRemainingTasks());
    }
    
    // ========== Utility Methods ==========
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PriorityQueueGUI gui = new PriorityQueueGUI();
            gui.setVisible(true);
        });
    }
}
