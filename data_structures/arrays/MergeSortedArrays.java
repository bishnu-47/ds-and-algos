public class MergeSortedArrays {
	public static int[] merge(int[] arr1, int[] arr2) {
		int arr1Size = arr1.length;
		int arr2Size = arr2.length;
		int newArrSize = arr1Size + arr2Size;
		int[] sortedArr = new int[newArrSize];

		int ptr1 = 0, ptr2 = 0, i = 0;

		// iterate and pick which is smallest in arr1 and arr2 and put it inside newarr
		while (ptr1 < arr1Size && ptr2 < arr2Size) {
			if (arr1[ptr1] < arr2[ptr2]) {
				sortedArr[i++] = arr1[ptr1++];
			} else {
				sortedArr[i++] = arr2[ptr2++];
			}
		}

		// if part of array remains simply put it in new arrhtop
		while (ptr1 < arr1Size) {
			sortedArr[i++] = arr1[ptr1++];
		}

		while (ptr2 < arr2Size) {
			sortedArr[i++] = arr2[ptr2++];
		}

		return sortedArr;
	}

	public static void print(int[] arr) {
		if (arr.length == 0) {
			System.out.println("[]");
		} else {
			String str = "";
			for (int i = 0; i < arr.length; i++) {
				str += (i == arr.length - 1) ? arr[i] : arr[i] + ", ";
			}
			System.out.println("[" + str + "]");
		}
	}

	public static void main(String[] args) {
		int[] arr1 = {0, 3, 4, 31, 45, 50};
		int[] arr2 = {4, 6, 30, 68};

		int[] sortedArr = merge(arr1, arr2);
		print(sortedArr);
	}
}
