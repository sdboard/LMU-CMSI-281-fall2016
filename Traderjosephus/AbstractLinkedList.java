public abstract class AbstractLinkedList implements Collectible {
    Node first;
    Node last;
    int n;

    public AbstractLinkedList() {
      first = null;
      last = null;
      n = 0;
    }
    
    public AbstractLinkedList(String[] elements) {
        for (String s : elements) {
            if (s != null) {
                add(s);
            }
        }
    }

    public void add(String s) {
        if (first == null){
            Node newFirst = new Node(s);
            first = newFirst;
            last = first;
            last.next = first;
            n++;   
        } else {
            Node newLast = new Node(last, s);
            last = newLast;
            n++;
        }
    }


    class Node {
        Node next;
        String value;

        public Node(String value) {
            this.next = first;
            this.value = value;
        }
        public Node(Node last, String value) {
            last.next = this;
            this.next = first;
            this.value = value;
        }
    }

}
