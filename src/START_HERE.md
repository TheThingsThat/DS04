# Quick Start Guide

### Step 1: Complete the TODOs
Open these two files and complete the TODO sections:
- `EmergencyRoom.java`
- `TaskScheduler.java`

### Step 2 : Run the Program
...and then, you know, debug as needed. Not much more else to say.



## What You'll See

The GUI has two tabs:

### Tab 1: Emergency Room
- Add patients with different severity levels
- See them automatically sorted by priority
- Critical patients (red) always appear first
- Among same severity, earlier arrivals come first

### Tab 2: Task Scheduler  
- Add tasks with different priorities
- See them automatically sorted
- High priority (red) tasks always appear first
- Among same priority, shorter tasks come first
- Among same priority and time, alphabetical order

## Testing Your Code

1. Click "Load Sample Data" on each tab
2. Check if the table shows items in correct order
3. Click "Treat Next Patient" or "Get Next Task"
4. Verify the correct item is removed
5. Check the console output at the bottom

## What Should Happen?

### Emergency Room Sample Data Order:
1. Emily Davis (Severity 1, Arrival 25) - Critical, later arrival
2. Sarah Smith (Severity 1, Arrival 15) - Critical, earlier arrival  
3. Mike Johnson (Severity 2, Arrival 5) - Urgent, earliest
4. Lisa Wilson (Severity 2, Arrival 8) - Urgent, later
5. John Doe (Severity 3, Arrival 10) - Semi-urgent
6. Robert Brown (Severity 4, Arrival 20) - Non-urgent

Wait, let me fix that - the order should be based on the sample data loaded:

1. Sarah Smith (Severity 1, Arrival 15)
2. Robert Brown (Severity 1, Arrival 25)
3. Mike Johnson (Severity 2, Arrival 5)
4. Lisa Wilson (Severity 2, Arrival 8)
5. John Doe (Severity 3, Arrival 10)
6. Emily Davis (Severity 4, Arrival 20)

### Task Scheduler Sample Data Order:
1. Security Patch (Priority 1, 15 min)
2. Fix Login Bug (Priority 1, 30 min)
3. Add Unit Tests (Priority 2, 45 min)
4. Code Review (Priority 2, 45 min)
5. Database Optimization (Priority 2, 90 min)
6. Update README (Priority 3, 20 min)
7. Update Documentation (Priority 3, 120 min)



## Tips

1. **Start with EmergencyRoom** - it's simpler with only 2 comparison levels
2. **Test frequently** - compile and run after each method you complete
3. **Use the sample data** - it's designed to test all scenarios
4. **Read error messages** - they often tell you exactly what's wrong

## Color Coding

The GUI uses colors to help you verify correctness:

**Emergency Room:**
- 🔴 Red = Critical (1)
- 🟠 Orange = Urgent (2)  
- 🟡 Yellow = Semi-urgent (3)
- 🟢 Green = Non-urgent (4)

**Task Scheduler:**
- 🔴 Red = High priority (1)
- 🟠 Orange = Medium priority (2)
- 🟢 Green = Low priority (3)

If same-color items aren't in the right order, check your secondary comparisons!

Good luck! 🎯
