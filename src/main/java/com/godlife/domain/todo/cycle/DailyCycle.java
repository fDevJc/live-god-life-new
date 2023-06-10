package com.godlife.domain.todo.cycle;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import com.godlife.domain.todo.Cycle;

public class DailyCycle implements Cycle {
	@Override
	public boolean has(LocalDate targetDate) {
		return true;
	}

	@Override
	public int count(LocalDate startDate, LocalDate endDate) {
		return (int)ChronoUnit.DAYS.between(startDate, endDate) + 1;
	}
}
