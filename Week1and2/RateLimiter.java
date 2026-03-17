import java.util.*;

class TokenBucket{
    int tokens;
    int max;
    long last;
    TokenBucket(int max){
        this.max=max;
        this.tokens=max;
        this.last=System.currentTimeMillis();
    }
}

public class RateLimiter{
    HashMap<String,TokenBucket> map=new HashMap<>();
    int limit=1000;

    synchronized boolean allow(String id){
        map.putIfAbsent(id,new TokenBucket(limit));
        TokenBucket b=map.get(id);
        long now=System.currentTimeMillis();
        if(now-b.last>3600000){
            b.tokens=limit;
            b.last=now;
        }
        if(b.tokens>0){
            b.tokens--;
            return true;
        }
        return false;
    }
}