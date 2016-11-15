public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {

    public CircularLinkedList() {
        super();
    }

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return (first == null);
    }

    public int size() {
        return n;
    }

    // public void add(String s) {
    //     this method is inherited from Abstract 
    // }

     public String last() {
        return last.value;
    }
    public String lastnext() {
        return last.next.value;
    }
    public String first() {
        return first.value;
    }

    public CircularIterator iterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements CircularIterator {
        private int size;
        private Node current;
        private Node previous;
        public CircularLinkedListIterator() {
            current = first;
            previous = null;
        }

        public boolean hasNext() {
            return (current.next != null);
        }

        public String next() {
            return current.next.value;
        }

        public void remove() {
            if (n == 2){
                if (current == first) {
                    first = previous;
                    first.next = null;
                    n--;
                } else { //current == last
                    first.next = first;
                    last = null;;
                    n--;
                }
            } else {
                previous.next = current.next;
                first = previous.next;
                n--;
            }
        }

        public String removeKthElement(int k) {
           
            System.out.println("\n\n");
            current = first;
            previous = null;
            String toRemove = null;
            if (oneElementLeft()) {
                return first.value;
            } else {
                for (int i = 0; i < (k-1); i++) {
                    previous = current;
                    current = current.next;
                }
                Node show = first;
                int r3 = 0;

                System.out.println("\n\n");
                while (r3 < n){
                    if (show == current){
                        System.out.println("\t"+show.value);
                    } else {
                        System.out.println(show.value);
                    } 
                    show = show.next;
                    r3++;
                }
                remove();
            }
            return toRemove;
        }

        public boolean oneElementLeft() {
            return (n == 1);
        }
    }
}

