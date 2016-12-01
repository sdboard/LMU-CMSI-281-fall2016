//SDBTrie.java
public class SDBTrie{
	Node root;

	public SDBTrie(){
		root = null;
	}

	class Node {
		char c;
		Node[] children;

		public Node(){
			c = '';

		}

		public Node(char a){
			c = a;

		}
	}
}