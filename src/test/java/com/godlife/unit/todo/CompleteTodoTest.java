package com.godlife.unit.todo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.godlife.todo.EveryDayTermPolicy;
import com.godlife.todo.TermPolicy;
import com.godlife.todo.Todo;

public class CompleteTodoTest {
	@Test
	void completeTodo() throws Exception {
		LocalDate startDate = LocalDate.of(2023, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 12, 31);
		TermPolicy termPolicy = new EveryDayTermPolicy();

	    Todo todo = new Todo(startDate,endDate, termPolicy);
		todo.complete(LocalDate.now());
	}
}
