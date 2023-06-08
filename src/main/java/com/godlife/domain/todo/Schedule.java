package com.godlife.domain.todo;

import java.time.LocalDate;

public class Schedule {
	private LocalDate date;
	private CompleteStatus status;
	public Schedule(LocalDate date) {
		this.date = date;
	}

	public void completed() {
		this.status = CompleteStatus.COMPLETED;
	}

	public void deComplete() {
		this.status = CompleteStatus.NOT_COMPLETED;
	}

	public LocalDate date() {
		return date;
	}

	public boolean isCompleted() {
		return this.status.equals(CompleteStatus.COMPLETED);
	}
}
