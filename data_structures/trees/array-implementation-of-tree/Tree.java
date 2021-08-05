import java.util.Vector;

public class Tree {
    private Vector<Integer> arr;

    public Tree() {
        arr = new Vector<>(10);
    }

    public void add(int val) {
        int idx = 0;
        int valAtIdx;
        while (true) {
            // if empty early return
            if (arr.isEmpty()) {
                arr.setSize(1);
                arr.set(0, val);
                break;
            }

            valAtIdx = arr.get(idx);
            if (val < valAtIdx) {
                idx = 2 * idx + 1;
                // inc cap if low
                if (arr.size() <= idx)
                    arr.setSize(arr.size() * 2);

                if (arr.get(idx) == null) {
                    arr.set(idx, val);
                    break;
                } else
                    continue;
            } else if (val > valAtIdx) {
                idx = 2 * idx + 2;
                // inc cap if low
                if (arr.size() <= idx)
                    arr.setSize(arr.size() * 2);

                if (arr.get(idx) == null) {
                    arr.set(idx, val);
                    break;
                } else
                    continue;
            } else {
                break;
            }
        }
    }

    public boolean search(int val) {
        if (arr.get(0) == null) {
            return false;
        }

        int idx = 0;
        while (true) {
            if (arr.get(idx) == null)
                return false;

            int valAtIdx = arr.get(idx);
            if (valAtIdx == val)
                return true;
            else if (val < valAtIdx)
                idx = idx * 2 + 1;
            else
                idx = idx * 2 + 2;
        }
    }

    public String toString() {
        return arr.toString();
    }

    public static void test() {
        Tree t = new Tree();
        t.add(23);
        t.add(13);
        t.add(50);
        t.add(45);
        t.add(1);
        t.add(100);
        t.add(400);
        t.add(2000);

        System.out.println(t.search(400));
        System.out.println(t.toString());
    }

    public static void main(String... args) {
        test();
    }
}
