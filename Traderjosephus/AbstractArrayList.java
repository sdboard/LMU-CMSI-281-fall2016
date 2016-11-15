public abstract class AbstractArrayList implements Collectible {
    final int DEFAULT_MAX_SIZE = 100;

    String [] elements;
    int size;
    int arraySize;

    protected AbstractArrayList() {
        elements = new String[DEFAULT_MAX_SIZE];
        arraySize = DEFAULT_MAX_SIZE;
        size = 0;
    }

    protected AbstractArrayList(String[] newelements) {
        this.elements = new String[DEFAULT_MAX_SIZE];
        arraySize = DEFAULT_MAX_SIZE;
        size = 0;
        
        for (String s : newelements) {
            if (s != null){
                add(s);
            } 
        }
    }

    public void add(String s){
        elements[size] = s;
        size++;
        if(size == elements.length){
            String[] temp = new String[2*size];
            for(int i = 0; i < size; i++){
                temp[i] = elements[i];
            }
            elements = temp;
        }
    }
}
