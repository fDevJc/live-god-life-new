package com.godlife.domain.todo.cycle;

import java.time.LocalDate;

import com.godlife.domain.todo.Cycle;

public class DailyCycle implements Cycle {
	@Override
	public boolean has(LocalDate targetDate) {
		return true;
	}
}
