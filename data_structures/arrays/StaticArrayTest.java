public class StaticArrayTest {
    public static void main(String[] args) {
        StaticArray arr = new StaticArray(5);
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);

        // arr.pop();

        arr.removeAt(2);
        System.out.println(arr.toString());
    }
}
