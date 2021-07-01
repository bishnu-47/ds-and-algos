public class MergeUnsortedArrays {

	public static int[] mergeSort(int[] arr1, int[] arr2) {
		int[] mergedArr = merge(arr1, arr2);

		return sort(mergedArr);
	}

	private static int[] sort(int[] arr) {
		for(int i=0; i<arr.length; i++){
			for(int j = i; j<arr.length;j++){
				if(arr[j] < arr[i]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp; 
				}
			}
		}

		return arr;
	}

	private static int[] merge(int[] arr1, int[] arr2) {
		int size = arr1.length + arr2.length;
		int[] mergedArr = new int[size];

		int i = 0, j = 0;
		while (i < size) {
			if (i < arr1.length) mergedArr[i] = arr1[i];
			else {
				mergedArr[i] = arr1[j];
				j++;
			}
			i++;
		}
		return mergedArr;
	}

	public static String print(int[] arr){
        if(arr.length == 0) return "[]";
        String str = "[";
        for(int i=0; i<arr.length;i++){
            str+= (i == arr.length-1) ? arr[i] : arr[i]+", ";
        }
        str+="]";
        return str;
    }

	public static void main(String[] args) {
		int[] arr1 = {};
		int[] arr2 = {};

		int[] sortedArr = mergeSort(arr1, arr2);
		System.out.println(print(sortedArr));
	}
}