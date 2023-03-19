package DailyChallenges;

/* 211. Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.

*/

public class designAddAndSearchWordsDataStructure {
    class WordDictionary {

        class TrieNode {
            TrieNode[] nodes;
            boolean isWord;
            TrieNode() {
                nodes = new TrieNode[26];
            }
            
            public TrieNode get(char c) {
                return nodes[c - 'a'];
            }
    
            public void put(char c, TrieNode node) {
                nodes[c - 'a'] = node;
            }
        }
    
        TrieNode root;
        public WordDictionary() {
            root = new TrieNode();
        }
        
        public void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.get(c) == null) node.put(c, new TrieNode());
                node = node.get(c);
            }
            node.isWord = true;
        }
        
        public boolean search(String word) {
            return traverse(word, 0, root);
        }
    
        public boolean traverse(String word, int index, TrieNode node) {
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (TrieNode next : node.nodes) {
                        if (next != null && traverse(word, i + 1, next)) return true;
                    }
                    return false;
                } else {
                    if (node.get(c) == null) return false;
                    node = node.get(c);
                }
            }
            return node.isWord;
        }
    }
}
