package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveEmptyStrings {

	public static void main(String[] args) {
		String[] arr = {"ashwin", "", " ", null, "kumar"};
		List<String> list = Arrays.stream(arr).filter(Objects::nonNull).filter(s->!s.isBlank()).toList();
		System.out.println(list);
	}
}
