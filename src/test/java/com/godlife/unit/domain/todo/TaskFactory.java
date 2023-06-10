package com.godlife.unit.domain.todo;

import java.time.LocalDate;

import com.godlife.domain.todo.Task;

public class TaskFactory {
	public static Task defaultTask() {
		LocalDate startDate = LocalDate.of(2023, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 12, 31);
		return new Task(startDate, endDate);
	}
}
