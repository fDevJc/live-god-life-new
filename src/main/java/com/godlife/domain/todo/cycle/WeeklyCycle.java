package com.godlife.domain.todo.cycle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

import com.godlife.domain.todo.Cycle;

public class WeeklyCycle implements Cycle {
	private final List<DayOfWeek> dayOfWeeks;

	public WeeklyCycle(List<DayOfWeek> dayOfWeeks) {
		this.dayOfWeeks = dayOfWeeks;
	}

	@Override
	public boolean has(LocalDate targetDate) {
		return dayOfWeeks.contains(targetDate.getDayOfWeek());
	}

	@Override
	public int count(LocalDate startDate, LocalDate endDate) {
		return (int)IntStream.iterate(0, i -> i + 1)
			.limit(ChronoUnit.DAYS.between(startDate, endDate) + 1)
			.filter(i -> dayOfWeeks.contains(startDate.plusDays(i).getDayOfWeek()))
			.count();
	}
}
