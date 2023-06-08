package com.godlife.domain.todo.cycle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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
}
