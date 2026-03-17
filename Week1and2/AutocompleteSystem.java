import java.util.*;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    HashMap<String, Integer> counts = new HashMap<>();
}

public class AutocompleteSystem {
    TrieNode root = new TrieNode();

    public void addQuery(String q) {
        TrieNode node = root;
        for(char c: q.toCharArray()) {
            node.children.putIfAbsent(c,new TrieNode());
            node = node.children.get(c);
            node.counts.put(q,node.counts.getOrDefault(q,0)+1);
        }
    }

    public List<String> search(String prefix) {
        TrieNode node=root;
        for(char c: prefix.toCharArray()){
            if(!node.children.containsKey(c)) return new ArrayList<>();
            node=node.children.get(c);
        }
        List<String> res=new ArrayList<>(node.counts.keySet());
        res.sort((a,b)->node.counts.get(b)-node.counts.get(a));
        return res.subList(0,Math.min(10,res.size()));
    }
}