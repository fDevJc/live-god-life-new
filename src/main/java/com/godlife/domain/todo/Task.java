package com.godlife.domain.todo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.godlife.domain.todo.cycle.DailyCycle;

public class Task {
	private final Period period;
	private final Cycle cycle;
	private final Set<LocalDate> completedSchedule = new HashSet<>();
	private final int totalScheduleCount;

	public Task(LocalDate startDate, LocalDate endDate) {
		this(startDate, endDate, new DailyCycle());
	}

	public Task(LocalDate startDate, LocalDate endDate, Cycle cycle) {
		this.period = Period.of(startDate, endDate);
		this.cycle = cycle;
		this.totalScheduleCount = cycle.count(startDate, endDate);
	}

	public void complete(LocalDate date) {
		validationDate(date);
		completedSchedule.add(date);
	}

	public void inComplete(LocalDate date) {
		validationDate(date);
		if (isCompleted(date)) {
			completedSchedule.remove(date);
		}
	}

	public boolean isCompleted(LocalDate date) {
		validationDate(date);
		return completedSchedule.contains(date);
	}

	private void validationDate(LocalDate date) {
		if (!period.has(date)) {
			throw new RuntimeException("기간내 없습니다");
		}
		if (!cycle.has(date)) {
			throw new RuntimeException("주기에 맞지않습니다");
		}
	}

	public Progress progress() {
		return new Progress(totalScheduleCount, completedSchedule.size());
	}
}
