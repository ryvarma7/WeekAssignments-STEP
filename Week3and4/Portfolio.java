public class Portfolio {
    static void mergeSort(double[] arr, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(double[] arr, int l, int m, int r) {
        double[] temp = new double[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        for (i = l; i <= r; i++) arr[i] = temp[i - l];
    }

    static void quickSort(double[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    static int partition(double[] arr, int l, int r) {
        double pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] > pivot) {
                i++;
                double t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        double t = arr[i + 1]; arr[i + 1] = arr[r]; arr[r] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        double[] arr = {12, 8, 15};
        mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
    }
}