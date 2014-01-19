package java8tests;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

public class FibonacciGenerator {

	@Test
	public void generateWithLongs() {
		Stream.iterate(new long[] { 1, 0, 1 }, x -> new long[] { x[0] + 1, x[2], x[1] + x[2] }).limit(100)
				.map(x -> x[0] + ": " + x[2]).forEach(System.out::println);
	}

	@Test
	public void findOverflowWithLongs() {
		System.out.println("Overflow Long:");
		Stream.iterate(new long[] { 1, 0, 1 }, x -> new long[] { x[0] + 1, x[2], x[1] + x[2] }).filter(x -> x[2] < 0)
				.findFirst().map(x -> x[0] + ": " + x[2]).ifPresent(System.out::println);
	}

	@Test
	public void generateWithBigInts() {
		Stream.iterate(new BigInteger[] { ONE, ZERO, ONE },
				x -> new BigInteger[] { x[0].add(ONE), x[2], x[1].add(x[2]) }).limit(100000)
				.map(x -> x[0] + ": " + x[2].toString().length()).forEach(System.out::println);
	}

	@Test
	@Ignore("Will terminate?")
	public void findOverflowWithBigInts() {
		System.out.println("Overflow BigInts:");
		Stream.iterate(new BigInteger[] { ONE, ZERO, ONE },
				x -> new BigInteger[] { x[0].add(ONE), x[2], x[1].add(x[2]) }).filter(x -> x[2].signum() < 0)
				.findFirst().map(x -> x[0] + ": " + x[2]).ifPresent(System.out::println);
	}
}
