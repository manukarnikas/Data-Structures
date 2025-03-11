import java.util.Arrays;

class ArrayUtil {

    private int[] arr;

    public ArrayUtil(int[] arr){
        this.arr = arr;
    }

    public void rotateLeft(){
        int size = arr.length-1;
        int temp = arr[0];
        for(int i=0;i<size;i++){
            arr[i] = arr[i+1];
        }
        arr[size] = temp;
    }

    public void rotateLeft(int n){
        int size = arr.length-1;
        for(int i=0;i<n;i++){
            int temp = arr[0];
            for(int j=0;j<size;j++){
                arr[j] = arr[j+1];
            }
            arr[size] = temp;
        }
    }

    public void rotateRight(){
        int size = arr.length-1;
        int temp = arr[arr.length-1];
        for(int i=size;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    public void rotateRight(int n){
        int size = arr.length-1;
        for(int i=0;i<n;i++){
            int temp = arr[arr.length-1];
            for(int j=size;j>0;j--){
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
    }

    public void display(){
        System.out.print("\n");;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print("  ");
        }
    }
}

class ArrayRotation{
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};

        ArrayUtil arrayUtil = new ArrayUtil(arr);
        arrayUtil.display();
        arrayUtil.rotateLeft(2);
        arrayUtil.rotateRight(3);
        arrayUtil.display();
    }
}
