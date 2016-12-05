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
		this.size++;
		for (int i = 0; i < word.length()-1; i++){
			char curChar = word.charAt(i);
			if (doesntContain(curChar)){
				uniqueSize++;
				Node newChile = new Node(curChar);
				int j = pointer.children.length;
				Node[] newChiles = new Node[j+1];
				for (int m = 0; m < j; m++){
					newChiles[m] = pointer.children[m];
				}
				newChiles[j] = newChile;
				pointer.children = newChiles; //rip michael jackson
			}
			pointer = pointer.pointsTo;
		}
		throw new UnsupportedOperationException();
	}

	

	public boolean doesntContain(char a){
		for (int j = 0; j < this.pointer.children.length; j++) {
				if (this.pointer.children[j].c == a) {
					this.pointer.children[j].dupeNumber++;
					return false;
				}
			}
		return true;
		//throw new UnsupportedOperationException();
	}

	public int size(){
		throw new UnsupportedOperationException();
	}

	public int uniqueSize(){
		throw new UnsupportedOperationException();
	}

	public int getDupeNumber(){
		throw new UnsupportedOperationException();
	}

	class Node {
		char c;
		int dupeNumber;
		Node[] children;
		Node pointsTo;
		boolean endOfWord;

		public Node(){
			c = ' ';
			dupeNumber = 0;
			children = new Node[0];
			pointsTo = null;
			endOfWord = false;

		}

		public Node(char a){
			c = a;
			dupeNumber = 0;
			children = new Node[0];
			pointsTo = null;

		}

		public Node(Node n){//iterator node
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
                tree.addWord(item);
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