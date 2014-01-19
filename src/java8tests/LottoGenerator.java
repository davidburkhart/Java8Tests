package java8tests;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class LottoGenerator {

	@Test
	public void generateLottoNumbers() {
		Supplier<int[]> numbers = () -> IntStream.generate(() -> new Random().nextInt(49) + 1).distinct().limit(6)
				.sorted().toArray();
		Stream.generate(numbers).limit(100).map(x -> Arrays.toString(x)).forEach(System.out::println);

		int[] coverage = new int[49];
		Stream.generate(numbers).limit(1000000)
				.forEach(x -> IntStream.of(x).forEach(number -> coverage[number - 1] = coverage[number - 1] + 1));
		System.out.println(Arrays.toString(coverage));
	}
}
