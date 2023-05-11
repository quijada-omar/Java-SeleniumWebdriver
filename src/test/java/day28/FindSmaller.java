package day28;

import java.util.Arrays;

public class FindSmaller {
		public static void main(String[] args) {
			int a[] = {500,400,100,200,700};
			
			Arrays.sort(a);
				for (int v : a) {
					System.out.println(v);
				}
		}
}
