package coreJava;

import java.util.Arrays;
import java.util.List;

enum Status
{
	Running, Started, Opened, Closed, InProgress, Deferred;
}
public class EnumDemo {

	public static void main(String[] args) {
		Status s = Status.Closed;
		System.out.println(s);
		
		Status s1 = Status.Opened;
		System.out.println(s1);
		
		Status[] s2 = Status.values();
		System.out.println(s2[1]);
		
		List<Status> statusList = Arrays.asList(Status.values());
		statusList.stream().forEach(s7->System.out.println(s7));
	}
}
