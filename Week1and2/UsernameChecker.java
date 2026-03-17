import java.util.*;

public class UsernameChecker{
    HashMap<String,Integer> users=new HashMap<>();
    HashMap<String,Integer> attempts=new HashMap<>();
    int id=1;

    boolean checkAvailability(String username){
        attempts.put(username,attempts.getOrDefault(username,0)+1);
        return !users.containsKey(username);
    }

    void register(String username){
        users.put(username,id++);
    }

    List<String> suggestAlternatives(String username){
        List<String> list=new ArrayList<>();
        for(int i=1;i<=3;i++) list.add(username+i);
        list.add(username.replace("_","."));
        return list;
    }

    String getMostAttempted(){
        String res="";
        int max=0;
        for(String k:attempts.keySet()){
            if(attempts.get(k)>max){
                max=attempts.get(k);
                res=k;
            }
        }
        return res;
    }
}