package coreJava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamInterview {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		Map<Boolean, List<Integer>> partition  =list.stream().collect(Collectors.partitioningBy(s->s%2==0));
		
		List<Integer> evenlist = partition.get(true);
		evenlist.stream().forEach(s->System.out.println(s));
		
		List<Integer> addlist = partition.get(false);
		addlist.stream().forEach(s->System.out.println(s));
		
		Integer num = list.stream().sorted().max(Integer::compare).get();
		System.out.println(num);
	}

}
