package com.javaconcepts.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		String s = "";
		int n = 2;
		System.out.println(solution(n, s));

	}

	public static int solution(int N, String S) {
		int result = 0;

		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		String[] seatArr = S.split(" ");

		Arrays.sort(seatArr);

		for (int row = 1; row <= N; row++) {

			List<List<Integer>> irow = new ArrayList<>(3);

			List<Integer> col1 = new ArrayList<>(3);
			Collections.fill(col1, -1);
			List<Integer> col2 = new ArrayList<>(4);
			col2.add(-1);
			col2.add(-1);
			col2.add(-1);
			col2.add(-1);
			List<Integer> col3 = new ArrayList<>(3);
			col3.add(-1);
			col3.add(-1);
			col3.add(-1);

			irow.add(col1);
			irow.add(col2);
			irow.add(col3);

			map.put(row, irow);
			if (S.trim().length() > 0) {
				for (int j = 0; j < seatArr.length; j++) {
					String code = seatArr[j];
					String subC = code.substring(1);
					int currRow = Integer.parseInt(code.substring(0, 1));
					if (currRow == row) {
						if ("A".equalsIgnoreCase(subC)) 
							map.get(row).get(0).set(0, 1);
						else if("B".equalsIgnoreCase(subC))
							map.get(row).get(0).set(1, 1);
						else if("C".equalsIgnoreCase(subC))
							map.get(row).get(0).set(2, 1);
						else if("D".equalsIgnoreCase(subC))
							map.get(row).get(1).set(0, 1);
						else if("E".equalsIgnoreCase(subC))
							map.get(row).get(1).set(1, 1);
						else if("F".equalsIgnoreCase(subC))
							map.get(row).get(1).set(2, 1);
						else if("G".equalsIgnoreCase(subC))
							map.get(row).get(1).set(3, 1);
						else if("H".equalsIgnoreCase(subC))
							map.get(row).get(2).set(0, 1);
						else if("J".equalsIgnoreCase(subC))
							map.get(row).get(2).set(1, 1);
						else 
							map.get(row).get(2).set(2, 1);
						
					}
				}
			}
		}
		for (int row = 1; row <= N; row++) {
			if (!map.get(row).get(0).contains(1)) {
				// System.out.println(row + “C1”);
				result++;
			}
			if (!map.get(row).get(1).contains(1)) {
				// System.out.println(row + “C2");
				result++;
			} else if (map.get(row).get(1).get(1) == -1 && map.get(row).get(1).get(2) == -1) { // middle seats should not be occupied for 3 consecutive allotments
				if (map.get(row).get(1).get(0) == -1 || map.get(row).get(1).get(3) == -1) {  // once that is satisfied either of the end seats check to satisfy the continuous allocations
					// System.out.println(row + “c2”);
					result++;
				}
			}
			if (!map.get(row).get(2).contains(1)) {
				// System.out.println(row + “C3");
				result++;
			}
		}
		return result;
	}

}
