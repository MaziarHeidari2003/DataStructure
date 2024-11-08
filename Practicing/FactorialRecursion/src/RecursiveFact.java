public class RecursiveFact {
    public static int factorial(int n) throws  IllegalArgumentException {
        if(n<0){
            throw new IllegalArgumentException();
        }
        else if(n==0){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        int answer = factorial(5);
        System.out.println(answer);
    }
}
