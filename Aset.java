/*
Quiz: Implement a Set
Set - a list of things that does not contain dupes
if a dupe is added, don't add it to the data structure

1. Write it out/code it up
	- java
2. Analyze runtime of add(String s) and remove(string s)
	- QueueSet
	- ArraySet
	- LinkedListSet
*/




public class Aset{
	private Node first;
	private int size;

	public Aset(){
		first = null;
		size = 0;
	}

	class Node {
	    Node next;
	    String item;
	    
	    public Node(Node next, String item) {
	        this.next = next;
	        this.item = item;
	    }
    }

    public void add(String item) {
        boolean distinct = true;
        Node current = first;
        Node previous = null;
        while (current != null && !current.item.equals(item)){
            previous = current;
            current = current.next;
        }

        if (current != null) {//not found
            distinct = false;
        } 
        if (distinct) {
            Node oldfirst = first;
            first = new Node(oldfirst, item);
            size++;
        }
    }
/*
Runtime:
	O(n)
*/


}