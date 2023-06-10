package com.godlife.unit.domain.todo;

import static org.assertj.core.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.godlife.domain.todo.Progress;
import com.godlife.domain.todo.Task;
import com.godlife.domain.todo.cycle.DailyCycle;
import com.godlife.domain.todo.cycle.WeeklyCycle;

public class TaskTest {
	@Test
	void createTest() throws Exception {
		Task task = TaskFactory.defaultTask();
		//then
		assertThat(task).isNotNull();
	}

	@Test
	void completedTest() throws Exception {
		//given
		Task task = TaskFactory.defaultTask();

		//when
		LocalDate targetDate = LocalDate.of(2023, 6, 8);
		task.complete(targetDate);
		//then
		assertThat(task.isCompleted(targetDate)).isTrue();
		//when
		task.inComplete(targetDate);
		//then
		assertThat(task.isCompleted(targetDate)).isFalse();
	}

	@Test
	void completeFailTest() throws Exception {
		//given
		Task task = TaskFactory.defaultTask();

		//when && then
		LocalDate targetDate = LocalDate.of(2022, 6, 8);
		assertThatThrownBy(() -> task.complete(targetDate))
			.isExactlyInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> task.inComplete(targetDate))
			.isExactlyInstanceOf(RuntimeException.class);
	}

	@Test
	void weeklyCycleTodoCompleteTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2023, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 12, 31);
		Task task = new Task(startDate, endDate, new WeeklyCycle(List.of(DayOfWeek.THURSDAY)));
		//when
		LocalDate targetDate = LocalDate.of(2023, 6, 8);
		task.complete(targetDate);
		//then
		assertThat(task.isCompleted(targetDate)).isTrue();
	}

	@Test
	void weeklyCycleTodoCompleteFailTest() throws Exception {
		//given
		LocalDate startDate = LocalDate.of(2023, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 12, 31);
		Task task = new Task(startDate, endDate, new WeeklyCycle(List.of(DayOfWeek.MONDAY)));
		//when
		assertThatThrownBy(() -> task.complete(LocalDate.of(2023, 6, 8)))
			.isExactlyInstanceOf(RuntimeException.class);
	}

	@Test
	void progressTest() throws Exception {
		//given
		Task task = TaskFactory.defaultTask();

		//when
		task.complete(LocalDate.of(2023, 1, 1));
		task.complete(LocalDate.of(2023, 6, 1));
		//then

		Progress progress1 = task.progress();
		assertThat(progress1.totalCount()).isEqualTo(365);
		assertThat(progress1.completedCount()).isEqualTo(2);

		task.complete(LocalDate.of(2023, 12, 25));
		Progress progress2 = task.progress();
		assertThat(progress2.totalCount()).isEqualTo(365);
		assertThat(progress2.completedCount()).isEqualTo(3);

	}
}
