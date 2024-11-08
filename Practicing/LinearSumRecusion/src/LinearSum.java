public class LinearSum {
    public static int linearSum(int[] A, int n){
        if(n==0){
            return 0;
        }
        else {
            return linearSum(A,n-1) + A[n-1];
        }

    }
}
