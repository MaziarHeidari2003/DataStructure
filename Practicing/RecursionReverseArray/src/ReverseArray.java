public class ReverseArray {
    public static void reverseArray(int[] data,int low,int high){
        if(low<high){
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
             reverseArray(data,low+1,high-1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        reverseArray(array,0,6);
        for(int i:array){
            System.out.println(i);

        }
    }
}
