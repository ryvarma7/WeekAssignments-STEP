import java.util.*;

public class TwoSumTransactions{
    List<int[]> twoSum(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int c=target-arr[i];
            if(map.containsKey(c)) res.add(new int[]{map.get(c),i});
            map.put(arr[i],i);
        }
        return res;
    }
}