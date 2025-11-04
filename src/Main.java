import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PriorityQueueGUI gui = new PriorityQueueGUI();
            gui.setVisible(true);
        });
    }

}