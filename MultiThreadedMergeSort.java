import java.util.Arrays;

public class MultiThreadedMergeSort {

    public static void mergeSort(int[] arr, int s, int e){

        if(s >= e) return;

        int mid = (s+e)/2;

        Thread left = new Thread(new Runnable() {
            @Override
            public void run(){
                mergeSort(arr, s, mid);
            }
        });

        Thread right = new Thread(new Runnable() {
            @Override
            public void run(){
                mergeSort(arr, mid+1, e);
            }
        });

        // start the threads
        left.start();
        right.start();

        // make sure the threads have been completed before merging
        try{
            left.join();
            right.join();
        }
        catch(InterruptedException err){
            err.printStackTrace();
        }

        merge(arr, s, mid, e);
    }

    public static void merge(int [] arr, int s, int mid, int e){

        int n = mid - s + 1;
        int m = e - mid;
        int[] leftArray = new int[n];
        int[] rightArray = new int[m];

        System.arraycopy(arr, s, leftArray, 0, n);
        System.arraycopy(arr, mid + 1, rightArray, 0, m);
 
        int i=0, j=0, k=s;
        while(i < n && j < m){

            if(leftArray[i] < rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }
            else{
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < n) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < m) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {

        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}