public class CommonItems{
    private static boolean hasCommonItems(char[] arr1, char[] arr2){
        for(char c1: arr1){
            for(char c2: arr2){
                if(c1 == c2){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] arr1 = {'a','b','c','x'};
        char[] arr2 = {'x','y','z'};
        System.out.println(hasCommonItems(arr1, arr2));
    }
}
