package aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Day2 {
	
	enum Dirs { forward, down, up}

	public static void part1(String[] args) throws IOException 
	{
		var commands = Files
			.readAllLines(Paths.get("input2.txt"))
			.stream()
			.map(l -> l.split(" +"))
			.map(t -> Map.entry(Dirs.valueOf(t[0]), Integer.parseInt(t[1])))
			.toList();

		int pos = 0;
		int depth = 0;
		for (Entry<Dirs, Integer> c : commands) {
			switch (c.getKey()) {
				case forward -> pos+=c.getValue();
				case down -> depth+=c.getValue();
				case up -> depth-=c.getValue();
			}
		}
		System.out.println(pos+" "+depth+" -> "+(pos*depth));
	}

	
	
	public static void part2(String[] args) throws IOException 
	{
		var commands = Files
			.readAllLines(Paths.get("input2.txt"))
			.stream()
			.map(l -> l.split(" +"))
			.map(t -> Map.entry(Dirs.valueOf(t[0]), Integer.parseInt(t[1])))
			.toList();

		int pos = 0;
		int depth = 0;
		int aim = 0;
		for (Entry<Dirs, Integer> c : commands) {
			switch (c.getKey()) {
				case forward -> { pos+=c.getValue(); depth += (aim*c.getValue()); } 
				case down -> aim+=c.getValue();
				case up -> aim-=c.getValue();
			}
		}
		System.out.println(pos+" "+depth+" -> "+(pos*depth));
	}

}
