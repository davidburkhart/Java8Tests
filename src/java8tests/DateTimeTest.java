package java8tests;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.stream.Stream;

import org.junit.Test;

public class DateTimeTest {

	@Test
	public void findNextSkippedLeapYears() throws Exception {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR).toFormatter();
		Stream.iterate(LocalDate.now(), date -> date.plusDays(1))
				.filter(date -> isLeapDay(date))
				.filter(date -> !isLeapDay(date.minusYears(4)))
				.map(date -> date.minusYears(4))
				.limit(100)
				.map(date -> date.format(formatter))
				.forEach(System.out::println);
	}

	private boolean isLeapDay(LocalDate date) {
		return date.getDayOfMonth() == 29 && date.getMonth() == Month.FEBRUARY;
	}
}
