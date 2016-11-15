public class CircularArrayList extends AbstractArrayList implements CircularCollectible {//implement this jazz

    public CircularArrayList() {
        super();//since were extending abstract array list, call super to get access abtract arraylists's constructor
    }

    public CircularArrayList(String[] elements) {
        super(elements);//calls the other constructor
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // public void add(String s) {
    //     this method is inherited from Abstract 
    // }
    
    public String first() {
      return elements[0];
    }

    public CircularIterator iterator() {
        return new CircularArrayListIterator();
    }

    class CircularArrayListIterator implements CircularIterator {//helper, inner class
        private int pointer;
        public CircularArrayListIterator() {//constructor needs implemented
            pointer = 0;
            String[] interArray = new String[arraySize];
        }
        
        public boolean hasNext() {
            return (elements[pointer+1] != null);
        }

        public String next() {
            return elements[pointer+1];
        }

    public void remove(int l){
        while (l < size-1){
            elements[l] = elements[(l+1)%size];
             l++;
        }
        elements[size] = null;
        size--;
    }

        public String removeKthElement(int k) {
            int i = 0;
            pointer--;
            String toRemove = null;
            if (oneElementLeft()){
                return elements[0];
            } else {
                while (i < k){
                    pointer = (pointer + 1)%size;
                    i++;
                }   
                toRemove = elements[pointer];
            }
            remove(pointer);
            return toRemove;
        }
           

        public boolean oneElementLeft() {
             return (elements[1] == null);
        }
    }

}
