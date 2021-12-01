package aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1 {

	public static void main(String[] args) throws IOException {
		int[] h =Files.readAllLines(Paths.get("input1.txt")).stream().mapToInt(Integer::parseInt).toArray();
		int increases=0;
		for (int i = 1; i < h.length; i++) {
			if (h[i] > h[i-1]) {
				increases++;
			}
		}
		System.out.println("Part 1: "+increases);
		
		increases=0;
		for (int i = 3; i < h.length; i++) {
			int hprev = h[i-3] + h[i-2] + h[i-1];
			int hnext = h[i-2] + h[i-1] + h[i];
			if (hprev < hnext) {
				increases++;
			}
		}
		System.out.println("Part 2: "+increases);
		
		
	}

}
