/*
Quiz: Implement a Set
Set - a list of things that does not contain dupes
if a dupe is added, don't add it to the data structure
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

        if (current != null) {
            distinct = false;
            System.out.println("I'm not going to add this node twice, yo...")
        } 
        if (distinct) {
            Node oldfirst = first;
            first = new Node(oldfirst, item);
            size++;
        }

    }
/*
add Runtime:
		O(n)
*/


}