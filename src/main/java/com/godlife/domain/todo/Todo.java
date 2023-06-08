package com.godlife.domain.todo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Todo {
	private Period period;
	private Cycle cycle;
	private LocalTime notificationTime;

	private List<Schedule> schedules = new ArrayList<>();

	public Todo(LocalDate startDate, LocalDate endDate, Cycle cycle, LocalTime notificationTime) {
		this.period = Period.of(startDate, endDate);
		this.cycle = cycle;
		this.notificationTime = notificationTime;
	}

	public void complete(LocalDate date) {
		if (!period.has(date)) {
			throw new RuntimeException("기간내 미포함");
		}
		Schedule schedule = new Schedule(date);
		schedule.completed();
		schedules.add(schedule);
	}

	public void deComplete(LocalDate date) {
		schedules.stream()
			.filter(schedule -> schedule.date().equals(date))
			.findAny()
			.ifPresentOrElse(schedule -> schedule.deComplete(), () -> new RuntimeException());
	}

	public boolean isCompleted(LocalDate date) {
		return schedules.stream()
			.filter(schedule -> schedule.date().equals(date))
			.findAny()
			.get().isCompleted();
	}
}
