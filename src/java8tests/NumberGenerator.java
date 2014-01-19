package java8tests;

import static java8tests.NumberGenerator.IntIncrementor.incrementFrom;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

import org.junit.Test;

public class NumberGenerator {

	static class IntIncrementor implements IntSupplier {

		static IntIncrementor incrementFrom(int start) {
			return new IntIncrementor(start);
		}

		private int last;

		public IntIncrementor(int start) {
			this.last = start;
		}

		@Override
		public int getAsInt() {
			return last++;
		}
	}

	@Test
	public void playWithInts() {
		System.out.println(IntStream.generate(incrementFrom(0)).limit(10000).filter(x -> x % 2 == 0)
				.summaryStatistics());

		System.out.println(IntStream.iterate(0, x -> x + 1).limit(10000).filter(x -> x % 2 == 0).summaryStatistics());

	}
}
