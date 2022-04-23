package collection;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {

		double[] l = input.stream().mapToDouble(x -> Math.pow(((x * 2) + 3), 5)).toArray();

		List<Double> list = DoubleStream.of(l).boxed().collect(Collectors.toList());
		return list;
	}

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {

		return input.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + removeFirst(s)+ s.substring(0, 1).toUpperCase() + removeFirst(s))
                .collect(Collectors.toList());

	}

	/**
	 * Function for removing the first character of String
	 */
	public static String removeFirst(String str) {

		StringBuilder sb = new StringBuilder(str);

		sb.deleteCharAt(0);

		return sb.toString();
	}

}
