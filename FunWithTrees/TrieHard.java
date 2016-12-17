//TrieHard.java
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TrieHard implements TrieInterface {
	Node pointer;
	Node root;
	int size;
	int uniqueSize;
	int level;
	static char[] chars = new char[0];
	static char[] helper;
	static Box[] strings = new Box[0];
	static Node statictemp;
	
	static class Box{
		String word;
		int t;
		public Box(){
			word = "";
			t = 0;
		}
	}


	public TrieHard(){
		System.out.println("Makin a Trie");
		root = new Node();
		pointer = new Node(root);
		int size = 0;
		int uniqueSize = 0;
	}

	public void add(String word){
		String chars = clean(word);
		if (chars.length() > 0) {

			this.size++;
			Node traverser = this.root;
			level = 1;

			for (int i = 0; i < chars.length(); i++){
				char curChar = chars.charAt(i);
				int n = ((int) curChar) - 97;
				if (traverser.children[n] == null) {
					traverser.children[n] = new Node(curChar, level);
					traverser = traverser.children[n];
			    }else {
					traverser = traverser.children[n];
			    }
				level++;
				if (i == chars.length() - 1){
						traverser.wordCount++;
						uniqueSize++;
			   }
		   }
	   }
   }

	public String clean(String word){
		String normWord = "";
		for(int i = 0; i < word.length(); i++) {
			int n = (int) word.charAt(i);
			if ( (n > 64 && n < 91) || (n > 96 && n < 123 ) ) {
				normWord += Character.toLowerCase(word.charAt(i));
			}
		}
		return normWord;
	}


	public int size(){
		return size;
		//throw new UnsupportedOperationException();
	}

	public int uniqueSize(){
		return uniqueSize;
		//throw new UnsupportedOperationException();
	}


	public static void topTen(Node root){
		//Stack maxStack = new Stack();
		//maxStack.pu
		if (root != null){
			visit(root);
			for (int i = 0; i < root.children.length; i++){
				// if(root.children[i] != null) {
				// 	System.out.println("newChile");
				// }
				Node newRoot = root.children[i];
				topTen(newRoot);
			}
		}
		return;
	}

	public static void visit(Node n){
		System.out.format("\n< %s >", n.c);
		System.out.print(n.wordCount);
		System.out.print("    " + n.layer);
   }
	public static void toString(Node root){
		triePrinter(root);
		for(int i = 0; i < strings.length; i++){
			System.out.println(strings[i].word+" "+ strings[i].t);
	   }
   }
	public static void triePrinter(Node root){
		greenCarpet(root);
		if(root.wordCount != 0){
			boxAdd(root.wordCount);
			int f = (int) chars[0];
			helper = new char[0];
			statictemp = root.children[f];
			arrayHelp(statictemp,f,0);
		}
		
		for (int i = 0; i < root.children.length; i++){
			if(root.children[i] != null){
				Node newRoot = root.children[i];
				triePrinter(newRoot);
			}
		}
		
		return;
	}
	public static void arrayHelp(Node current, int asciLetter, int arrayspot){
		char[] temp = new char[helper.length+1];
		for(int i = 0; i < helper.length; i++){
			temp[i] = helper[i];
		}
		temp[helper.length] = chars[helper.length];
		
		for(int i = 0; i < 26; i++){
			//Node n
		}
		int k = asciLetter;
		Node next = current.children[asciLetter];
		for (int i = 0; i < chars.length; i++){
			helper[i] = current.c;
			//k++
			//int x = (int) chars[i+1]
			current = current.children[(int) chars[i+1]];
		}
		while(current.marked = true){
			k++;
			helper[k] = chars[k];
		}
	}

	public static void greenCarpet(Node n){
		char[] temp = new char[chars.length+1];
		for(int i = 0; i < chars.length; i++){
			temp[i] = chars[i];
		}
		temp[chars.length] = n.c;
		chars = temp;
	}

	public static void boxAdd(int count){
		Box object = new Box();
		String wort = "";
		for (int i = 0; i < chars.length; i++){
			wort += chars[i];
		}
		object.word = wort;
		object.t = count;
		Box[] temp = new Box[strings.length+1];
		for (int i = 0; i < strings.length; i++){
			temp[i] = strings[i];
		}
		 temp[strings.length] = object;
		 strings = temp;
	}
	
	/*
	class Stack {
		class StackNode{
			StackNode next;
			int value;
			public StackNode(StackNode next, int value){
				this.next = next;
				this.value = value;
			}
		}
		StackNode top;
		int max;
		public Stack() {
			top = null;
			n = 0;
		}
		public void push(int s) {
			StackNode newTop = new StackNode(top, s);
			top = newTop;
			n++;
		}
		public String pop() {
			StackNode oldTop = top;
			top = top.next;
			n--;
			return oldTop.value;
		}
		public String peek() {
			return top.value;
		}
	}
	*/

	class Node {
		char c;
		Node[] children;
		Node specialPointer;
		int wordCount;
		int layer;
		boolean marked;

		public Node(){
			System.out.println("Makin a Node");
			c = ' ';
			children = new Node[26];
			specialPointer = null;
			wordCount = 0;
			marked = false;
		}

		public Node(char a, int i){
			layer = i;
			c = a;
			children = new Node[26];
			specialPointer = null;
			wordCount = 0;
			marked = false;
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

		public Node(Node n){//iterator node
			System.out.println("Makin a pointer Node");
			specialPointer = n;
		}

	}

	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		//cd Desktop/Computer_stuff/cmsi281/FunWithTrees/
		System.out.println(String.format("And So It Begins"));
		TrieHard tree = new TrieHard();
		System.out.println("new scannder");
        Scanner s = null;
        try {
        	System.out.println("System in it");
            s = new Scanner(System.in);
            while (s.hasNext()) {
            	System.out.println("A word __ at ya");
                String item = s.next(); // Scanner splits input on whitespace, by default
                tree.add(item);
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
        //System.out.format("The top ten words used: %d\n", tree.topTen());
        //topTen(tree.root);
        System.out.println("\n");
        toString(tree.root);
        System.out.println("\n");
		System.out.println(System.currentTimeMillis() - t1);
        /*// Print distinct words in bag and their frequency
        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
        */
    }
}