import java.util.*;

class DNSEntry{
    String ip;
    long expiry;
    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

public class DNSCache{
    HashMap<String,DNSEntry> cache=new HashMap<>();
    int hits=0,miss=0;

    String resolve(String domain){
        DNSEntry e=cache.get(domain);
        if(e!=null && System.currentTimeMillis()<e.expiry){
            hits++;
            return e.ip;
        }
        miss++;
        String ip="1.1.1."+new Random().nextInt(200);
        cache.put(domain,new DNSEntry(ip,300000));
        return ip;
    }

    String stats(){
        int total=hits+miss;
        double rate=total==0?0:(hits*100.0/total);
        return "Hit Rate:"+rate;
    }
}