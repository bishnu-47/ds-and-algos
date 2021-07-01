public class StringRev {
	public static String reverse(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		String newString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			newString += str.charAt(i);
		}

		return newString;
	}

	public static String reverse1(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char [] inputArray = input.toCharArray();
		int length = inputArray.length;

		for (int i = 0; i < length / 2; i++) {
			char temp = inputArray[i];
			inputArray[i] = inputArray[length - i - 1];
			inputArray[length - i - 1] = temp;

		}
		return new String(inputArray);
	}

	public static void main(String[] args) {
		String str = "Hello World";

		final long start= System.nanoTime();
		System.out.println(reverse(null));
		final long end = System.nanoTime();

		System.out.println("Time Elapsed: "+((end-start))+" nano sec"); // 1236977  54027395
	}
}