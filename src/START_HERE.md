# Priority Queue Exercises - Quick Start Guide

## Overview
This project contains three exercises that teach PriorityQueue concepts through interactive GUI applications:
1. **Emergency Room Triage** - Priority based on medical severity
2. **Task Scheduler** - Priority with multiple tiebreakers
3. **Huffman Compression** - Building optimal trees with PriorityQueue

## Step 1: Complete the TODOs

Open these files and complete the TODO sections:
- `EmergencyRoom.java` - Implement patient triage system
- `TaskScheduler.java` - Implement task priority system
- `HuffmanCompressor.java` - Implement text compression algorithm

## Step 2: Run the Program

Compile and run:
```bash
You'll launch from PriorityQueueGUI'
```

Then test your implementations and debug as needed!

---

## What You'll See

The GUI has three tabs:

### Tab 1: Emergency Room 🏥
- Add patients with different severity levels (1=Critical, 4=Non-urgent)
- See them automatically sorted by priority
- Critical patients (red) always appear first
- Among same severity, earlier arrivals come first
- **Color coding**: Red → Orange → Yellow → Green

### Tab 2: Task Scheduler 📋
- Add tasks with different priorities (1=High, 3=Low)
- See them automatically sorted
- High priority (red) tasks always appear first
- Among same priority, shorter tasks come first
- Among same priority and time, alphabetical order
- **Color coding**: Red → Orange → Green

### Tab 3: Huffman Compression 🗜️
- Enter text to compress using Huffman coding
- See the frequency-based optimal compression
- View Huffman codes for each character
- Visualize the binary tree structure
- Test decompression to verify correctness
- **New!** Uses PriorityQueue to build optimal encoding tree

---

## Testing Your Code

1. Click "Load Sample Data" on each tab
2. Check if items appear in correct priority order
3. Click action buttons ("Treat Next Patient", "Get Next Task", "Compress Text")
4. Verify correct items are processed
5. Check console output at the bottom

---

## Expected Results

### Emergency Room Sample Data Order:
1. **Sarah Smith** (Severity 1, Arrival 15) - Critical, earlier
2. **Robert Brown** (Severity 1, Arrival 25) - Critical, later
3. **Mike Johnson** (Severity 2, Arrival 5) - Urgent, earliest
4. **Lisa Wilson** (Severity 2, Arrival 8) - Urgent, later
5. **John Doe** (Severity 3, Arrival 10) - Semi-urgent
6. **Emily Davis** (Severity 4, Arrival 20) - Non-urgent

### Task Scheduler Sample Data Order:
1. **Security Patch** (Priority 1, 15 min) - High priority, shorter
2. **Fix Login Bug** (Priority 1, 30 min) - High priority, longer
3. **Add Unit Tests** (Priority 2, 45 min) - Medium, shorter, comes before...
4. **Code Review** (Priority 2, 45 min) - Medium, same time (alphabetical)
5. **Database Optimization** (Priority 2, 90 min) - Medium, longest
6. **Update README** (Priority 3, 20 min) - Low priority, shorter
7. **Update Documentation** (Priority 3, 120 min) - Low priority, longer

### Huffman Compression Sample:
When you click "Load Sample Text", you should see:
- **Original size**: 400 bits (50 characters × 8 bits each)
- **Compressed size**: ~220-240 bits (depends on implementation)
- **Compression ratio**: ~55-60%
- **Huffman codes**: More frequent letters get shorter codes
    - Example: ' ' (space) might be "10" (2 bits)
    - Example: 'Z' might be "110110" (6 bits)
- **Tree visualization**: Shows the binary tree structure

---

## Understanding Huffman Compression

### How It Works:
1. **Count frequencies** - Count how often each character appears
2. **Build priority queue** - Create nodes for each character, ordered by frequency
3. **Build tree** - Repeatedly combine two lowest-frequency nodes
4. **Generate codes** - Traverse tree: left=0, right=1
5. **Encode** - Replace each character with its code

### Why PriorityQueue?
The PriorityQueue automatically gives us the two least frequent nodes at each step, making the algorithm efficient (O(n log n) instead of O(n²)).

### Testing Your Implementation:
1. Compress the sample text
2. Check that frequent characters (like 'E', ' ') have short codes (2-3 bits)
3. Check that rare characters have longer codes (6-8 bits)
4. Click "Decompress" - text should match original exactly!
5. Try your own text - compression should be 40-60% of original size

---

## Tips for Success

1. **Start with EmergencyRoom** - Simplest with only 2 comparison levels
2. **Then TaskScheduler** - Adds complexity with 3 comparison levels
3. **Finally HuffmanCompressor** - Most complex, builds on PriorityQueue understanding
4. **Test frequently** - Compile and run after each method you complete
5. **Use the sample data** - Designed to test all edge cases
6. **Read error messages** - They often tell you exactly what's wrong
7. **Check the tree visualization** - Helps debug Huffman algorithm

---

## Common Mistakes to Avoid

### Emergency Room:
- ❌ Comparing severity backwards (higher number = higher priority)
- ✓ Lower severity number = higher priority (1 is more urgent than 4)

### Task Scheduler:
- ❌ Forgetting to compare all three levels (priority, time, name)
- ✓ Check priority first, then time, then alphabetical

### Huffman Compression:
- ❌ Not handling single-character input
- ❌ Building tree incorrectly (wrong child assignment)
- ❌ Not recursing properly when generating codes
- ✓ Always test with "AAA" (single char) and normal text

---

## Debugging Hints

### If your order is wrong:
- Print out what you're comparing
- Check your comparison operators (< vs >)
- Make sure you're comparing the right fields

### If Huffman decompression fails:
- Check tree building - print out each step
- Verify codes - each should be unique and prefix-free
- Test with simple input like "AAABBC"

### If nothing shows in the GUI:
- Check for exceptions in console
- Make sure methods return values (not null)
- Verify you're adding to/removing from the PriorityQueue correctly

---

## Bonus Challenges

Once everything works:

1. **Emergency Room**: Add a "Rush Hour" mode that adjusts priorities
2. **Task Scheduler**: Add deadline tracking
3. **Huffman**: Calculate and display actual file size savings in bytes
4. **Huffman**: Add ability to save/load compressed files
5. **All**: Add unit tests for your implementations

---

## File Structure

```
├── PriorityQueueGUI.java      # Main GUI application
├── EmergencyRoom.java          # Exercise 1 (TODO)
├── Patient.java                # Patient data class
├── TaskScheduler.java          # Exercise 2 (TODO)
├── Task.java                   # Task data class
├── HuffmanCompressor.java      # Exercise 3 (TODO)
├── HuffmanNode.java            # Tree node for Huffman
└── README.md                   # This file
```

---

## Learning Objectives

By completing these exercises, you will:
- ✓ Understand how PriorityQueue works internally
- ✓ Learn to create custom Comparators
- ✓ Master multi-level comparison logic
- ✓ See real-world PriorityQueue applications
- ✓ Understand greedy algorithms (Huffman)
- ✓ Learn about data compression principles
- ✓ Build interactive GUIs with Java Swing

---

Good luck! 🎯

If you get stuck, remember:
1. Read the TODO comments carefully
2. Test with sample data
3. Check the expected output above
4. Print debug information
5. Ask for help if needed!