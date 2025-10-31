import java.util.*;

/**
 * HuffmanCompressor class - compresses text using Huffman coding
 * STUDENT TODO: Complete the implementation of this class
 */
public class HuffmanCompressor {
    private HuffmanNode root;
    private Map<Character, String> huffmanCodes;
    private String originalText;
    private String compressedBits;
    
    public HuffmanCompressor() {
        huffmanCodes = new HashMap<>();
    }
    
    /**
     * Compresses the given text using Huffman coding
     * STUDENT TODO: Implement this method
     * 
     * Steps:
     * 1. Count frequency of each character
     * 2. Build Huffman tree using PriorityQueue
     * 3. Generate codes by traversing the tree
     * 4. Encode the text using the codes
     */
    public void compress(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty");
        }
        
        this.originalText = text;
        this.huffmanCodes.clear();
        
        // Step 1: Count character frequencies
        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);
        
        // Step 2: Build Huffman tree
        this.root = buildHuffmanTree(frequencyMap);
        
        // Step 3: Generate Huffman codes
        generateCodes(root, "");
        
        // Step 4: Encode the text
        this.compressedBits = encodeText(text);
    }
    
    /**
     * Builds a frequency map of characters in the text
     * STUDENT TODO: Complete this method
     */
    private Map<Character, Integer> buildFrequencyMap(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // TODO: Count the frequency of each character in the text
        // Hint: Iterate through the text and update the map
        for (char c : text.toCharArray()) {
            // TODO: Update frequency count for character c
        }
        
        return frequencyMap;
    }
    
    /**
     * Builds the Huffman tree using a PriorityQueue
     * STUDENT TODO: Complete this method
     * 
     * Algorithm:
     * 1. Create a PriorityQueue of HuffmanNodes
     * 2. Add all characters as leaf nodes
     * 3. While queue has more than 1 node:
     *    - Remove two nodes with lowest frequency
     *    - Create parent node with combined frequency
     *    - Add parent back to queue
     * 4. Return the final node (root of tree)
     */
    private HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        // TODO: Create a PriorityQueue of HuffmanNodes
        // Hint: PriorityQueue<HuffmanNode> will automatically use compareTo
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        
        // TODO: Add all characters as leaf nodes to the priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            // TODO: Create a HuffmanNode and add to pq
        }
        
        // Special case: if only one unique character
        if (pq.size() == 1) {
            HuffmanNode node = pq.poll();
            return new HuffmanNode(node.frequency, node, null);
        }
        
        // TODO: Build the tree by combining nodes
        while (pq.size() > 1) {
            // TODO: Remove two nodes with lowest frequency
            HuffmanNode left = null;  // REPLACE THIS
            HuffmanNode right = null; // REPLACE THIS
            
            // TODO: Create parent node with combined frequency
            HuffmanNode parent = null; // REPLACE THIS
            
            // TODO: Add parent back to queue
        }
        
        // TODO: Return the root (last remaining node)
        return null; // REPLACE THIS
    }
    
    /**
     * Generates Huffman codes by traversing the tree
     * STUDENT TODO: Complete this method
     * 
     * This is a recursive method that traverses the tree:
     * - Go left: add '0' to code
     * - Go right: add '1' to code
     * - At leaf: save the code for that character
     */
    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) {
            return;
        }
        
        // TODO: If this is a leaf node, save the code
        if (node.isLeaf()) {
            // Handle special case of single character
            huffmanCodes.put(node.character, code.isEmpty() ? "0" : code);
            return;
        }
        
        // TODO: Recursively traverse left (add '0' to code)
        
        // TODO: Recursively traverse right (add '1' to code)
    }
    
    /**
     * Encodes the text using the generated Huffman codes
     * STUDENT TODO: Complete this method
     */
    private String encodeText(String text) {
        StringBuilder encoded = new StringBuilder();
        
        // TODO: For each character in text, append its Huffman code
        for (char c : text.toCharArray()) {
            // TODO: Get the code for character c and append to encoded
        }
        
        return encoded.toString();
    }
    
    /**
     * Decodes the compressed bits back to original text
     * STUDENT TODO: Complete this method
     * 
     * Algorithm:
     * 1. Start at root of tree
     * 2. For each bit in compressed string:
     *    - If '0': go left
     *    - If '1': go right
     *    - If reach leaf: output character, restart at root
     */
    public String decompress() {
        if (compressedBits == null || root == null) {
            return "";
        }
        
        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;
        
        // TODO: Traverse the tree using the bits
        for (char bit : compressedBits.toCharArray()) {
            // TODO: Move left or right based on bit
            
            // TODO: If reached a leaf node, add character and reset to root
        }
        
        return decoded.toString();
    }
    
    // ========== Getter methods ==========
    
    public String getOriginalText() {
        return originalText;
    }
    
    public String getCompressedBits() {
        return compressedBits;
    }
    
    public Map<Character, String> getHuffmanCodes() {
        return new HashMap<>(huffmanCodes);
    }
    
    public int getOriginalBits() {
        return originalText == null ? 0 : originalText.length() * 8;
    }
    
    public int getCompressedBitCount() {
        return compressedBits == null ? 0 : compressedBits.length();
    }
    
    public double getCompressionRatio() {
        if (originalText == null || compressedBits == null) {
            return 0.0;
        }
        return (double) getCompressedBitCount() / getOriginalBits() * 100;
    }
    
    /**
     * Gets the frequency of each character (for display)
     */
    public Map<Character, Integer> getCharacterFrequencies() {
        return buildFrequencyMap(originalText);
    }
    
    /**
     * Gets a visual representation of the Huffman tree
     */
    public String getTreeVisualization() {
        if (root == null) {
            return "No tree built yet";
        }
        StringBuilder sb = new StringBuilder();
        visualizeTree(root, "", true, sb);
        return sb.toString();
    }
    
    private void visualizeTree(HuffmanNode node, String prefix, boolean isTail, StringBuilder sb) {
        if (node == null) {
            return;
        }
        
        sb.append(prefix).append(isTail ? "└── " : "├── ");
        if (node.isLeaf()) {
            char displayChar = node.character;
            if (displayChar == ' ') displayChar = '␣';
            if (displayChar == '\n') displayChar = '↵';
            sb.append("'").append(displayChar).append("': ").append(node.frequency);
        } else {
            sb.append("(").append(node.frequency).append(")");
        }
        sb.append("\n");
        
        if (!node.isLeaf()) {
            visualizeTree(node.left, prefix + (isTail ? "    " : "│   "), false, sb);
            visualizeTree(node.right, prefix + (isTail ? "    " : "│   "), true, sb);
        }
    }
}
