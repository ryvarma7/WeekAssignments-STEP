import java.util.*;

public class PlagiarismDetector{
    HashMap<String,Set<String>> map=new HashMap<>();
    int n=5;

    List<String> grams(String text){
        String[] w=text.split(" ");
        List<String> g=new ArrayList<>();
        for(int i=0;i<=w.length-n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++) sb.append(w[i+j]).append(" ");
            g.add(sb.toString().trim());
        }
        return g;
    }

    void addDoc(String id,String text){
        for(String g:grams(text)){
            map.putIfAbsent(g,new HashSet<>());
            map.get(g).add(id);
        }
    }

    int compare(String text){
        int count=0;
        for(String g:grams(text)) if(map.containsKey(g)) count++;
        return count;
    }
}