package sort;

/**
 * @ClassName Sort
 * @Description
 * @Author: lijiao73
 * @Date: 2019/8/16 14:44
 * @Version 1.0
 */
public class Sort {
    public static void main(String[] args) {

    }

    //交换一个数组中的两个元素
    private static void swap(int[] org, int i, int j) {
        int temp = org[i];
        org[i] = org[j];
        org[j] = temp;
    }

    //冒泡排序
    private static void maopao(int[] org) {
        if (org.length <= 1) {
            return;
        }
        for (int i = 0; i < org.length - 1; i++) {
            for (int j = 0; j < org.length - 1 - i; j++) {
                if (org[j] > org[j + 1]) {
                    swap(org, j, j + 1);
                }
            }
        }
    }

    //直接插入排序
    private static void charu(int[] org) {
        if (org.length <= 1) {
            return;
        }
        int index = 0;
        int current = 0;
        for (int i = 1; i < org.length; i++) {
            index = i - 1;
            current = org[i];
            while (index >= 0 && org[index] > current) {
                org[index + 1] = org[index];
                index--;
            }
            org[index + 1] = current;

        }
    }

    //简单选择排序
    private static void xuanze(int[] org) {
        if (org.length <= 1) {
            return;
        }
        int minIndex = 0;
        for (int i = 0; i < org.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < org.length; j++) {
                if (org[j] < org[minIndex]) {
                    minIndex = j;
                }
            }
            swap(org, minIndex, i);

        }
    }

    //快速排序
    private static void quickSort(int[] org, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = partion(org, i, j);
        quickSort(org, i, mid - 1);
        quickSort(org, mid + 1, j);
    }

    private static int partion(int[] org, int l, int r) {
        int j = l;
        int value = org[l];
        for (int i = l + 1; i <= r; i++) {
            if (org[i] < value) {
                swap(org, i, j + 1);
                j++;
            }
        }
        swap(org, j, l);
        return j;
    }

    //希尔排序
    private static void xier(int[] org) {
        if (org.length <= 1) {
            return;
        }
        int index = 0;
        int current = 0;
        int length = org.length;
        int h = 0;
        while (h <= length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < org.length; i++) {
                index = i - h;
                current = org[i];
                while (index >= 0 && org[index] > current) {
                    org[index + h] = org[index];
                    index = index - h;
                }
                org[index + h] = current;

            }
            h = (h - 1) / 3;
        }
    }

    //堆排序
    private static void HeapSort(int[] org) {
        int len = org.length;
        if (len < 1) {
            return;
        }
        BuildHeap(org);//调整为大顶堆
        while (len > 0) {
            swap(org, 0, len - 1);//第一个元素和最后一个元素交换
            len--;//类似于剔除最后一个元素
            AdjustHeap(org, 0, len);
        }
    }

    private static void BuildHeap(int[] org) {
        int len = org.length;
        for (int i = len / 2; i >= 0; i--) {
            AdjustHeap(org, i, len);
        }
    }

    private static void AdjustHeap(int[] org, int i, int len) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int maxIndex = i;
        if (left < len && org[left] > org[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && org[right] > org[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap(org, i, maxIndex);
            AdjustHeap(org, maxIndex, len);
        }
    }
    
  //归并
    private static void MergeSort(int org[], int left, int right) {
        if (right - left <= 4) {
            charu(org);
            return;
        }
        int mid = (right + left) / 2;
        MergeSort(org, left, mid);
        MergeSort(org, mid + 1, right);
        if (org[mid] > org[mid + 1]) {
            Merge(org, left, mid, right);
        }
    }

    private static void Merge(int org[], int left, int mid, int right) {
        int array[] = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            array[i - left] = org[i - left];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid + 1) {
                array[k] = org[j - left];
                j++;
            } else if (j > right) {
                array[k] = org[i - left];
                i++;
            } else if (org[mid] > org[mid + 1]) {
                array[k] = org[i - left];
                i++;
            } else {
                array[k] = org[j - left];
                j++;
            }
        }
    }


}
