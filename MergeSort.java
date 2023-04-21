// Сортировка слиянием на Java:

public class MergeSort {
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, len - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int leftLen = left.length;
        int rightLen = right.length;

        while (i < leftLen && j < rightLen) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLen) {
            arr[k++] = left[i++];
        }
        while (j < rightLen) {
            arr[k++] = right[j++];
        }
    }
}