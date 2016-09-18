//Bag.java
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Bag implements Collectible {
    private Node first;
    private int n; // number of nodes
    private int total; // total number of words in this bag


    // Implement a constructor
    public Bag() {
        first = null;
        n = 0;
        total = 0;
    }

    public boolean isUnique(String item){
        Node current = first;
        Node previous = null;
        while (current != null && !current.word.equalsIgnoreCase(item)){
            previous = current;
            current = current.next;

            if (current == null) //not found{
                return true;
            } else {
                if (current == head) {

                }
            }
        }
    }

    // Implement Collectible interface methods here
    public boolean isEmpty(){
        throw new UnsupportedOperationException();
    }

    public int size(){
        throw new UnsupportedOperationException();
    }

    public void add(String item){
        
        if (isUnique()) {
            Node newNode = new Node(first, item, 1);
            //newNode.setNext(first);
            first = newNode;
            n++;
            total++;
        } else {
            //iterate through to find the repeat and increment a counter on the repeated word
        }

    }

    //public Iterator iterator();
    public boolean isUnique() {

    }

    public int uniqueSize() {
      throw new UnsupportedOperationException();
    }

    public Obliterator iterator() {
        return new BagIterator(first);  
    }

    class BagIterator implements Obliterator {
        private Node current;

        public BagIterator(Node first) {
            current = first;
        }

        public boolean hasNext() { 
            return current != null;  
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = current.next; 
            return node;
        }
    }


    public static void main(String[] args) throws IOException {
        Bag bag = new Bag();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                bag.add(item);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        // Print bag size and distinct contents
        System.out.format("Total number of words: %d\n", bag.size());
        System.out.format("Unique number of words: %d\n", bag.uniqueSize());

        // Print distinct words in bag and their frequency
        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
    }

}
