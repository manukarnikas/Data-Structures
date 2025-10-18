import java.util.Arrays;

class SimpleBinarySearch{
    
    public static int binarySearch(int startIndex,int endIndex, int val,int[] arr){
        if(startIndex>endIndex){
            return -1;
        }
        
        int midIndex = startIndex + (endIndex-startIndex)/2;
        if(arr[midIndex]==val){
            return midIndex;
        }else if(val< arr[midIndex]){
           return binarySearch(startIndex,midIndex-1,val,arr);
        }else{
            return binarySearch(midIndex+1,endIndex,val,arr);
        }
    }
    
    public static void main(String args[]){
        int[] arr = {5,1,2,4,3};
        Arrays.sort(arr);  // {1,2,3,4,5}
        int val=5;
        int res = binarySearch(0,arr.length-1,val,arr);
        if(res>=0){
            System.out.println("Value found at index "+res);
        }else{
            System.out.println("Value not found!");
        }
    }
}