import java.util.*;

public class AccountSearch {
    static int linearFirst(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) if (arr[i].equals(target)) return i;
        return -1;
    }

    static int binarySearch(String[] arr, String target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m].equals(target)) return m;
            else if (arr[m].compareTo(target) < 0) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    static int count(String[] arr, String target) {
        int c = 0;
        for (String s : arr) if (s.equals(target)) c++;
        return c;
    }

    public static void main(String[] args) {
        String[] arr = {"accA", "accB", "accB", "accC"};
        Arrays.sort(arr);
        int first = linearFirst(arr, "accB");
        int idx = binarySearch(arr, "accB");
        int cnt = count(arr, "accB");
    }
}