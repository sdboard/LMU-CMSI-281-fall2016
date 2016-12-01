class Stack{
    //different!!
    class Node{
        String item;
        Node next;

        public Node(){
            item = null;
            next = null;
        }

        public Node(String word){
            item = word;
            next = null;
        }
    }
    private Node first;
    private int count;

    public Stack(){
        first = null;
        count = 0;
    }

    public void push(String item){
        Node newNode = new Node(item);
        newNode = first;
        first = newNode;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;

    }

    public String peek(){
        return first.item;
    }
}
