//SDBTrie.java
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SDBTrie implements TrieInterface {
	Node pointer;
	Node root;
	int size;
	int uniqueSize;


	public SDBTrie(){
		root = new Node();
		pointer = new Node(root);
		int size = 0;
		int uniqueSize = 0;
	}
	
	public void addWord(String word){
		for (int i = 0; i < word.length()-1; i++){
			word.charAt(i)
		}
		if (isUnique){

		}
		throw UnsupportedOperationException;
	}

	public boolean isUnique()){
		throw UnsupportedOperationException;
	}

	public int size(){
		throw UnsupportedOperationException;
	}

	public int UniqueSize(){
		throw UnsupportedOperationException;
	}

	public int getDupeNumber(){
		throw UnsupportedOperationException;
	}

	class Node {
		char c;
		int dupeNumber;
		Node[] children;
		Node pointsTo;

		public Node(){
			c = '';
			dupeNumber = 0;
			children = new Node[0];
			pointsTo = null;

		}

		public Node(char a){
			c = a;

		}

		public Node(Node n){
			pointsTo = n;
		}
	}

	public static void main(String[] args) throws IOException {
        SDBTrie tree = new SDBTrie();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                tree.add(item);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        // Print bag size and distinct contents
        System.out.format("Total number of words: %d\n", tree.size());
        System.out.format("Unique number of words: %d\n", tree.uniqueSize());

        /*// Print distinct words in bag and their frequency
        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
        */
    }
}