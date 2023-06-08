package com.godlife.domain.todo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.godlife.domain.todo.cycle.DailyCycle;

public class Todo {
	private final Period period;

	private Set<LocalDate> schedules = new HashSet<>();
	private Cycle cycle;

	public Todo(LocalDate startDate, LocalDate endDate) {
		this(startDate, endDate, new DailyCycle());
	}

	public Todo(LocalDate startDate, LocalDate endDate, Cycle cycle) {
		this.period = Period.of(startDate, endDate);
		this.cycle = cycle;
	}

	public void complete(LocalDate date) {
		validationDate(date);
		schedules.add(date);
	}

	public void inComplete(LocalDate date) {
		validationDate(date);
		if (isCompleted(date)) {
			schedules.remove(date);
		}
	}

	public boolean isCompleted(LocalDate date) {
		validationDate(date);
		return schedules.contains(date);
	}

	private void validationDate(LocalDate date) {
		if (!period.has(date)) {
			throw new RuntimeException("기간내 없습니다");
		}
		if (!cycle.has(date)) {
			throw new RuntimeException("주기에 맞지않습니다");
		}
	}
}
