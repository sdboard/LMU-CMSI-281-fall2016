//TrieInterface.java
public interface TrieInterface{
	//list of methods that my trie will implement
	public void addWord(String word);
	//adds a word to the prefix tree

	public int size();
	// number of words added to the Trie

	public int UniqueSize();
	// number of unique words

	public int getDupeNumber();
	// number of times word has appeared



}