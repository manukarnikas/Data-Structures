import data.NumberGenerator;

import java.util.Scanner;

class Search{
    private int[] list;

    Search(int[] list){
        this.list = list;
    }

    public int find(int num){
        for(int i=0;i<this.list.length;i++){
            if(this.list[i]==num){
               return i;
            }
        }
        return -1;
    }
}

class LinearSearch {
    public static void main(String args[]){
        int[] list =  NumberGenerator.getSortedNumbers();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        scanner.close();

        long startTime = System.currentTimeMillis();

        Search linearSeach = new Search(list);
        int index = linearSeach.find(number);
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
