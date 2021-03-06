//TrieHard.java
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TrieHard implements TrieInterface {
    Node pointer;
    Node root;
    int size;
    int uniqueSize;
    int level;
    static char[] chars = new char[0];
    static Box[] strings = new Box[0];
    static char[] wordbuilder = new char[1000];
    
    static class Box{
        String word;
        int t;
        public Box(){
            word = "";
            t = 0;
        }
    }


    public TrieHard(){
        root = new Node();
        pointer = new Node(root);
        int size = 0;
        int uniqueSize = 0;
    }

    public void add(String word){
        String chars = clean(word);
        if (chars.length() > 0) {
        
            this.size++;
            Node traverser = this.root;
            level = 1;

            for (int i = 0; i < chars.length(); i++){
                char curChar = chars.charAt(i);
                int n = ((int) curChar) - 97;
                if (traverser.children[n] == null) {
                    traverser.children[n] = new Node(curChar, level);
                    traverser = traverser.children[n];
                }else {
                    traverser = traverser.children[n];
                    uniqueSize--;
                }
                level++;
                if (i == chars.length() - 1){
                        traverser.wordCount++;
                        
               }
           }
       }
   }

    public String clean(String word){
        String normWord = "";
        for(int i = 0; i < word.length(); i++) {
            int n = (int) word.charAt(i);
            if ( (n > 64 && n < 91) || (n > 96 && n < 123 ) ) {
                normWord += Character.toLowerCase(word.charAt(i));
            }
        }
        return normWord;
    }


    public int size(){
        return size;
    }

    public static void toString(Node root){
        triePrinter(root);
        sort(strings);
        int i = strings.length-1;
        int f = 0;
        while (f < 20){
            if (strings[i].word.equals(" the")){
                i--;
            }else if (strings[i].word.equals(" and")){
                i--;
            }else if (strings[i].word.equals(" to")){
                i--;
            }else if (strings[i].word.equals(" of")){
                i--;
            }else if (strings[i].word.equals(" i")){
                i--;
            }else if (strings[i].word.equals(" you")){
                i--;
            }else if (strings[i].word.equals(" a")){
                i--;
            }else if (strings[i].word.equals(" in")){
                i--;
            }else if (strings[i].word.equals(" it")){
                i--;
            }else if (strings[i].word.equals(" for")){
                i--;
            }else if (strings[i].word.equals(" is")){
                i--;
            }else if (strings[i].word.equals(" are")){
                i--;
            }else if (strings[i].word.equals(" that")){
                i--;
            }else if (strings[i].word.equals(" from")){
                i--;
            }else if (strings[i].word.equals(" their")){
                i--;
            }else if (strings[i].word.equals(" these")){
                i--;
            }else if (strings[i].word.equals(" this")){
                i--;
            }else if (strings[i].word.equals(" with")){
                i--;
            }else if (strings[i].word.equals(" not")){
                i--;
            }else if (strings[i].word.equals(" if")){
                i--;
            }else if (strings[i].word.equals(" should")){
                i--;
            }else if (strings[i].word.equals(" as")){
                i--;
            }else if (strings[i].word.equals(" do")){
                i--;
            }else if (strings[i].word.equals(" about")){
                i--;
            }else if (strings[i].word.equals(" say")){
                i--;
            }else if (strings[i].word.equals(" but")){
                i--;
            }else if (strings[i].word.equals(" they")){
                i--;
            }else if (strings[i].word.equals(" has")){
                i--;
            }else if (strings[i].word.equals(" be")){
                i--;
            }else if (strings[i].word.equals(" on")){
                i--;
            }else if (strings[i].word.equals(" or")){
                i--;
            }else if (strings[i].word.equals(" by")){
                i--;
            }else if (strings[i].word.equals(" there")){
                i--;
            }else {
            System.out.println( strings[i].t+" \t |"+strings[i].word);
            i--;
            f++;
            }
        }
   }

   public static void sort(Box[] objects){
        quickSort(objects, 0, (objects.length-1));
   }
   public static void quickSort(Box[] objects, int low, int high){
        if (low < high){
            int p = partition(objects, low, high);
            quickSort(objects, low, p-1);
            quickSort(objects, p+1, high);
        }
   }
   public static int partition(Box[] array, int low, int high){
        int pivot = array[high].t;
        int i = low;
        int j = low;
        Box temp;
        while (j < high) {
            if (array[j].t <= pivot) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
            j++;
        }
        temp = array[high];
        array[high] = array[i];
        array[i] = temp;
        return i;
   }


    public static void triePrinter(Node root){
        wordbuilder[root.layer] = root.c;
        if(root.wordCount != 0){
            //manually trim the array!!
            if((int) wordbuilder[root.layer+1] != 0){
                int y = root.layer+1;
                while((int) wordbuilder[y] != 0){
                    wordbuilder[y] = (char) 0;
                    y++;
                }
            }
            add2Box(root.wordCount);
        }
        
        for (int i = 0; i < root.children.length; i++){
            if(root.children[i] != null){
                Node newRoot = root.children[i];
                triePrinter(newRoot);
            }
        }
        
        return;
    }

    public static void add2Box(int count){
        Box object = new Box();
        String wort = "";
        int m = 0;
        int q = (int) wordbuilder[m];
        while(q != 0){
            wort += wordbuilder[m];
            m++;
            q = (int) wordbuilder[m];
        }
        object.word = wort;
        object.t = count;
        Box[] temp = new Box[strings.length+1];
        for (int i = 0; i < strings.length; i++){
            temp[i] = strings[i];
        }
         temp[strings.length] = object;
         strings = temp;
    }
    
    class Node {
        char c;
        Node[] children;
        Node specialPointer;
        int wordCount;
        int layer;
        boolean marked;

        public Node(){
            c = ' ';
            children = new Node[26];
            specialPointer = null;
            wordCount = 0;
            marked = false;
        }

        public Node(char a, int i){
            layer = i;
            c = a;
            children = new Node[26];
            specialPointer = null;
            wordCount = 0;
            marked = false;
        }

        public boolean doesntContain(char theChar){
            int i = 0;
            Node current;
            while(i < 26){
                current = this.children[i];
                if(current != null){
                    if (current.c == theChar){
                        return false;
                    }
                }
                i++;
            }
            return true;
        }

        public Node(Node n){//iterator node
            specialPointer = n;
        }

    }

    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        TrieHard tree = new TrieHard();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                tree.add(item);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        // Print bag size and distinct contents
        System.out.format("\nTotal number of words: %d\n\n", tree.size());
        System.out.println("Frequency|Word");
        // Print distinct words in bag and their frequency
        toString(tree.root);
        System.out.println("\n");
        System.out.println("Runtime: " + (System.currentTimeMillis() - t1) + "ms");
    }
}
