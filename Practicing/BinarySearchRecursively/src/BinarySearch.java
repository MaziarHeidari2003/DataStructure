public class BinarySearch {
    public static boolean binarySearch(int[] data, int target, int low, int high){
        if(low>high){
            return false;
        }
        int mid = (high+low)/2;
        if(target==mid){
            return true;
        }
        else if(target>mid){
           return  binarySearch(data,target,mid+1,high);
        }
        else{
           return binarySearch(data,target,low,mid-1);
        }

    }
}
