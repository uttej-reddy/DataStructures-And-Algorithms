package com.javaconcepts.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {
		
		// 1. Integer Stream
		IntStream
			.range(1, 10)
			.forEach(System.out::print);
		System.out.println();
		
		//2. Integer Stream with skip
		IntStream
		.range(1, 10)
		.skip(5)
		.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//3. Sum
		int sum = IntStream.range(1, 5).sum();
		System.out.println("SUM is : " +sum);
		
		//4. 
		String[] people = {"Zakir","Jamal","Zubiya", "Salman", "Abdul", "Irfan", "Shivi", "Sung"};
		Arrays.stream(people)
		.filter(x -> x.startsWith("S"))
		.sorted()
		.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//5. average of cubes 
		int[] nums = {1,2,3,4,5};
		
		Arrays.stream(nums)
				.map(x -> x * x * x ).average().ifPresent(System.out::println);
		
		//6 lower case
		List<String> list = Arrays.asList("geeks", "gfg", "g", "e", "e", "k", "s");
		List<String> answer = Arrays.stream(people)
			.map(String::toUpperCase).collect(Collectors.toList());
		
		System.out.println(answer.toString());
		
		//7 Access Map
		Map<Integer,String> map=new HashMap<>();
		 map.put(1,"Anil");
		 map.entrySet().stream().forEach(e -> System.out.println(e));
		 
		 Stream<String> streamOfArray = Stream.of("a", "b", "c"); 
		 Stream.empty();
		 
		 Map<Integer, Integer> map1 = new ConcurrentHashMap<>();
		 map1.put(1, 0);
		 map1.put(1, 0);
		 int value = map1.put(1, 2);
		 map1.put(1, value);
		 map1.putIfAbsent(1, 5);
		 map1.compute(1, (k, v) -> v++);
		 map1.compute(1, (k, v) -> ++v);
		 map1.entrySet().stream().filter(e -> e.getKey() == 1).forEach(System.out::println);
		 
		 
		
			
	}

}
