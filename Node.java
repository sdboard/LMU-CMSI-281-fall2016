//Node.java

class Node {
    Node next;
    String word;
    int count;

    public Node(){
    	next = null;
    	item = null;
    	count = null;
    }

    public Node(Node next, String item, int count) {
        this.next = next;
        this.word = item;
        this.count = count;
    }
    
    public boolean hasNext(){
        return (this.next!=null);
    }

    public Node getNext(){
    	return this.next;
    }
}
