package com.godlife.domain.todo;

import java.time.LocalDate;

public class Period {
	private LocalDate startDate;
	private LocalDate endDate;

	private Period(LocalDate startDate, LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public static Period of(LocalDate startDate, LocalDate endDate) {
		return new Period(startDate, endDate);
	}

	public boolean has(LocalDate date) {
		if (startDate.isEqual(date)||endDate.isEqual(date)||(startDate.isBefore(date) && endDate.isAfter(date))) {
			return true;
		}
		return false;
	}
}
