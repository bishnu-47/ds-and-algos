import java.util.Hashtable;

public class FirstRecurringCharacter {
	private static int findFirstRecurringChar(int arr[]) {
		if(arr.length == 0) return 0;

		Hashtable<Integer, Boolean> hashTable = new Hashtable<>();
		for (int i = 0; i < arr.length; i++) {
			if (hashTable.containsKey(arr[i])) {
				return arr[i];
			}
			hashTable.put(arr[i], true);
		}

		return 0;
	}

	public static void main(String[] args) {
		int arr[] = {2, 5, 1, 2, 3, 5, 1, 2, 4};
		System.out.println(findFirstRecurringChar(arr));
	}
}