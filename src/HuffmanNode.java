/**
 * HuffmanNode class - represents a node in the Huffman tree
 * Used for text compression using Huffman coding algorithm
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;
    
    /**
     * Constructor for leaf node (contains a character)
     */
    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Constructor for internal node (no character, combines two nodes)
     */
    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = '\0';  // Null character for internal nodes
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
    
    /**
     * Check if this is a leaf node
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    /**
     * Compare nodes by frequency (for PriorityQueue)
     * Lower frequency = higher priority
     */
    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }
    
    @Override
    public String toString() {
        if (isLeaf()) {
            return "'" + character + "': " + frequency;
        } else {
            return "Internal: " + frequency;
        }
    }
}
