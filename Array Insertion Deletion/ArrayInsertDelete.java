
class ArrayUtil{
    static class Operate{
        public static int[] insertAtBeg(int[] arr,int val){
            int[] newarr = new int[arr.length+1];
            newarr[0] = val;
            for(int i=0,j=1;i<arr.length;i++,j++){
                newarr[j] = arr[i];
            }
            return newarr;
        }

        public static int[] insertInMiddle(int[] arr,int pos,int val){
            int[] newarr = new int[arr.length+1];
            for(int i=0;i<pos;i++){
                newarr[i] = arr[i];
            }
            newarr[pos] = val;
            for(int i=pos,j=pos+1; i<arr.length;i++,j++){
                newarr[j] = arr[i];
            }
            return newarr;
        }

        public static int[] insertAtEnd(int[] arr, int val){
            int[] newarr  = new int[arr.length+1];
            for(int i=0;i<arr.length;i++){
                newarr[i] = arr[i];
            }
            newarr[newarr.length-1] = val;
            return newarr; 
        }

        public static int[] deleteAtBeg(int[] arr){
            int[] newarr = new int[arr.length-1];
            for(int i=1,j=0;i<arr.length;i++,j++){
                newarr[j] = arr[i];
            }
            return newarr;
        }

        public static int[] deleteInMiddle(int[] arr,int pos){
            int[] newarr =  new int[arr.length-1];
            for(int i=0;i<pos;i++){
                newarr[i] = arr[i];
            }
            for(int i=pos+1,j=pos;i<arr.length;i++){
                newarr[j] = arr[i];
            }
            return newarr;
        }

        public static int[] deleteAtEnd(int[] arr){
            int[] newarr = new int[arr.length-1];
            for(int i=0;i<arr.length-1;i++){
                newarr[i] = arr[i];
            }
            return newarr;
        }

        public static void display(int arr[]){
            System.out.print("\n");
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
                System.out.print("  ");
            }
        }
    }    
}


class ArrayInsertDelete {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        int[] newarr;

        // pos is the index of array
        newarr = ArrayUtil.Operate.deleteAtEnd(arr);
        ArrayUtil.Operate.display(newarr);
    }
}
