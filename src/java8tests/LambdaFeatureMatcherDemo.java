package java8tests;

import static java.time.DayOfWeek.MONDAY;
import static java8tests.LambdaFeatureMatcher.featureValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.hamcrest.Matcher;
import org.junit.Test;

public class LambdaFeatureMatcherDemo {

	@Test
	public void featureTest() {
		assertThat(LocalDate.of(2014, 1, 13), dayOfWeek(is(MONDAY)));
	}

	private LambdaFeatureMatcher<LocalDate, DayOfWeek> dayOfWeek(Matcher<DayOfWeek> subMatcher) {
		return featureValue(subMatcher, "Day of week", "Day of week", date -> date.getDayOfWeek());
	}
}
