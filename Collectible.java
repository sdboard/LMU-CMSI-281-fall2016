import java.util.Iterator;

public interface Collectible {

    boolean isEmpty();

    int size();

    void add(String item);
    
    Iterator iterator();

}
