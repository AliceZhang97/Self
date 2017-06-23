public class CountSubString {

	

	public int countSubString(String s1, String s2) {

		

		int count = 0;

		

		//break string into char[]

		char[] c1 = s1.toCharArray();

		char[] c2 = s2.toCharArray();

		

		//get the count of matching substrings

		for (int i = 0; i < c2.length - (c1.length - 1); i++) {

			if (c2[i] == c1[0]) {

				int p = i;

				int j = 1;

				while (j < c1.length) {

					if (c2[p + 1] == c1[j]) {

						j++;

						p++;

					} else {

						break;

					}

				}

				if (j >= c1.length) {

					count++;

				}

			}

		}

		return count;

	}



}
