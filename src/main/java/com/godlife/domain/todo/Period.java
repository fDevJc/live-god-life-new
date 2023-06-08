package com.godlife.domain.todo;

import java.time.LocalDate;

public class Period {

	private final LocalDate startDate;
	private final LocalDate endDate;

	private Period(LocalDate startDate, LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public static Period of(LocalDate startDate, LocalDate endDate) {
		return new Period(startDate, endDate);
	}

	public boolean has(LocalDate date) {
		return date.isEqual(startDate) ||
			date.isEqual(endDate) ||
			(date.isAfter(startDate) &&
			date.isBefore(endDate));
	}
}
