import java.util.*;

class LRU<K,V> extends LinkedHashMap<K,V>{
    int cap;
    LRU(int cap){
        super(cap,0.75f,true);
        this.cap=cap;
    }
    protected boolean removeEldestEntry(Map.Entry<K,V> e){
        return size()>cap;
    }
}

public class MultiLevelCache{
    LRU<String,String> L1=new LRU<>(10000);
    LRU<String,String> L2=new LRU<>(100000);

    String get(String id){
        if(L1.containsKey(id)) return L1.get(id);
        if(L2.containsKey(id)){
            String v=L2.get(id);
            L1.put(id,v);
            return v;
        }
        String v="VIDEO_DATA_"+id;
        L2.put(id,v);
        return v;
    }
}