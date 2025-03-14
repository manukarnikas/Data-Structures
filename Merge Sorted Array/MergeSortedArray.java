import java.util.Arrays;

class ArrayUtil {
    public void merge(int[] nums1, int nums2[]) {
        
        int total_length = nums1.length + nums2.length;
        int[] arr = new int[total_length];

        int i=0,j=0,k=0;
        while(i<nums1.length &&j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                i++;
            }else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        int[] remaining_arr;
        int selected_index = 0;
        if(i>=nums1.length){
            remaining_arr = nums2;
            selected_index = j;
        }else{
            remaining_arr = nums1;
            selected_index = i;
        }
        
        for(int index=selected_index;index<remaining_arr.length;index++ ){
            arr[k] = remaining_arr[index];
            k++;
        }  
        
        System.out.println(Arrays.toString(arr).replaceAll(" ", ""));
    }
}

class MergeSortedArray{
    public static void main(String args[]){
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] nums1 = {1,2,5,7,9,10};
        int[] nums2 = {2,3,4,6,8};
        arrayUtil.merge(nums1,nums2);
    }
}