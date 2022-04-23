package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
		
		int result = 1;
		if (i < 0) {
			return Option.none();
		}
		if (i > 0 && n == 0) {
			return Option.of(result);
		} else if (i == 0 && n >= 1) {
			return Option.of(0);
		} else {
			for (int j = 1; j <= n; j++) {
				result = result * i;
			}
			return Option.of(result);
		}
	}
}
