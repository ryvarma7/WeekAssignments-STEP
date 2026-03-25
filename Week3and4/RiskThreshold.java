public class RiskThreshold {
    static int linear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == target) return i;
        return -1;
    }

    static int floor(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= target) {
                res = arr[m];
                l = m + 1;
            } else r = m - 1;
        }
        return res;
    }

    static int ceil(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                res = arr[m];
                r = m - 1;
            } else l = m + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};
        int lin = linear(arr, 30);
        int f = floor(arr, 30);
        int c = ceil(arr, 30);
    }
}