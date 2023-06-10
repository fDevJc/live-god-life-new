package com.godlife.domain.todo.cycle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

import com.godlife.domain.todo.Cycle;

public class MonthlyCycle implements Cycle {
	private final List<Integer> days;

	public MonthlyCycle(List<Integer> days) {
		this.days = days;
	}

	@Override
	public boolean has(LocalDate targetDate) {
		return days.contains(targetDate.getDayOfMonth());
	}

	@Override
	public int count(LocalDate startDate, LocalDate endDate) {
		return (int)IntStream.iterate(0, i -> i + 1)
			.limit(ChronoUnit.DAYS.between(startDate, endDate) + 1)
			.filter(i -> days.contains(startDate.plusDays(i).getDayOfMonth()))
			.count();
	}
}
