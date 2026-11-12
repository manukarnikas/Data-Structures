class Sort {

    private final int[] arr;

    Sort(int[] arr) {
        this.arr = arr;
    }

    public int[] qSort(int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return arr;
        }

        int i = startIndex;
        int j = endIndex;
        int pivot = arr[startIndex + (endIndex - startIndex) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (startIndex < j) {
            qSort(startIndex, j);
        }
        if (i < endIndex) {
            qSort(i, endIndex);
        }

        return arr;
    }
}

class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 2, 7, 9, 10, 8};

        Sort sort = new Sort(arr);
        sort.qSort(0, arr.length - 1);

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
