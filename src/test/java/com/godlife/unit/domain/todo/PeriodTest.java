package com.godlife.unit.domain.todo;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.godlife.domain.todo.Period;

public class PeriodTest {
	@Test
	void hasTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2022, 1, 1);
		LocalDate endDate = LocalDate.of(2022, 12, 31);
		Period period = Period.of(startDate, endDate);

		//when && then
		assertThat(period.has(LocalDate.of(2022, 1, 1))).isTrue();
		assertThat(period.has(LocalDate.of(2022, 6, 1))).isTrue();
		assertThat(period.has(LocalDate.of(2022, 12, 31))).isTrue();
		assertThat(period.has(LocalDate.of(2023, 1, 1))).isFalse();
		assertThat(period.has(LocalDate.of(2023, 6, 8))).isFalse();
	}
}
