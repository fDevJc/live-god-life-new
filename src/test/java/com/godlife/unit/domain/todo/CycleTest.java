package com.godlife.unit.domain.todo;

import static org.assertj.core.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.godlife.domain.todo.Cycle;
import com.godlife.domain.todo.cycle.DailyCycle;
import com.godlife.domain.todo.cycle.MonthlyCycle;
import com.godlife.domain.todo.cycle.WeeklyCycle;

public class CycleTest {
	@Test
	void dailyCycleHasTest() throws Exception {
		//given
		Cycle cycle = new DailyCycle();

		//when
		LocalDate targetDate = LocalDate.of(2023, 6, 8);

		//then
		assertThat(cycle.has(targetDate)).isTrue();
	}

	@Test
	void weeklyCycleHasTest() throws Exception {
		//given
		List<DayOfWeek> dayOfWeeks = List.of(DayOfWeek.MONDAY, DayOfWeek.SATURDAY);

		Cycle cycle = new WeeklyCycle(dayOfWeeks);

		//when
		LocalDate mondayDate = LocalDate.of(2023, 6, 5);
		LocalDate tuesdayDate = LocalDate.of(2023, 6, 6);
		LocalDate wednesdayDate = LocalDate.of(2023, 6, 7);
		LocalDate thursdayDate = LocalDate.of(2023, 6, 8);
		LocalDate fridayDate = LocalDate.of(2023, 6, 9);
		LocalDate saturdayDate = LocalDate.of(2023, 6, 10);
		LocalDate sundayDate = LocalDate.of(2023, 6, 11);

		//then
		assertThat(cycle.has(mondayDate)).isTrue();
		assertThat(cycle.has(tuesdayDate)).isFalse();
		assertThat(cycle.has(wednesdayDate)).isFalse();
		assertThat(cycle.has(thursdayDate)).isFalse();
		assertThat(cycle.has(fridayDate)).isFalse();
		assertThat(cycle.has(saturdayDate)).isTrue();
		assertThat(cycle.has(sundayDate)).isFalse();
	}

	@Test
	void monthlyCycleHasTest() throws Exception {
		//given
		List<Integer> days = List.of(1, 7, 9, 13);
		Cycle cycle = new MonthlyCycle(days);

		//when
		assertThat(cycle.has(LocalDate.of(2023, 6, 1))).isTrue();
		assertThat(cycle.has(LocalDate.of(2023, 6, 2))).isFalse();
		assertThat(cycle.has(LocalDate.of(2023, 7, 1))).isTrue();

		assertThat(cycle.has(LocalDate.of(2023, 6, 6))).isFalse();
		assertThat(cycle.has(LocalDate.of(2023, 6, 7))).isTrue();

		assertThat(cycle.has(LocalDate.of(2023, 6, 9))).isTrue();

		assertThat(cycle.has(LocalDate.of(2023, 6, 13))).isTrue();
		assertThat(cycle.has(LocalDate.of(2023, 6, 14))).isFalse();
		//then
	}
}
