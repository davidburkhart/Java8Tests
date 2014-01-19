package java8tests;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.Test;

public class StringTest {

	@Test
	public void join() {
		String result = Stream.of("Cats", "Dogs", "Horses").collect(joining(", "));
		assertThat(result, is("Cats, Dogs, Horses"));
	}

	@Test
	public void joinStatic() {
		String result = String.join(", ", "Cats", "Dogs", "Horses");
		assertThat(result, is("Cats, Dogs, Horses"));
	}

	@Test
	public void compareLowerCase() {
		String result = Stream.of("B", "c", "a").sorted(Comparator.<String, String> comparing(x -> x.toLowerCase()))
				.collect(joining(", "));
		assertThat(result, is("a, B, c"));
	}

	@Test
	public void compareLowerCaseLocalVariable() {
		String result = Stream.of("B", "c", "a").sorted(String.CASE_INSENSITIVE_ORDER).collect(joining(", "));
		assertThat(result, is("a, B, c"));
	}

}
