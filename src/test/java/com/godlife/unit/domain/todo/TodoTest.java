package com.godlife.unit.domain.todo;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.godlife.domain.todo.Cycle;
import com.godlife.domain.todo.Todo;

public class TodoTest {
	@Test
	void createTodoTest() throws Exception {
		Todo todo = new Todo(LocalDate.now(), LocalDate.now(), new Cycle(), LocalTime.now());
		assertThat(todo).isNotNull();
	}

	@Test
	void completeTodoTest() throws Exception {
		Todo todo = new Todo(LocalDate.now(), LocalDate.now(), new Cycle(), LocalTime.now());
		todo.complete(LocalDate.now());
		boolean status = todo.isCompleted(LocalDate.now());
		assertThat(status).isTrue();

		todo.deComplete(LocalDate.now());
		status = todo.isCompleted(LocalDate.now());
		assertThat(status).isFalse();
	}

	@Test
	void completedTodoFailureTest() throws Exception {
		Todo todo = new Todo(LocalDate.of(2022, 1, 1),
			LocalDate.of(2022, 12, 31), new Cycle(), LocalTime.now());

		assertThatThrownBy(() -> todo.complete(LocalDate.now()))
			.isExactlyInstanceOf(RuntimeException.class);
	}
}
