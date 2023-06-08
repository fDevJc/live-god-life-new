package com.godlife.unit.domain.todo;

import static org.assertj.core.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.godlife.domain.todo.Todo;
import com.godlife.domain.todo.cycle.WeeklyCycle;

public class TodoTest {
	@Test
	void createTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2022, 1, 1);
		LocalDate endDate = LocalDate.of(2022, 12, 31);
		//when
		Todo todo = new Todo(startDate, endDate);
		//then
		assertThat(todo).isNotNull();
	}

	@Test
	void completedTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2022, 1, 1);
		LocalDate endDate = LocalDate.of(2022, 12, 31);
		Todo todo = new Todo(startDate, endDate);

		//when
		LocalDate targetDate = LocalDate.of(2022, 6, 8);
		todo.complete(targetDate);
		//then
		assertThat(todo.isCompleted(targetDate)).isTrue();
		//when
		todo.inComplete(targetDate);
		//then
		assertThat(todo.isCompleted(targetDate)).isFalse();
	}

	@Test
	void completeFailTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2022, 1, 1);
		LocalDate endDate = LocalDate.of(2022, 12, 31);
		Todo todo = new Todo(startDate, endDate);

		//when && then
		LocalDate targetDate = LocalDate.of(2023, 6, 8);
		assertThatThrownBy(() -> todo.complete(targetDate))
			.isExactlyInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> todo.inComplete(targetDate))
			.isExactlyInstanceOf(RuntimeException.class);
	}

	@Test
	void weeklyCycleTodoCompleteTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2023, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 12, 31);
		Todo todo = new Todo(startDate, endDate, new WeeklyCycle(List.of(DayOfWeek.THURSDAY)));
		//when
		LocalDate targetDate = LocalDate.of(2023, 6, 8);
		todo.complete(targetDate);
		//then
		assertThat(todo.isCompleted(targetDate)).isTrue();
	}

	@Test
	void weeklyCycleTodoCompleteFailTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2023, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 12, 31);
		Todo todo = new Todo(startDate, endDate, new WeeklyCycle(List.of(DayOfWeek.MONDAY)));
		//when
		assertThatThrownBy(() -> todo.complete(LocalDate.of(2023, 6, 8)))
			.isExactlyInstanceOf(RuntimeException.class);
	}
}
