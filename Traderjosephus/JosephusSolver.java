import java.util.Iterator;

public class JosephusSolver {

  public static void main(String[] args) {
    int count = 0;
    int k1 = 10;
    String [] test1 = { "Fido", "Delilah", "Rugrat", "Joshua", "Sid", 
                        "Bow-wow", "Bogo", "Pogo", "Mimi", "Chloe" };
    String [] test2 = { "Fido", "Delilah", "Rugrat", "Joshua", "Sid", 
                        "Bow-wow", "Bogo", "Pogo", "Mimi", "Chloe" , "Joey" };
    String [] test3 = { "Fido", "Delilah", "Rugrat", "Joshua", "Sid", "Broheim",
                        "Bow-wow", "Bogo", "Pogo", "Mimi", "Chloe" , "Joey" };
    
    CircularLinkedList linkedList = new CircularLinkedList(test3);
    for (CircularIterator i = linkedList.iterator(); !i.oneElementLeft(); ) {
      
      i.removeKthElement(k1);



      if (count >= 11) break;
    }
    System.out.println("\n\nhey " + linkedList.first() + ", here's a treat :D\n\n"); 
    assert linkedList.first() == "Sid";

    
    CircularArrayList arrayList = new CircularArrayList(test3);
     
    for (CircularIterator i = arrayList.iterator(); !i.oneElementLeft(); ) {
      count++;
      i.removeKthElement(k1);
      if (count >= 11) break;
    }

    System.out.println("\n\nhey " + arrayList.first() + ", here's a treat :D\n\n"); 
    assert arrayList.first() == "Sid";

  }
}

    