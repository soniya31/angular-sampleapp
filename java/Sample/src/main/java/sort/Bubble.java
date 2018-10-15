package sort;

public class Bubble {
    public static void main(String[] args) {
        int arr[]={34,67,78,12,45,34,9};

        for(int pass=0;pass<arr.length-1;pass++)
        {
            for(int j=0;j<arr.length-pass-1;j++)
            {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        Utility.printArray(arr);
    }
}
