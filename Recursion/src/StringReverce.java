    public class StringReverce {

        public static String reverseArray(String str,int low,int high){
            char[] array = str.toCharArray();

            if(low<high){
                char temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                return reverseArray(new String(array), low + 1, high - 1);
                }
            return new String(array);

        }

        public static void main(String[] args) {

            String original = "hello";
            String reversed = reverseArray(original, 0, original.length() - 1);
            System.out.println("Original: " + original);
            System.out.println("Reversed: " + reversed);
            if(reversed==original){
                System.out.print("These are the same!");
            }
            else{
                System.out.println("These are not the same!");
            }

        }
    }
