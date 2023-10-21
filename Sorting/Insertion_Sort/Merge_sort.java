public class Merge_sort {
    public static void main(String[] args) {
        int[] arr = {40 , 10 , 11, 1, 3, 5 , 90};
        int[] brr = merge_Sort(arr , 0 , arr.length-1);

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(brr));
    }

    static int[] merge_Sort(int[] arr , int s , int e){
        if(s == e){
            int[] new_array = new int[1];
            new_array[0] = arr[s];
            return new_array;
        }

        int mid = s + (e - s)/2;
        int[] left = merge_Sort(arr , s  ,mid);
        int[] right = merge_Sort(arr , mid+1 , e);

        return merge_two_sorted_array(left , right);
    }

    static int[] merge_two_sorted_array(int[] arr , int[] brr){
        int[] merged_array = new int[arr.length + brr.length];

        int i=0,j=0,k=0;
        while(i<arr.length  && j<brr.length){
            if(arr[i]<brr[j]){
                merged_array[k]=arr[i];
                i++;
            }else{
                merged_array[k]=brr[j];
                j++;
            }
            k++;

        }
        while(i<arr.length){
            merged_array[k]=arr[i];
            k++;
            i++;
        }
        while(j<brr.length){
            merged_array[k]=brr[j];
            k++;
            j++;
        }

        return merged_array;
    }
}
