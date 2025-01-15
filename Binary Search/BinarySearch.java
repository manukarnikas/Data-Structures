import data.NumberGenerator;

import java.util.Scanner;

class Search{
    private int[] list;

    Search(int[] list){
        this.list = list;
    }

    public int find(int startIndex, int endIndex,int num){
        if(startIndex > endIndex){
            return -1;
        }
        
        int mid = startIndex + (endIndex - startIndex) / 2;

        if(this.list[mid]==num){
            return mid;
        }else if(num < this.list[mid]){
            return find(startIndex,mid-1,num);
        }else {
            return find(mid+1,endIndex,num);
        }
    }
}

class BinarySearch{
    public static void main(String args[]){
        int[] list =  NumberGenerator.getSortedNumbers();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        scanner.close();

        long startTime = System.currentTimeMillis();

        Search binarySearch = new Search(list);
        int index = binarySearch.find(0,list.length-1, number);
        if(index<0){
            System.out.println("\n"+number+ "Not Found");
        }else{
            System.out.println("\nFound "+number+" at index "+ index);
        }   

        long endTime = System.currentTimeMillis();  
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}