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
		System.out.println("Makin a Trie");
		root = new Node();
		pointer = new Node(root);
		int size = 0;
		int uniqueSize = 0;
	}
	
	public void addTheWord(String word){
		String cWord = clean(word);
		this.size++;
		Node traverser = this.root;
		for (int i = 0; i < cWord.length(); i++){
			char curChar = Character.toLowerCase(cWord.charAt(i));
			if (traverser.doesntContain(curChar)) { 
				int n = getI(curChar);					
				traverser.children[n] = new Node(curChar);
				traverser = traverser.match(curChar);
				if (i == cWord.length() - 1){
					traverser.wordCount++;
					uniqueSize++;
				}
			} else {
				traverser = traverser.match(curChar); 
				if (i == cWord.length() - 1){
					traverser.wordCount++;
				}
			}
		}
	}

	public String clean(String word){
		String cW = "";
		for(int i = 0; i < word.length(); i++) {
			int n = (int) word.charAt(i);
			if( (n > 64 && n < 91) || (n > 96 && n < 123) ) {
				cW += word.charAt(i);
			}
		}
		return cW;
	}


	public int getI(char curChar){
		switch (curChar){
		case 'a': return 0;
		case 'b': return 1;
		case 'c': return 2;
		case 'd': return 3;
		case 'e': return 4;
		case 'f': return 5;
		case 'g': return 6;
		case 'h': return 7;
		case 'i': return 8;
		case 'j': return 9;
		case 'k': return 10;
		case 'l': return 11;
		case 'm': return 12;
		case 'n': return 13;
		case 'o': return 14;
		case 'p': return 15;
		case 'q': return 16;
		case 'r': return 17;
		case 's': return 18;
		case 't': return 19;
		case 'u': return 20;
		case 'v': return 21;
		case 'w': return 22;
		case 'x': return 23;
		case 'y': return 24;
		case 'z': return 25;
		default: return -1;}
	}


	public int size(){
		return size;
		//throw new UnsupportedOperationException();
	}

	public int uniqueSize(){
		return uniqueSize;
		//throw new UnsupportedOperationException();
	}


	class Node {
		char c;
		Node[] children;
		Node specialPointer;
		int wordCount;

		public Node(){
			System.out.println("Makin a Node");
			c = ' ';
			children = new Node[26];
			specialPointer = null;
			wordCount = 0;
		}

		public Node(char a){
			c = a;
			children = new Node[26];
			specialPointer = null;
			wordCount = 0;
		}

		public boolean doesntContain(char theChar){
			int i = 0;
			Node current;
			while(i < 26){
				current = this.children[i];
				if(current != null){
					if (current.c == theChar){
						return false;
					}
				}
				i++;
			}
			return true;
		}

		public Node match(char theChar){
			for(int i = 0; i < 26; i++){
				if(this.children[i] != null){
					if (this.children[i].c == theChar){
						return this.children[i];
					}
				}
			}
			return null;
		}


		public int getC(int i){
			switch (i){
			case 'a': return 0;
			case 'b': return 1;
			case 'c': return 2;
			case 'd': return 3;
			case 'e': return 4;
			case 'f': return 5;
			case 'g': return 6;
			case 'h': return 7;
			case 'i': return 8;
			case 'j': return 9;
			case 'k': return 10;
			case 'l': return 11;
			case 'm': return 12;
			case 'n': return 13;
			case 'o': return 14;
			case 'p': return 15;
			case 'q': return 16;
			case 'r': return 17;
			case 's': return 18;
			case 't': return 19;
			case 'u': return 20;
			case 'v': return 21;
			case 'w': return 22;
			case 'x': return 23;
			case 'y': return 24;
			case 'z': return 25;
			default: return -1;
			}
		}

		public Node(Node n){//iterator node
			System.out.println("Makin a pointer Node");
			specialPointer = n;
		}

	}

	public static void main(String[] args) throws IOException {
		//cd Desktop/Computer_stuff/cmsi281/FunWithTrees/
		System.out.println(String.format("And So It Begins"));
		SDBTrie tree = new SDBTrie();
		System.out.println("new scannder");
        Scanner s = null;
        try {
        	System.out.println("System in it");
            s = new Scanner(System.in);
            while (s.hasNext()) {
            	System.out.println("A word __ at ya");
                String item = s.next(); // Scanner splits input on whitespace, by default
                tree.addTheWord(item);
        	}
        } finally {
            if (s != null) {
                s.close();
            }
        }

        System.out.println("n__a we pm made it");
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