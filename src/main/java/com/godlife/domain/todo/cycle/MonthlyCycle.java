package com.godlife.domain.todo.cycle;

import java.time.LocalDate;
import java.util.List;

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
}
