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

    public int uniqueSize(){
        return uniqueSize;
    }

    public static void toString(Node root){
        triePrinter(root);
        for(int i = 0; i < strings.length; i++){
            System.out.println( strings[i].t+" \t |"+strings[i].word);
       }
   }

    public static void triePrinter(Node root){
        wordbuilder[root.layer] = root.c;
        greenCarpet(root);
        if(root.wordCount != 0){
            //manually trim the array!!
            if((int) wordbuilder[root.layer+1] != 0){
                int y = root.layer+1;
                while((int) wordbuilder[y] != 0){
                    wordbuilder[y] = (char) 0;
                    y++;
                }
            }
            box2Add(root.wordCount);
        }
        
        for (int i = 0; i < root.children.length; i++){
            if(root.children[i] != null){
                Node newRoot = root.children[i];
                triePrinter(newRoot);
            }
        }
        
        return;
    }

    public static void greenCarpet(Node n){
        char[] temp = new char[chars.length+1];
        for(int i = 0; i < chars.length; i++){
            temp[i] = chars[i];
        }
        temp[chars.length] = n.c;
        chars = temp;
    }

    public static void box2Add(int count){
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
